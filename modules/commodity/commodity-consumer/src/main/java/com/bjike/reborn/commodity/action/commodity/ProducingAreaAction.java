package com.bjike.reborn.commodity.action.commodity;

import com.bjike.reborn.commodity.api.ProducingAreaAPI;
import com.bjike.reborn.commodity.bo.ProducingAreaBO;
import com.bjike.reborn.commodity.dto.ProducingAreaDTO;
import com.bjike.reborn.commodity.to.ProducingAreaTO;
import com.bjike.reborn.commodity.vo.ProducingAreaVO;
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
 * 产地
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:55 ]
 * @Description: [ 产地 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@RestController
@RequestMapping("producing-area")
public class ProducingAreaAction {
    @Autowired
    private ProducingAreaAPI producingAreaAPI;

    /**
     * 产地列表
     *
     * @version v1
     */
    @GetMapping("v1/list")
    public Result list(ProducingAreaDTO dto, HttpServletRequest request) throws ActException {
        try {
            List<ProducingAreaBO> producingAreaBOS = producingAreaAPI.list(dto);
            return ActResult.initialize(BeanTransform.copyProperties(producingAreaBOS, ProducingAreaVO.class, request));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PostMapping("v1/add")
    public Result add(@Validated({ADD.class}) ProducingAreaTO to, BindingResult result) throws ActException {
        try {
            producingAreaAPI.add(to);
            return new ActResult("add success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @PutMapping("v1/edit")
    public Result edit(@Validated({EDIT.class}) ProducingAreaTO to, BindingResult result) throws ActException {
        try {
            producingAreaAPI.edit(to);
            return new ActResult("edit success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    @DeleteMapping("v1/delete/{id}")
    public Result delete(@PathVariable String id) throws ActException {
        try {
            producingAreaAPI.delete(id);
            return new ActResult("delete success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

}