package chapter101;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description:
 */
public class BinarySearch0 {

    public static int rank(int key, int[] a) {
        // ��������������
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // �����ҵļ�Ҫô�����ڣ�Ҫô��Ȼ������a[lo..hi]֮��
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

        // javac -Xlint:deprecation chapter01/BinarySearch0.java
        // In.readInts��Ȼ�����Ѿ���ʱ��������ֱ���滻ΪStdIn.
        // int[] whitelist = In.readInts(args[0]);

        // �滻Ϊ
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts(); // ��ȡ��һ���ļ��е����ֲ����浽����whitelist

        Arrays.sort(whitelist);

        boolean empty = StdIn.isEmpty();
        System.out.println("empty = " + empty);
        while (!StdIn.isEmpty()) {
            // ��ȡ��ֵ������������ڰ������������ӡ
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                StdOut.println(key);
        }

        StdOut.println("end");
    }

    public static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}
