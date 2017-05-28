package com.bjike.reborn.commodity.action.express;

import com.bjike.reborn.commodity.api.ExpressAPI;
import com.bjike.reborn.commodity.bo.ExpressBO;
import com.bjike.reborn.commodity.dto.ExpressDTO;
import com.bjike.reborn.commodity.to.ExpressTO;
import com.bjike.reborn.commodity.vo.ExpressVO;
import com.bjike.reborn.common.api.entity.ADD;
import com.bjike.reborn.common.api.entity.EDIT;
import com.bjike.reborn.common.api.exception.ActException;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.restful.Result;
import com.bjike.reborn.common.consumer.restful.ActResult;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 快递
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 03:16 ]
 * @Description: [ 快递 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@RestController
@RequestMapping("express")
public class ExpressAction {
    @Autowired
    private ExpressAPI expressAPI;

    /**
     * 快递列表
     *
     * @version v1
     */
    @GetMapping("v1/list")
    public Result list(ExpressDTO dto, HttpServletRequest request) throws ActException {
        try {
            List<ExpressBO> expressBOS = expressAPI.list(dto);
            return ActResult.initialize(BeanTransform.copyProperties(expressBOS, ExpressVO.class, request));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PostMapping("v1/add")
    public Result add(@Validated({ADD.class}) ExpressTO to, BindingResult result) throws ActException {
        try {
            expressAPI.add(to);
            return new ActResult("add success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PutMapping("v1/edit")
    public Result edit(@Validated({EDIT.class}) ExpressTO to, BindingResult result) throws ActException {
        try {
            expressAPI.edit(to);
            return new ActResult("edit success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @DeleteMapping("v1/delete/{id}")
    public Result delete(@PathVariable String id) throws ActException {
        try {
            expressAPI.delete(id);
            return new ActResult("delete success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }


}