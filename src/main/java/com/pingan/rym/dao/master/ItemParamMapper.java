package com.pingan.rym.dao.master;


import com.pingan.rym.dto.ItemParamDTO;
import com.pingan.rym.dto.ItemParamDTO2;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
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

    @Select("select * from tb_item_param_group")
    @Results(id="item",value = {
            @Result(property = "id",column ="id" ,jdbcType =JdbcType.INTEGER),
            @Result(property = "groupName",column ="group_name" ,jdbcType =JdbcType.VARCHAR),
            @Result(property = "itemCatId",column ="item_cat_id" ,jdbcType =JdbcType.VARCHAR)
    })
    @ResultMap("item")
    List<ItemParamDTO2> getItemParamsList();
}
