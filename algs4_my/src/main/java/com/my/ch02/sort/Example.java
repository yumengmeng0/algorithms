package com.my.ch02.sort;

/**
 * @author: ymm
 * @date: 2021/5/23
 * @version: 1.0.0
 * @description:
 */
public class Example {

    public static void sort(Comparable[] a) {

    }

    /**
     * 判断v是否小于w，是返回true，否返回false
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组a的位置i和位置j的元素
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 判断数组是否有序（升序）
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = {"hello", "zoo", "world", "ymm"};

        sort(a);
        assert isSorted(a);
        show(a);

    }
}
