package question202;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/7
 * @version: 1.0.0
 * @description: 自顶向下的归并排序
 */
public class Merge {
    private static Comparable[] aux; // 归并所需的辅助数组

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // 一次性分配空间
        StdOut.printf("         a[]                     aux[]\n");
        StdOut.printf("k ");
        for (int i = 0; i < a.length; i++) {
            StdOut.printf("%d ",i);
        }
        StdOut.printf(" i j ");
        for (int i = 0; i < a.length; i++) {
            StdOut.printf("%d ",i);
        }

        StdOut.println();
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // 将a[lo..hi]排序
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;

        sort(a, lo, mid);           // 将左半边排序
        sort(a, mid + 1, hi);    // 将右半边排序
        merge(a, lo, mid, hi);      // 归并结果
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
        StdOut.print("  ");
        showln(a);
        for (int i1 = 0; i1 < hi; i1++) {
            StdOut.printf("%c ", aux[i1]);
        }

    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 在单行中打印数组
     *
     * @param a
     */
    private static void showln(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
    }

    /**
     * 把字符数组转换为字节对象数组
     *
     * @param chars
     * @return
     */
    public static Character[] charArrayToCharObject(char[] chars) {
        Character[] a = new Character[chars.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Character.valueOf(chars[i]);
        }
        return a;
    }


    public static void main(String[] args) {
//        Character[] a1 = charArrayToCharObject("EEGMRACERT".toCharArray());
        Character[] a1 = charArrayToCharObject("AEQSUYEINOST".toCharArray());
        System.out.print("排序前：");
        showln(a1);
        sort(a1);
        System.out.print("排序后：");
        showln(a1);
        System.out.println("a1.length = " + a1.length);
    }

}
