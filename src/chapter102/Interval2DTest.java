package chapter102;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author: ymm
 * @date: 2021/6/26
 * @version: 1.0.0
 * @description:
 */
public class Interval2DTest {


    /**
     * 随机产生一个Interval1D对象，范围在[min,max)之间
     *
     * @param min
     * @param max
     * @return
     */
    private static Interval1D createInterval1D(double min, double max) {
        double lenMax = max - min; // 长度的最大值
        double min1 = min + StdRandom.uniform() * (lenMax), max1 = min + StdRandom.uniform() * lenMax;
        if (min1 > max1) {
            double t = min1;
            min1 = max1;
            max1 = t;
        }
        return new Interval1D(min1, max1);
    }


    /**
     * 随机产生一个Interval2D对象，宽和高的范围在[min,max)之间
     *
     * @param min
     * @param max
     * @return
     */
    private static Interval2D createInterval2D(double min, double max) {
        Interval1D x = createInterval1D(min, max);
        Interval1D y = createInterval1D(min, max);
        return new Interval2D(x, y);
    }


    // 1.2.3
    public static void main(String[] args) {
        int N = 100;
        double min = 0, max = 1;
        Interval2D[] interval2DArray = new Interval2D[N];

        for (int i = 0; i < N; i++) {

            double x0, x1, y0, y1; // 记录Interval2D在平面坐标轴中的坐标

            // 随机生成Interval2D的两个Interval1D
            double lenMax = max - min; // 长度的最大值

            double min1 = min + StdRandom.uniform() * lenMax, max1 = min + StdRandom.uniform() * lenMax;
            if (min1 > max1) {
                double t = min1;
                min1 = max1;
                max1 = t;
            }

            Interval1D x = new Interval1D(min1, max1);

            x0 = min1;
            x1 = max1;


            min1 = min + StdRandom.uniform() * lenMax;
            max1 = min + StdRandom.uniform() * lenMax;
            if (min1 > max1) {
                double t = min1;
                min1 = max1;
                max1 = t;
            }
            Interval1D y = new Interval1D(min1, max1);
            // 创建Interval2D
            interval2DArray[i] = new Interval2D(x, y);

            System.out.println("interval2DArray[" + i + "] = " + interval2DArray[i]);

            y0 = min1;
            y1 = max1;

            StdDraw.line(x0, y0, x1, y1); // 在单位正方形中画出图形interval2DArray[i]
            System.out.println("x0+\":\"+y0+\":\"+x1+\":\"+y1 = " + x0 + ":" + y0 + ":" + x1 + ":" + y1);
        }

//        int intersectNum = 0, containNum = 0;
        Counter intersect = new Counter("intersect");
        Counter contains = new Counter("contains");

        for (int i = 0; i < interval2DArray.length - 1; i++) {
            for (int j = i + 1; j < interval2DArray.length; j++) {
//                interval2DArray[i].contains();
                if (interval2DArray[i].intersects(interval2DArray[j])) contains.increment();
            }
        }
//        System.out.println("相交的间隔对数：" + intersectNum);
//        System.out.println("包含的间隔对数" + containNum);
        System.out.println("包含的间隔对数" + contains);
    }


}
