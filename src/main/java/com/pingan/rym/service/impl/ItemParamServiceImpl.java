package com.pingan.rym.service.impl;

import com.pingan.rym.dao.master.ItemParamMapper;
import com.pingan.rym.dto.ItemParamDTO;
import com.pingan.rym.dto.ItemParamDTO2;
import com.pingan.rym.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘欣武
 * @version $Id: ItemParamServiceImpl, v 0.1 2020/3/27 22:15 刘欣武 Exp$
 */
@Service
public class ItemParamServiceImpl implements ItemParamService{

    @Autowired
    private ItemParamMapper itemParamMapper;

    public List<ItemParamDTO> getItemParams(){
        return itemParamMapper.getItemParams();
    }

    public List<ItemParamDTO2> getItemParamsList(){
        return itemParamMapper.getItemParamsList();
    }
}


