package question202;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/7
 * @version: 1.0.0
 * @description:
 */
public class Merge2204 {
    private static Comparable[] aux; // 归并所需的辅助数组

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
//        show(a);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
    }


    public static void main(String[] args) {
        
    }

}
