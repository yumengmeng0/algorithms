package question201;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/4
 * @version: 1.0.0
 * @description: 选择排序
 * 2.1.1
 */
public class Selection {

    /**
     * 将数组a[]按升序排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length; // 数组长度
        for (int i = 0; i < N; i++) { //将a[i]和a[i+1,N]中最小的元素交换
            int min = i;    // 最小元素的索引
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);  // 把最小值交换到第i个元素

            // 打印中间结果
            StdOut.printf("i=%2d,min=%2d    ", i, min);
            show(a);
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
        排序前：E A S Y Q U E S T I O N
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
        排序后：A E E I N O Q S S T U Y
         */
//        Character[] a = charArrayToCharObject("EASYQUESTION".toCharArray());
//        Character[] a = charArrayToCharObject("FEDCBA".toCharArray());
        Character[] a = charArrayToCharObject("51234".toCharArray());
        System.out.print("排序前：");
        show(a);
        sort(a);
        System.out.print("排序后：");
        show(a);
    }

}
