package com.pingan.rym;

import com.pingan.rym.dao.second.PersonMapper;
import com.pingan.rym.dto.ItemParamDTO;
import com.pingan.rym.dto.ItemParamDTO2;
import com.pingan.rym.dto.PersonDTO;
import com.pingan.rym.dao.master.ItemParamMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 刘欣武
 * @version $Id: MyBatisTest, v 0.1 2019/6/25 11:21 刘欣武 Exp$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {

//    @Autowired
//    private ItemParamMapper itemParamMapper;
//
//    @Test
//    public void testFind(){
//
//        ItemParamDTO dto = itemParamMapper.getOne(12);
//        System.out.println(dto.getGroup_name());
//
//    }

    @Autowired
    private PersonMapper personMapper;
    @Test
    public void testFindInSeondDataBase(){

        List<PersonDTO> persons = personMapper.getPersons();
        persons.stream().forEach(dto->System.out.println(dto.getName()));

    }

    @Autowired
    private ItemParamMapper itemParamMapper;
    @Test
    public void testA(){
        List<ItemParamDTO2> list = itemParamMapper.getItemParamsListFuck();
        list.stream().forEach(dto->System.out.println(dto.getGroupName()));
    }

}


