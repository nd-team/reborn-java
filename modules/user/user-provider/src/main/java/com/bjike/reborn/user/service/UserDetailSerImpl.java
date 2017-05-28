package com.bjike.reborn.user.service;


import com.bjike.reborn.common.api.dto.Restrict;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.type.Status;
import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.common.jpa.utils.PasswordHash;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.common.utils.excel.Excel;
import com.bjike.reborn.common.utils.excel.ExcelUtil;
import com.bjike.reborn.user.bo.UserBO;
import com.bjike.reborn.user.bo.UserDetailBO;
import com.bjike.reborn.user.dto.UserDetailDTO;
import com.bjike.reborn.user.entity.Department;
import com.bjike.reborn.user.entity.User;
import com.bjike.reborn.user.entity.UserDetail;
import com.bjike.reborn.user.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 部门业务实现
 *
 * @Author: [liguiqin]
 * @Date: [2016-12-28 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@CacheConfig(cacheNames = "userSerCache")
@Service
public class UserDetailSerImpl extends ServiceImpl<UserDetail, UserDetailDTO> implements UserDetailSer {
    @Autowired
    private DepartmentSer departmentSer;
    @Autowired
    private UserSer userSer;


    @Transactional
    @Override
    public void update(UserTO userTO) throws SerException {
        UserDetailDTO dto = new UserDetailDTO();
        UserBO userBO = userSer.currentUser();
        User user = userSer.findById(userBO.getId());
        user.setUsername(userTO.getUsername());
        try {
            user.setPassword(PasswordHash.createHash(user.getPassword()));
            userSer.update(user);
        } catch (Exception e) {
            throw new SerException(e.getMessage());
        }
        dto.getConditions().add(Restrict.eq("user.id", userBO.getId()));
        UserDetail userDetail = super.findOne(dto);
        if (null != userDetail) {
            BeanTransform.copyProperties(userTO, userDetail, true, "id");
            userDetail.setDepartment(departmentSer.findById(userTO.getDepartmentId()));
            super.update(userDetail);
        } else {
            userDetail = new UserDetail();
            BeanTransform.copyProperties(userTO, userDetail);
            userDetail.setUser(user);
            userDetail.setDepartment(departmentSer.findById(userTO.getDepartmentId()));
            userDetail.setModifyTime(LocalDateTime.now());
            super.save(userDetail);
        }


    }

    @Override
    public UserDetailBO findByUserId(String userId) throws SerException {
        UserDetailDTO detailDTO = new UserDetailDTO();
        detailDTO.getConditions().add(Restrict.eq("user.id", userId));
        UserDetail detail = super.findOne(detailDTO);
        if (null != detail) {
            UserDetailBO userDetailBO = BeanTransform.copyProperties(detail, UserDetailBO.class);
            Department department = detail.getDepartment();
            if (null != department) {
            }

            return userDetailBO;
        }

        return null;
    }

    @Override
    public List<UserDetailBO> employees(UserDetailDTO detailDTO) throws SerException {
        String sysNO = userSer.currentSysNO();
        detailDTO.getConditions().add(Restrict.eq("user.systemNO", sysNO));
        detailDTO.getConditions().add(Restrict.ne("user.status", Status.DELETE));
        List<UserDetail> userDetails = super.findByCis(detailDTO);
        List<UserDetailBO> detailBOS = BeanTransform.copyProperties(userDetails, UserDetailBO.class);
        for (int i = 0; i < detailBOS.size(); i++) {
            UserDetail detail = userDetails.get(i);
            UserDetailBO detailBO = detailBOS.get(i);
            if (detail.getId().equals(detailBO.getId())) {
                detailBO.setUsername(detail.getUser().getUsername());
                detailBO.setId(detail.getUser().getId());
            }
        }
        return detailBOS;
    }

    @Override
    public Long employeesCount(UserDetailDTO detailDTO) throws SerException {
        String sysNO = userSer.currentSysNO();
        detailDTO.getConditions().add(Restrict.eq("user.systemNO", sysNO));
        detailDTO.getConditions().add(Restrict.ne("user.status", Status.DELETE));
        return super.count(detailDTO);
    }

    @Override
    public byte[] export(UserDetailDTO detailDTO) throws SerException {
        List<UserDetailBO> userDetailBOS = this.employees(detailDTO);
        Excel excel = new Excel(0, 1);
        return ExcelUtil.clazzToExcel(userDetailBOS, excel);
    }
}
