package list;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @author: ymm
 * @date: 2021/6/20
 * @version: 1.0.0
 * @description:
 */
public class List {

    public static void main(String[] args) {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N*N);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i <= N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i*i);
            StdDraw.point(i, i*Math.log(i));
        }
    }
}
