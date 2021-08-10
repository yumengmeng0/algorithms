package question202;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/7
 * @version: 1.0.0
 * @description:
 */
public class Merge2204 {
    private static Comparable[] aux; // �鲢����ĸ�������

    /**
     * ԭ�ع鲢���󷽷�
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // ��a[lo]...a[hi]�鲢
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)  // ��a[lo...hi]���Ƶ�aux[lo...hi]
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++) { // �鲢a[lo..hi]���Ƶ�aux[lo..hi]
            if (i > mid)                    a[k] = aux[j++]; // �����þ���ȡ�Ұ�ߵ�Ԫ�أ�
            else if (j > hi)                a[k] = aux[i++]; // �Ұ���þ���ȡ���ߵ�Ԫ�أ�
            else if (less(aux[j], aux[i]))  a[k] = aux[j++]; // �Ұ�ߵĵ�ǰԪ��С�����ߵĵ�ǰԪ�أ�ȡ�ұߵ�Ԫ�أ�
            else                            a[k] = aux[i++]; // �Ұ�ߵĵ�ǰԪ�ش��ڵ������ߵĵ�ǰԪ�أ�ȡ��ߵ�Ԫ�أ�
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
