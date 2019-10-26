package com.pingan.rym.test.common;

import com.pingan.rym.dto.PersonDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 刘欣武
 * @version $Id: Test, v 0.1 2019/3/25 9:21 刘欣武 Exp$
 */
public class Test {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args){
//        Map<String,String> map  = new HashMap<>();
//        map.put("1","liuxinwu");
//        map.put("3","lizhipeng");
//        map.put("2","songbei");
//        map.put("4","liangxi");
//        map.put("5","longhui");
//        //
//        for(String key:map.keySet()){
//            String value = map.get(key);
//            System.out.println("1方式:"+value);
//        }
//        for(Map.Entry<String,String> entry:map.entrySet()){
//            System.out.println("2方式:"+entry.getValue());
//        }
//        Set<String> set = new HashSet<>();
//        List<String> list = new ArrayList<>()
//;
//        Iterator<String> iterator = map.keySet().iterator();
//
//        Double a = 5.662;
//        Double c = 7.662;
//        long b = (long)(double)a+(long)(double)c;
//        System.out.println(b);
        new PersonDTO().setAge(33);
        Integer ss = null;
        String bb = null;
        if(StringUtils.isNotBlank(ss.intValue()+"")){
            System.out.println("bb 是空的");
        }


        List<UserInfo> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            UserInfo user = new UserInfo();
            user.setId(i);
            user.setAge(20+i);
            user.setName("test"+i);
            if(i<5){
                user.setSex("male");
            }else{
                user.setSex("female");
            }
            list.add(user);
        }

        Map<Integer, List<UserInfo>> collect = list.stream().collect(Collectors.groupingBy(dto -> dto.getId()));
        List<UserInfo> result = collect.get(11);
        if(result!=null){
            System.out.println("结果不为空：size为："+result.size());
        }else{
            System.out.println("结果为空");
        }
        String dd = "1.66";
        System.out.println((long)Double.parseDouble(dd));
        //四舍五入取整
        long add = Math.round(1.66);
        System.out.println(add);


        String mon = "2018年01月";
        String dcd = mon.substring(0,4)+"-"+mon.substring(5,7);
        System.out.println(dcd);

//        //for循环
//        List<String> collect1 = list.stream().skip(1).limit(5).filter(dto->{
//            boolean bool = false;
//            int id = dto.getId();
//            if(id>=5){
//                bool = true;
//            }
//            return bool;
//        }).map(dto -> {
//            return dto.getName() + dto.getSex();
//        }).collect(Collectors.toList());
//        Map<String, List<UserInfo>> collect2 = list.stream().collect(Collectors.groupingBy(dto -> dto.getSex()));
//        for(Map.Entry<String, List<UserInfo>> entry:collect2.entrySet()){
//            String key = entry.getKey();
//            int a = entry.getValue().stream().mapToInt(dto->dto.getId()).sum();
//            System.out.println(a);
//        }
//        collect1.stream().forEach(dto->{
//            System.out.println(dto);
//        });
//        Set<UserInfo> userInfos = new HashSet<>();
//        String[] names = new String[]{"liuxinwu","lizhipeng","liuxinwu","songbei"};
//        for(String name:names){
//            UserInfo user = new UserInfo();
//            user.setName(name);
//            userInfos.add(user);
//        }
//        System.out.println(userInfos.size());
//        userInfos.stream().forEach(user->System.out.println(user.getName()));


    }
}
@XmlRootElement(name="UserInfo")
class UserInfo{

    private int id;
    private int age;
    private String name;
    private String sex;

    public UserInfo() {
    }

    public UserInfo(int id, int age, String name, String sex) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @XmlElement(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name="age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name="sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(name, userInfo.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}


