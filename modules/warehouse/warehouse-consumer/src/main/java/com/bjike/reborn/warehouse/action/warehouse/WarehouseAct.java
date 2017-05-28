package com.bjike.reborn.warehouse.action.warehouse;

import com.bjike.reborn.common.api.entity.ADD;
import com.bjike.reborn.common.api.entity.EDIT;
import com.bjike.reborn.common.api.exception.ActException;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.restful.Result;
import com.bjike.reborn.common.consumer.interceptor.login.LoginAuth;
import com.bjike.reborn.common.consumer.restful.ActResult;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.warehouse.api.WarehouseAPI;
import com.bjike.reborn.warehouse.bo.WarehouseBO;
import com.bjike.reborn.warehouse.dto.WarehouseDTO;
import com.bjike.reborn.warehouse.to.WarehouseTO;
import com.bjike.reborn.warehouse.vo.WarehouseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: [liguiqin]
 * @Date: [2017-05-23 14:00]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@LoginAuth
@RestController
public class WarehouseAct {
    @Autowired
    private WarehouseAPI warehouseAPI;

    @GetMapping("v1/list")
    public Result list(WarehouseDTO dto) throws ActException {
        try {
            List<WarehouseBO> warehouseBOS = warehouseAPI.list(dto);
            return ActResult.initialize(BeanTransform.copyProperties(warehouseBOS, WarehouseVO.class));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PostMapping("v1/add")
    public Result add(@Validated({ADD.class}) WarehouseTO to, BindingResult result) throws ActException {
        try {
            warehouseAPI.add(to);
            return new ActResult("add success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PutMapping("v1/edit")
    public Result edit(@Validated({EDIT.class}) WarehouseTO to, BindingResult result) throws ActException {
        try {
            warehouseAPI.edit(to);
            return new ActResult("edit success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @DeleteMapping("v1/delete/{id}")
    public Result delete(@PathVariable String id) throws ActException {
        try {
            warehouseAPI.delete(id);
            return new ActResult("delete success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }
}
