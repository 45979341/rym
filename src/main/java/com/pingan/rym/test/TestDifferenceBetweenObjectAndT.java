package com.pingan.rym.test;

import com.pingan.rym.dto.PersonDTO;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 刘欣武
 * @version $Id: TestDifferenceBetweenObjectAndT, v 0.1 2019/7/24 14:12 刘欣武 Exp$
 */
public class TestDifferenceBetweenObjectAndT {

    public static void printList1(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static <T> void printList2(List<T> list) {
        for (T elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static  void printList3(List<?> list) {
        for (int i = 0;i<list.size();i++)
            System.out.println(list.get(i) + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int a = 1<<4;
        HashMap<String,String> map = new HashMap<>();


        List<Integer> test1 = Arrays.asList(1, 2, 3);
        Collections.sort(test1, (o1,o2) -> o2-o1);
        Collections.sort(test1, new Comparator<Integer>() {

            public int compare(Integer o1,Integer o2){
                return 0;
            }
        });

        test1.stream().sorted(((o1, o2) -> o2-o1));
        test1.sort((o1, o2) -> o2-o1);



        new SimpleDateFormat("yyyy-MM-dd ");



       Thread thread = new Thread(()-> {
            System.out.println("Hello World!");
       });




        List<String>  test2 = Arrays.asList("one", "two", "three");
        List<Object> test3 = Arrays.asList(1, "two", 1.23);
        //List<Fruit> test4 = Arrays.asList(new Apple(), new Banana());
        /*
         * 下面这句会编译报错，因为参数不能转化成功
         * */
        //printList1(test4);
        /**/
        printList1(test3);
        printList1(test3);
        printList2(test1);
        printList2(test2);
        printList2(test3);
        printList3(test1);
        printList3(test2);
        printList3(test3);
    }
}


