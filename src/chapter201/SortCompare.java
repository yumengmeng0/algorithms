package chapter201;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @author: ymm
 * @date: 2021/7/4
 * @version: 1.0.0
 * @description: �Ƚ����������㷨
 */
public class SortCompare {

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        return timer.elapsedTime();
    }

    /**
     * ʹ���㷨alg��T������ΪN����������
     *
     * @param alg
     * @param N
     * @param T
     * @return
     */
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];

        for (int t = 0; t < T; t++) { // ����һ�β��ԣ�����һ�����鲢����
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }

        return total;
    }

    public static void main(String[] args) {
//        String alg1 = args[0];
//        String alg2 = args[1];
//        int N = Integer.parseInt(args[2]);
//        int T = Integer.parseInt(args[3]);

        String alg1 = "Insertion";
        String alg2 = "Selection";
        int N = 1000;
        int T = 1000;

        double t1 = timeRandomInput(alg1, N, T); // �㷨1����ʱ��
        double t2 = timeRandomInput(alg2, N, T); // �㷨2����ʱ��

        StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);

    }
}
