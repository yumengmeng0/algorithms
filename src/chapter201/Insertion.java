package chapter201;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/4
 * @version: 1.0.0
 * @description: ��������
 */
public class Insertion {

    /**
     * ������a[]����������
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) { // ��a[i]���뵽a[0]...a[i-1]
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
            StdOut.printf("",i);
        }
    }

    /**
     * �ж�v�Ƿ�С��w
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * ��������������Ϊi,j��Ԫ��
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

    /**
     * �ڵ����д�ӡ����
     *
     * @param a
     */
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    /**
     * �ж�����Ԫ���Ƿ���������
     *
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // �ӱ�׼�����ȡ�ַ��������������������
        String[] a = StdIn.readAllStrings();

        System.out.println("isSorted(a) = " + isSorted(a));
        sort(a);
        System.out.println("isSorted(a) = " + isSorted(a));

        assert isSorted(a);
        show(a);
    }

}
