package chapter201;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/4
 * @version: 1.0.0
 * @description: ϣ������
 */
public class Shell {

    /**
     * ������a[]����������
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        // �������鳤�ȼ����һ��h
        while (h < N / 3) h = 3 * h + 1; // 1��4,13,40,121,364��1093��...
        System.out.println("N = " + N + ",h = " + h);
        while (h >= 1) {
            // �������Ϊh����
            for (int i = h; i < N; i++) {
                // ��a[i]���뵽a[i-h],a[i-2*h],a[i-3*h]...֮��
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) { // �൱�ڲ�������
//                    System.out.println("j = " + j);
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
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

    /**
     * ���ַ���ת��Ϊ�ַ���������
     *
     * @param s
     * @return
     */
    public static Character[] strToCharArr(String s) {
        char[] chars = s.toCharArray();
        Character[] c = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            c[i] = chars[i];
        }
        return c;
    }

    public static void main(String[] args) {
        // �ӱ�׼�����ȡ�ַ��������������������
//        String[] a = In.readStrings();
//        Character[] a = charArrayToCharObject("EASYQUESTION".toCharArray());
        Character[] a = strToCharArr("EASYQUESTION");
        sort(a);
        show(a);
    }

}
