import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/2
 * @version: 1.0.0
 * @description:
 */
public class ThreeSum {


    public static int count(int[] a) {
        // 统计和为0的元组的数量
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
//                        System.out.println(a[k]);
                        System.out.println("(i,j) = " + a[i] + "," + a[j]);
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
