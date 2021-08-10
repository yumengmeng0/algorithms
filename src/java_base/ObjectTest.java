package java_base;

import javax.management.ObjectName;

/**
 * @author: ymm
 * @date: 2021/6/30
 * @version: 1.0.0
 * @description:
 */
public class ObjectTest {

    public static void main(String[] args) {
        Object o1 ;
        Object o2 = new Object();
        o1 = o2;
        System.out.println("o1==o2 = " + (o1==o2));
        System.out.println("o1==o2 = " + o1.equals(o2));

        String hello = new String("hello");
//        System.out.println("hello = " + hello);
        String s = hello;
        System.out.println("s==hello = " + (s==hello));
        System.out.println("s.equals(hello) = " + s.equals(hello));
//        hello = new String("hello world");
//        System.out.println("s = " + s);
//        System.out.println("hello = " + hello);
    }
}
