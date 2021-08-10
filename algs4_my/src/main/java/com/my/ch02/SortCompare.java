package com.my.ch02;

import com.my.ch02.StopWatch;
import com.my.ch02.sort.Insertion;
import com.my.ch02.sort.Selection;
import com.my.ch02.sort.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author: ymm
 * @date: 2021/5/24
 * @version: 1.0.0
 * @description:
 */
public class SortCompare {

    /**
     *
     * @param alg
     * @param a
     * @return
     */
    public static double time(String alg, Comparable[] a) {
        StopWatch timer = new StopWatch();
        if (alg.equals("insertion")) Insertion.sort(a);
        if (alg.equals("selection")) Selection.sort(a);

        if (alg.equals("shell")) Shell.sort(a);
//        if (alg.equals("merge")) Selection.sort(a);
//        if (alg.equals("quick")) Selection.sort(a);
//        if (alg.equals("heap")) Selection.sort(a);

        return timer.elapsedTime();
    }

    /**
     * 使用alg算法将T个长度为N的数组排序
     * @param alg
     * @param N
     * @param T
     * @return 排序消耗的总时间
     */
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                //a random real number uniformly in [0, 1)
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
//        String alg1 = "insertion";
        String alg1 = "shell";
        String alg2 = "selection";
        int N = 1000;
        int T = 100;

        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);

        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times fast than %s\n", t2/t1, alg2);
    }
}
