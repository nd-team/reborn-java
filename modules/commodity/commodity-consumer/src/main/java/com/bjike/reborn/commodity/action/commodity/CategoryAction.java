package com.bjike.reborn.commodity.action.commodity;

import com.bjike.reborn.commodity.api.CategoryAPI;
import com.bjike.reborn.commodity.bo.CategoryBO;
import com.bjike.reborn.commodity.dto.CategoryDTO;
import com.bjike.reborn.commodity.to.CategoryTO;
import com.bjike.reborn.commodity.vo.BrandVO;
import com.bjike.reborn.commodity.vo.CategoryVO;
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
 * 商品分类
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:08 ]
 * @Description: [ 商品分类 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@RestController
@RequestMapping("category")
public class CategoryAction {
    @Autowired
    private CategoryAPI categoryAPI;

    /**
     * 商品分类列表
     *
     * @version v1
     */
    @GetMapping("v1/list")
    public Result list(CategoryDTO dto, HttpServletRequest request) throws ActException {
        try {
            List<CategoryBO> categories = categoryAPI.list(dto);
            return ActResult.initialize(BeanTransform.copyProperties(categories, CategoryVO.class, request));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PostMapping("v1/add")
    public Result add(@Validated({ADD.class}) CategoryTO to, BindingResult result) throws ActException {
        try {
            categoryAPI.add(to);
            return new ActResult("add success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PutMapping("v1/edit")
    public Result edit(@Validated({EDIT.class}) CategoryTO to, BindingResult result) throws ActException {
        try {
            categoryAPI.edit(to);
            return new ActResult("edit success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @DeleteMapping("v1/delete/{id}")
    public Result delete(@PathVariable String id) throws ActException {
        try {
            categoryAPI.delete(id);
            return new ActResult("delete success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

}