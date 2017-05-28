package com.bjike.reborn.shop.action.shop;

import com.bjike.reborn.common.api.entity.ADD;
import com.bjike.reborn.common.api.entity.EDIT;
import com.bjike.reborn.common.api.exception.ActException;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.restful.Result;
import com.bjike.reborn.common.consumer.restful.ActResult;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.shop.api.ShopAPI;
import com.bjike.reborn.shop.bo.ShopBO;
import com.bjike.reborn.shop.dto.ShopDTO;
import com.bjike.reborn.shop.to.ShopTO;
import com.bjike.reborn.shop.vo.ShopVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 店铺
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-23 10:37 ]
 * @Description: [ 店铺 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@RestController
public class ShopAction {
    @Autowired
    private ShopAPI shopAPI;

    @GetMapping("v1/list")
    public Result list(ShopDTO dto) throws ActException {
        try {
            List<ShopBO> shopBOS = shopAPI.list(dto);
            return ActResult.initialize(BeanTransform.copyProperties(shopBOS, ShopVO.class));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PostMapping("v1/add")
    public Result add(@Validated({ADD.class}) ShopTO to, BindingResult result) throws ActException {
        try {
            shopAPI.add(to);
            return new ActResult("add success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PutMapping("v1/edit")
    public Result edit(@Validated({EDIT.class}) ShopTO to, BindingResult result) throws ActException {
        try {
            shopAPI.edit(to);
            return new ActResult("edit success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @DeleteMapping("v1/delete/{id}")
    public Result delete(@PathVariable String id) throws ActException {
        try {
            shopAPI.delete(id);
            return new ActResult("delete success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

}