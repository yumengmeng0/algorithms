package chapter101;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description: ɾ�������ظ�Ԫ��
 */
public class Exercise28 {

    /**
     * ��ӡ����
     *
     * @param a
     */
    public static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }

    /**
     * ��������
     *
     * @param dest
     * @param src
     * @param len
     */
    public static boolean copyArray(int[] dest, int[] src, int len) {
        if (len > dest.length || len > src.length) {
            return false;
        }

//        System.out.println(dest.length);
        for (int i = 0; i < len; i++) {
            dest[i] = src[i];
        }
        return true;
    }

    /**
     * ����ȥ��
     *
     * @param a
     */
    public static int[] duprem(int[] a) {

        int curLen = a.length; // ��¼ȥ�غ����鳤��

        for (int i = 0; i < curLen; i++) {
            for (int j = i + 1; j < curLen; ) {
                if (a[i] == a[j]) { // �ҵ��ظ�Ԫ��
//                    System.out.println(j + " = " + a[j]);

                    // ȥ�أ�����Ԫ����ǰ��һά����ǰ��һλ
                    for (int k = j; k < curLen - 1; k++) {
                        a[k] = a[k + 1];
                    }

                    curLen--;
//                    System.out.println(" =====" + a[i] + "=======" );
//                    printArray(a);
//                    System.out.println(" ============" );
                }else
                    j++; // ֻ��û��ȥ��ʱ��j������ƶ�����������жϵ�ǰԪ��
            }
        }
//        printArray(a);
        int[] curArr = new int[curLen];
        copyArray(curArr, a, curLen);
        return curArr;
    }


    public static void main(String[] args) {

        // �滻Ϊ
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts(); // ��ȡ��һ���ļ��е����ֲ����浽����whitelist
        Arrays.sort(whitelist);
        int[] duprem = duprem(whitelist);
        printArray(duprem);
    }

    public static void main1(String[] args) {

//        int[] a = {23, 50, 10, 99, 18, 23, 98, 84, 11, 10, 48, 77, 13, 54, 98, 77, 77, 68};
        int[] a = {77, 77, 77,4};
//        Arrays.sort(a);
        int[] duprem = duprem(a);
//        System.out.println("----------");
//        printArray(a);
//        System.out.println("----------");
        printArray(duprem);
    }

}
