package com.pingan.rym.dao.second;


import com.pingan.rym.dto.PersonDTO;
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
public interface PersonMapper {

    @Select("select * from person")
    List<PersonDTO> getPersons();

}
