package com.pingan.rym.service;

import com.pingan.rym.dto.ItemParamDTO;
import com.pingan.rym.dto.ItemParamDTO2;

import java.util.List;

/**
 * @author 刘欣武
 * @version $Id: ItemParamService, v 0.1 2020/3/27 22:13 刘欣武 Exp$
 */
public interface ItemParamService {

    List<ItemParamDTO> getItemParams();
    List<ItemParamDTO2> getItemParamsList();

}


