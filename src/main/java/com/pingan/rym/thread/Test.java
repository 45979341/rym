/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2018/7/30 0030
 * Time: 下午 10:12
 */
package com.pingan.rym.thread;

import org.owasp.esapi.ESAPI;

import java.security.SecureClassLoader;
import java.security.SecureRandom;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
//        Service service = new Service();
//        for (int i = 0; i < 50; i++) {
//            ThreadA threadA = new ThreadA(service);
////            threadA.start();
//        }

        try {
            //SecureRandom random= SecureRandom.getInstance("SHA1PRNG");
            long randomLong = ESAPI.randomizer().getRandomLong();
            SecureRandom random = new SecureRandom();
            for(int i=0;i<100;i++){
                int a = random.nextInt(10);
                System.out.println(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}