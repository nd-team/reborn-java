package com.bjike.reborn.user.action.user;

import com.bjike.reborn.common.api.exception.ActException;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.restful.Result;
import com.bjike.reborn.common.consumer.action.BaseFileAction;
import com.bjike.reborn.common.consumer.restful.ActResult;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.user.api.UserAPI;
import com.bjike.reborn.user.api.UserDetailAPI;
import com.bjike.reborn.user.bo.UserBO;
import com.bjike.reborn.user.bo.UserDetailBO;
import com.bjike.reborn.user.dto.UserDetailDTO;
import com.bjike.reborn.user.entity.UserDetail;
import com.bjike.reborn.user.to.UserDetailTO;
import com.bjike.reborn.user.to.UserTO;
import com.bjike.reborn.user.vo.UserDetailVO;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: [liguiqin]
 * @Date: [2017-05-19 15:04]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@DefaultProperties
@RestController
@RequestMapping("employees")
public class EmployeeAct extends BaseFileAction{
    @Autowired
    private UserDetailAPI userDetailAPI;
    @Autowired
    private UserAPI userAPI;

    /**
     * 员工详情列表
     *
     * @param detailDTO
     * @version v1
     */
    @GetMapping("v1/list")
    public Result employee(UserDetailDTO detailDTO, HttpServletRequest request) throws ActException {
        try {
            List<UserDetailBO> detailBOS = userDetailAPI.employees(detailDTO);
            return ActResult.initialize(BeanTransform.copyProperties(detailBOS, UserDetailVO.class,request));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * 员工数
     *
     * @param detailDTO
     * @version v1
     */
    @GetMapping("v1/count")
    public Result employeeCount(UserDetailDTO detailDTO) throws ActException {
        try {
            return ActResult.initialize(userDetailAPI.employeesCount(detailDTO));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }


    /**
     * 添加员工
     *
     * @param userTO 新员工
     * @version v1
     */
    @PostMapping("v1/add")
    public Result add(UserTO userTO) throws ActException {
        try {
            userAPI.add(null, userTO);
            return ActResult.initialize("add success!");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * 更新员工
     *
     * @param userTO 新员工
     * @version v1
     */
    @PutMapping("v1/edit")
    public Result edit(UserTO userTO) throws ActException {
        try {
            userDetailAPI.update(userTO);
            return ActResult.initialize("update success!");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * 删除员工
     *
     * @param id 员工
     * @version v1
     */
    @DeleteMapping("v1/delete/{id}")
    public Result delete(@PathVariable String id) throws ActException {
        try {
            userAPI.delete(id);
            return ActResult.initialize("delete success!");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * 导出员工
     *
     * @param detailDTO
     * @version v1
     */
    @GetMapping("v1/export")
    public Result export(UserDetailDTO detailDTO, HttpServletResponse response) throws ActException {
        try {
            byte[] bytes = userDetailAPI.export(detailDTO);
            super.writeOutFile(response,bytes,"员工汇总.xlsx");
            return ActResult.initialize("export success!");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

}
