package com.bjike.reborn.commodity.action.commodity;

import com.bjike.reborn.commodity.api.BrandAPI;
import com.bjike.reborn.commodity.bo.BrandBO;
import com.bjike.reborn.commodity.dto.BrandDTO;
import com.bjike.reborn.commodity.entity.Brand;
import com.bjike.reborn.commodity.to.BrandTO;
import com.bjike.reborn.commodity.vo.BrandVO;
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
 * 品牌
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:55 ]
 * @Description: [ 品牌 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@RestController
@RequestMapping("brand")
public class BrandAction {
    @Autowired
    private BrandAPI brandAPI;

    /**
     * 品牌列表
     *
     * @version v1
     */
    @GetMapping("v1/list")
    public Result list(BrandDTO dto, HttpServletRequest request) throws ActException {
        try {
            List<BrandBO> brandBOS = brandAPI.list(dto);
            return ActResult.initialize(BeanTransform.copyProperties(brandBOS, BrandVO.class, request));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PostMapping("v1/add")
    public Result add(@Validated({ADD.class}) BrandTO to, BindingResult result) throws ActException {
        try {
            brandAPI.add(to);
            return new ActResult("add success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PutMapping("v1/edit")
    public Result edit(@Validated({EDIT.class}) BrandTO to, BindingResult result) throws ActException {
        try {
            brandAPI.edit(to);
            return new ActResult("edit success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @DeleteMapping("v1/delete/{id}")
    public Result delete(@PathVariable String id) throws ActException {
        try {
            brandAPI.delete(id);
            return new ActResult("delete success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }


}