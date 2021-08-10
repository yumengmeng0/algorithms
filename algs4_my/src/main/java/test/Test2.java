package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ymm
 * @date: 2021/5/23
 * @version: 1.0.0
 * @description:
 */
public class Test2 {

    public static void main(String[] args) {

        Object[] array = new String[10];
        array[0] = 10;
        // Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer
        System.out.println("array = " + array);
//        List<Object> list = new ArrayList<String>();
//        list.add(10);
    }

}
