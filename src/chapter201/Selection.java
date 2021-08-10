package chapter201;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/4
 * @version: 1.0.0
 * @description: ѡ������
 */
public class Selection {

    /**
     * ������a[]����������
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length; // ���鳤��
        for (int i = 0; i < N; i++) { //��a[i]��a[i+1,N]����С��Ԫ�ؽ���
            int min = i;    // ��СԪ�ص�����
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);

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
//        String[] a = In.readStrings();
        String[] a = StdIn.readAllStrings();
        System.out.println("isSorted(a) = " + isSorted(a));
        sort(a);
        System.out.println("isSorted(a) = " + isSorted(a));
        show(a);
    }

}
