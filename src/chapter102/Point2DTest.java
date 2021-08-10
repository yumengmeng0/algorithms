package chapter102;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author: ymm
 * @date: 2021/6/22
 * @version: 1.0.0
 * @description:
 */
public class Point2DTest {




    // 1.2.1
    public static void main(String[] args) {
        int N = 100;

        Point2D[] point2DArray = new Point2D[N];

        // 生成N个单位正方形内的点
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            
            Point2D point = new Point2D(x, y);
//            System.out.println("point = " + point);
            point2DArray[i] = point;
        }
        
        double minDist = 1.0;
        for (int i = 0; i < point2DArray.length - 1; i++) {
            for (int j = i + 1; j < point2DArray.length; j++) {
                double dist = point2DArray[i].distanceTo(point2DArray[j]); // 两点间距离
//                System.out.println("dist = " + dist);
                if (minDist > dist) minDist = dist;
            }
        }

        System.out.println("minDist = " + minDist);
    }
}
