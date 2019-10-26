package com.pingan.rym.dto;


import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * @author 刘欣武
 * @version $Id: PersonDTO, v 0.1 2018/9/30 9:38 刘欣武 Exp$
 */
@Data
public class PersonDTO {

    private String id;
    private String name;
    @Range(min = 1,max = 100,message = "年龄输入不正确")
    private int age;
    private String address;
    private String birthday;


}


