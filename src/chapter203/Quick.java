package chapter203;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author: ymm
 * @date: 2021/7/7
 * @version: 1.0.0
 * @description: ��������
 */
public class Quick {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);  // ���������������
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // �������з�Ϊa[lo..i-1],a[i],a[i+1..hi]
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) { // ����ɨ�裬���ɨ���Ƿ����������Ԫ��
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // ��v=a[j] �ŵ���ȷ��λ��
        return j; // a[1..j-1] <= a[j] <= a[j+1..hi]���
    }

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
     * ���ַ�����ת��Ϊ�ֽڶ�������
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
        Character[] a = charArrayToCharObject("EASYQUESTION".toCharArray());
        sort(a);
        show(a);
    }

}
