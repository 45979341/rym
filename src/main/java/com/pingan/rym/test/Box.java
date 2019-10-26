package com.pingan.rym.test;

import com.pingan.rym.dto.PersonDTO;

/**
 * @author 刘欣武
 * @version $Id: Box, v 0.1 2019/7/24 9:20 刘欣武 Exp$
 * 测试泛型例子
 * 省去了强制转换，可以在编译时候检查类型安全，可以用在类，方法，接口上
 *
 *
？ 表示不确定的java类型
T (type) 表示具体的一个java类型
K V (key value) 分别代表java键值中的Key Value
E (element) 代表Element
 *
 */
public class Box<T>  {

    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }


    public static void main(String[] args){

        Box box = new Box();
        box.setObject(new PersonDTO());
        PersonDTO object = (PersonDTO) box.getObject();


        Box<PersonDTO> box2 = new Box<>();
        box2.setObject(new PersonDTO());
        PersonDTO object1 = box2.getObject();
    }
}


