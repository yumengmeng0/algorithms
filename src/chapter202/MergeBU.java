package chapter202;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/7
 * @version: 1.0.0
 * @description: 自底向上的归并排序
 */
public class MergeBU {
    private static Comparable[] aux; // 归并所需的辅助数组

    public static void sort(Comparable[] a) {
        // 进行lgN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) { // sz子数组大小
            for (int lo = 0; lo < N - sz; lo += sz + sz) {  // lo:子数组索引
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    /**
     * 原地归并抽象方法
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将a[lo]...a[hi]归并
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)  // 将a[lo...hi]复制到aux[lo...hi]
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++) { // 归并a[lo..hi]复制到aux[lo..hi]
            if (i > mid)                    a[k] = aux[j++]; // 左半边用尽（取右半边的元素）
            else if (j > hi)                a[k] = aux[i++]; // 右半边用尽（取左半边的元素）
            else if (less(aux[j], aux[i]))  a[k] = aux[j++]; // 右半边的当前元素小于左半边的当前元素（取右边的元素）
            else                            a[k] = aux[i++]; // 右半边的当前元素大于等于左半边的当前元素（取左边的元素）
        }
        show(a);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 在单行中打印数组
     *
     * @param a
     */
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        Integer[] a = {5, 4, 3, 2, 1};

        System.out.print("排序前：" );
        show(a);
        sort(a);
        System.out.print("排序后：" );
        show(a);
    }


}
