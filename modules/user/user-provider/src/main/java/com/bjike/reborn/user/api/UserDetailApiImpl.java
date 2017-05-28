package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.user.bo.UserDetailBO;
import com.bjike.reborn.user.dto.UserDetailDTO;
import com.bjike.reborn.user.entity.UserDetail;
import com.bjike.reborn.user.service.UserDetailSer;
import com.bjike.reborn.user.to.UserDetailTO;
import com.bjike.reborn.user.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: [liguiqin]
 * @Date: [2017-03-11 15:54]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service("userDetailApiImpl")
public class UserDetailApiImpl implements UserDetailAPI {
    @Autowired
    private UserDetailSer userDetailSer;

    @Override
    public List<UserDetailBO> employees(UserDetailDTO detailDTO) throws SerException {
        return userDetailSer.employees(detailDTO);
    }

    @Override
    public Long employeesCount(UserDetailDTO detailDTO) throws SerException {
        return userDetailSer.employeesCount(detailDTO);
    }

    @Override
    public void update(UserTO userTO) throws SerException {
        userDetailSer.update(userTO);
    }

    @Override
    public UserDetailBO findByUserId(String userId) throws SerException {
        return userDetailSer.findByUserId(userId);
    }

    @Override
    public byte[] export(UserDetailDTO detailDTO) throws SerException {
        return userDetailSer.export(detailDTO) ;
    }
}
