package com.pingan.rym.mapper;


import com.pingan.rym.dto.ItemParamDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 刘欣武
 * @version $Id: ItemParamMapper, v 0.1 2019/6/25 11:29 刘欣武 Exp$
 */
@Mapper
@Repository
public interface ItemParamMapper {

    @Select("select * from tb_item_param_group")
    List<ItemParamDTO> getItemParams();

    ItemParamDTO getOne(Integer id);
}
