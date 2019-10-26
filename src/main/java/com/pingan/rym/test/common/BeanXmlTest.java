package com.pingan.rym.test.common;

import com.pingan.rym.utils.XmlUtil;

import javax.xml.bind.JAXBException;

/**
 * @author 刘欣武
 * @version $Id: BeanXmlTest, v 0.1 2019/7/11 17:44 刘欣武 Exp$
 */
public class BeanXmlTest {

    public static void main(String[] args) throws JAXBException{

        UserInfo info = new UserInfo(2, 22, "qq", "female");

        String xml = XmlUtil.beanToXml(info,UserInfo.class);
        System.out.println(xml);

        UserInfo o = (UserInfo)XmlUtil.xmlToBean(xml, UserInfo.class);
        System.out.println(o.toString());
    }



}


