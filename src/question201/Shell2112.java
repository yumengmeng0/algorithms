package question201;

import edu.princeton.cs.algs4.StdOut;


/**
 * @author: ymm
 * @date: 2021/7/4
 * @version: 1.0.0
 * @description: 希尔排序
 */
public class Shell2112 {

    /**
     * 将数组a[]按升序排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        // 根据数组长度计算出一个h
        while (h < N / 3) h = 3 * h + 1; // 1,4,13,40,121,364，1093，...
        System.out.println("N = " + N + ",h = " + h);
        System.out.println("compareTimes/N");
        while (h >= 1) {
            int compareTimes = 0; // 每个递增递增序列的比较次数
            // 将数组变为h有序
            for (int i = h; i < N; i++) {
                // 将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) { // 相当于插入排序
//                    System.out.println("j = " + j);
                    exch(a, j, j - h);
                    compareTimes++;
                }
            }
            h = h / 3;

//            System.out.print("compareTimes/N");

            // 打印递增序列的每个元素所带来的比较次数和数组大小的比值
            StdOut.printf("%.2f \n", compareTimes /(double) N);
        }
    }

    /**
     * 判断v是否小于w
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组中索引为i,j的元素
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
     * 在单行中打印数组
     *
     * @param a
     */
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    /**
     * 判断数组元素是否有序（升序）
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

        /*
        N = 100,h = 40
compareTimes/N
0.33
0.76
1.45
1.47
N = 1000,h = 364
compareTimes/N
0.47
0.89
1.31
1.76
2.17
1.64
N = 10000,h = 9841
compareTimes/N
0.01
0.51
0.94
1.45
1.95
2.45
3.63
3.16
1.72
N = 100000,h = 88573
compareTimes/N
0.06
0.50
0.94
1.47
1.99
2.78
4.14
6.06
6.87
3.91
1.76
N = 1000000,h = 797161
compareTimes/N
0.10
0.50
1.00
1.51
2.09
2.87
4.09
5.96
9.40
12.53
12.10
3.72
1.75

         */
        SortCompare.timeRandomInput("Shell2112", 100, 1);
        SortCompare.timeRandomInput("Shell2112", 1000, 1);
        SortCompare.timeRandomInput("Shell2112", 10000, 1);
        SortCompare.timeRandomInput("Shell2112", 100000, 1);
        SortCompare.timeRandomInput("Shell2112", 1000000, 1);
//        SortCompare.timeRandomInput("Shell212", 10000000, 1);

    }

}
