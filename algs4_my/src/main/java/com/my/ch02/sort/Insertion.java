package com.my.ch02.sort;

/**
 * @author: ymm
 * @date: 2021/5/23
 * @version: 1.0.0
 * @description: 插入排序
 */
public class Insertion {

    /**
     * 将a按升序排列
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        // 应该从第2元素开始
        for (int i = 1; i < N; i++) {
            // 将a[i]插入到a[0]...a[i-1]
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }

    }

    /**
     * 判断v是否小于w，是返回true，否返回false
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组a的位置i和位置j的元素
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
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
     *
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
        String[] a = {"hello", "zoo", "world", "ymm", "egg", "baby"};

        sort(a);
        assert isSorted(a);
        show(a);

    }
}
