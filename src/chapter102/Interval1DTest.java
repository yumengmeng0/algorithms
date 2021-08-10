package chapter102;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author: ymm
 * @date: 2021/6/26
 * @version: 1.0.0
 * @description:
 */
public class Interval1DTest {
    // 1.2.2
    public static void main(String[] args) {
        int N = 10;
        Interval1D[] interval1DArray = new Interval1D[N];

        for (int i = 0; i < N; i++) {
            double min = StdRandom.uniform(0.0, 100.0);// 随机产生一个[0.0,100.0)之间的double类型的数
            double max = StdRandom.uniform(0.0, 100.0);

            if (min > max) { // 保证min<=max
                double t = min;
                min = max;
                max = t;
            }
            interval1DArray[i] = new Interval1D(min, max);
//            System.out.println("interval1DArray = " + interval1DArray[i] + i);
        }


        int count = 0;
        for (int i = 0; i < interval1DArray.length - 1; i++) {
            for (int j = i + 1; j < interval1DArray.length; j++) {
                if (!interval1DArray[i].intersects(interval1DArray[j])) {
                    System.out.println("[i] = " + interval1DArray[i] + ",[j] = " + interval1DArray[j]);
                    count++;
                }
            }
        }

        System.out.println("count = " + count); // 3171 1583
    }
}
