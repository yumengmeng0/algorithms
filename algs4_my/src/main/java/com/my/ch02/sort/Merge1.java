package com.my.ch02.sort;

/**
 * @author: ymm
 * @date: 2021/5/23
 * @version: 1.0.0
 * @description: 归并排序
 */
public class Merge1 {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // 一次性分配内存
        sort(a, 0, a.length - 1);
    }

    /**
     * 将两个有序数组 a[lo..mid] 和 a[mid+1..hi] 归并
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        // 将数组a[lo..hi]复制到数组aux[lo..hi]
        for (int k = 0; k <= hi; k++) {
            aux[k] = a[k];
        }
        /**
         * 取aux[lo..mid]和aux[mid+1..hi]中较小的复制到a
         * 两部分都有序
         */
        for (int k = lo; k < hi; k++) { // 归并到a[lo..hi]
            if (i > mid) { // 左半边用尽取右边元素
                a[k] = a[k] = aux[j++];
            } else if (j > hi) { // 右半边用尽取左边元素
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) { // 右边元素小于当前元素，取右边
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }


    /**
     * 将a[lo..hi]数组排序
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi < lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
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
        String[] a = {"hello", "zoo", "world", "ymm", "a", "baby"};

        sort(a, 0, a.length);
        System.out.println("a = " + a);

    }
}
