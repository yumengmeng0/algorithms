package com.my.ch02.sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author: ymm
 * @date: 2021/6/13
 * @version: 1.0.0
 * @description: 快速排序
 */
public class Quick {

    public static void sort(Comparable[] a) {
//        System.out.println("before");
//        for (Comparable comparable : a) {
//            System.out.println("comparable = " + comparable);
//        }
        StdRandom.shuffle(a); // 消除对输入的依赖
//        System.out.println("after");
//        for (Comparable comparable : a) {
//            System.out.println("comparable = " + comparable);
//        }
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1], a[i], a[i+1..h1]
        int i = lo, j = hi + 1; // 资源扫描指针
        Comparable v = a[lo];   // 切分元素
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    /**
     * 判断v是否小于w，是返回true，否返回false
     *
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组a的位置i和位置j的元素
     *
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static void main(String[] args) {
        Integer[] a = {5,8,242,124,45,5};
        sort(a);
//        System.out.println("a = " + a);
        for (Integer i : a) {
            System.out.println("i = " + i);
        }
    }
}
