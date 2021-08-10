package question201;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/4
 * @version: 1.0.0
 * @description: ѡ������
 * 2.1.1
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
            exch(a, i, min);  // ����Сֵ��������i��Ԫ��

            // ��ӡ�м���
            StdOut.printf("i=%2d,min=%2d    ", i, min);
            show(a);
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

    public static void main(String[] args) {
        /*
        ����ǰ��E A S Y Q U E S T I O N
        i= 0,min= 1    A E S Y Q U E S T I O N
        i= 1,min= 1    A E S Y Q U E S T I O N
        i= 2,min= 6    A E E Y Q U S S T I O N
        i= 3,min= 9    A E E I Q U S S T Y O N
        i= 4,min=11    A E E I N U S S T Y O Q
        i= 5,min=10    A E E I N O S S T Y U Q
        i= 6,min=11    A E E I N O Q S T Y U S
        i= 7,min= 7    A E E I N O Q S T Y U S
        i= 8,min=11    A E E I N O Q S S Y U T
        i= 9,min=11    A E E I N O Q S S T U Y
        i=10,min=10    A E E I N O Q S S T U Y
        i=11,min=11    A E E I N O Q S S T U Y
        �����A E E I N O Q S S T U Y
         */
//        Character[] a = charArrayToCharObject("EASYQUESTION".toCharArray());
//        Character[] a = charArrayToCharObject("FEDCBA".toCharArray());
        Character[] a = charArrayToCharObject("51234".toCharArray());
        System.out.print("����ǰ��");
        show(a);
        sort(a);
        System.out.print("�����");
        show(a);
    }

}
