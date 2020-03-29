package com.pingan.rym.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.pingan.rym.dao.master.ItemParamMapper;
import com.pingan.rym.dto.ItemParamDTO;
import com.pingan.rym.dto.ItemParamDTO2;
import com.pingan.rym.service.ItemParamService;
import com.pingan.rym.utils.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 刘欣武
 * @version $Id: MasterController, v 0.1 2020/3/27 19:57 刘欣武 Exp$
 */
@RestController
@RequestMapping("/master")
@Api("Master数据库api")
public class MasterController {

    @Autowired
    private ItemParamService itemParamService;

    @GetMapping("/page")
    @ApiOperation(value="test page")
    public ResultMap testPage(){
        ResultMap r = new ResultMap();
        PageHelper.startPage(2,3);
        List<ItemParamDTO> datas = itemParamService.getItemParams();
        r.setData(datas);
        return r;

    }


}


