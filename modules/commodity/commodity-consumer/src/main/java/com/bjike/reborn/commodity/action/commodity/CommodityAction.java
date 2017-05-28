package com.bjike.reborn.commodity.action.commodity;

import com.bjike.reborn.commodity.api.CommodityAPI;
import com.bjike.reborn.commodity.bo.CommodityBO;
import com.bjike.reborn.commodity.dto.CommodityDTO;
import com.bjike.reborn.commodity.to.CommodityTO;
import com.bjike.reborn.commodity.vo.BrandVO;
import com.bjike.reborn.commodity.vo.CommodityVO;
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
 * 商品
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:23 ]
 * @Description: [ 商品 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@RestController
@RequestMapping("commodity")
public class CommodityAction {
    @Autowired
    private CommodityAPI commodityAPI;

    /**
     * 商品列表
     *
     * @version v1
     */
    @GetMapping("v1/list")
    public Result list(CommodityDTO dto, HttpServletRequest request) throws ActException {
        try {
            List<CommodityBO> commodityBOS = commodityAPI.list(dto);
            return ActResult.initialize(BeanTransform.copyProperties(commodityBOS, CommodityVO.class, request));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PostMapping("v1/add")
    public Result add(@Validated({ADD.class}) CommodityTO to, BindingResult result) throws ActException {
        try {
            commodityAPI.add(to);
            return new ActResult("add success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PutMapping("v1/edit")
    public Result edit(@Validated({EDIT.class}) CommodityTO to, BindingResult result) throws ActException {
        try {
            commodityAPI.edit(to);
            return new ActResult("edit success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @DeleteMapping("v1/delete/{id}")
    public Result delete(@PathVariable String id) throws ActException {
        try {
            commodityAPI.delete(id);
            return new ActResult("delete success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

}