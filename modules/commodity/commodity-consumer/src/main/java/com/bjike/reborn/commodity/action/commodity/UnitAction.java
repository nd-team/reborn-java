package com.bjike.reborn.commodity.action.commodity;

import com.bjike.reborn.commodity.api.UnitAPI;
import com.bjike.reborn.commodity.bo.UnitBO;
import com.bjike.reborn.commodity.dto.UnitDTO;
import com.bjike.reborn.commodity.to.UnitTO;
import com.bjike.reborn.commodity.vo.UnitVO;
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
 * 单位
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:56 ]
 * @Description: [ 单位 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@RestController
@RequestMapping("unit")
public class UnitAction {
    @Autowired
    private UnitAPI unitAPI;

    /**
     * 单位列表
     *
     * @version v1
     */
    @GetMapping("v1/list")
    public Result list(UnitDTO dto, HttpServletRequest request) throws ActException {
        try {
            List<UnitBO> unitBOS = unitAPI.list(dto);
            return ActResult.initialize(BeanTransform.copyProperties(unitBOS, UnitVO.class, request));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PostMapping("v1/add")
    public Result add(@Validated({ADD.class}) UnitTO to, BindingResult result) throws ActException {
        try {
            unitAPI.add(to);
            return new ActResult("add success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PutMapping("v1/edit")
    public Result edit(@Validated({EDIT.class}) UnitTO to, BindingResult result) throws ActException {
        try {
            unitAPI.edit(to);
            return new ActResult("edit success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @DeleteMapping("v1/delete/{id}")
    public Result delete(@PathVariable String id) throws ActException {
        try {
            unitAPI.delete(id);
            return new ActResult("delete success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

}