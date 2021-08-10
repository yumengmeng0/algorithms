package chapter202;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/7
 * @version: 1.0.0
 * @description: �㷨2.4 �Զ����µĹ鲢����
 */
public class Merge {
    private static Comparable[] aux; // �鲢����ĸ�������

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // һ���Է���ռ�
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // ��a[lo..hi]����
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;

        sort(a, lo, mid);           // ����������
        sort(a, mid + 1, hi);    // ���Ұ������
        merge(a, lo, mid, hi);      // �鲢���
    }

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

        /*
����ǰ��5 4 3 2 1
4 5 3 2 1
3 4 5 2 1
3 4 5 1 2
1 2 3 4 5
�����1 2 3 4 5
         */
        Integer[] a = {5, 4, 3, 2, 1};

        System.out.print("����ǰ��" );
        show(a);
        sort(a);
        System.out.print("�����" );
        show(a);
/*
����ǰ��A E Q S U Y E I N O S T
A E Q S U Y E I N O S T
A E Q S U Y E I N O S T
A E Q S U Y E I N O S T
A E Q S U Y E I N O S T
A E Q S U Y E I N O S T
A E Q S U Y E I N O S T
A E Q S U Y E I N O S T
A E Q S U Y E I N O S T
A E Q S U Y E I N O S T
A E Q S U Y E I N O S T
A E E I N O Q S S T U Y
�����A E E I N O Q S S T U Y
 */
        Character[] a1 = charArrayToCharObject("AEQSUYEINOST".toCharArray());
        System.out.print("����ǰ��");
        show(a1);
        sort(a1);
        System.out.print("�����");
        show(a1);
    }

}
