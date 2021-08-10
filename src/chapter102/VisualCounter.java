package chapter102;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @author: ymm
 * @date: 2021/6/26
 * @version: 1.0.0
 * @description: 1.2.10
 */
public class VisualCounter {
    private final String name;     // counter name
    private int count = 0;         // current value
    private int N;                  // 操作的最大次数
    private int max;                // 计数器的最大绝对值
    private int changeCount = 0;    // 修改次数

    /**
     * Initializes a new counter starting at 0, with the given id.
     *
     * @param id the name of the counter
     */
    public VisualCounter(String id, int N, int max) {
        this.name = id;
        this.N = N;
        this.max = max;
    }


    /**
     * Increments the counter by 1.
     */
    public void increment() {
        if (count >= max) throw new RuntimeException("超出计数器的最大绝对值");
        count++;
        changeCount++;
        StdDraw.point(changeCount, count);
        System.out.println("N + \" \" +count = " + changeCount + " " +count);
    }


    /**
     * 计数器减1
     */
    public void reduction() {
        if (count <= -max) throw new RuntimeException("超出计数器的最大绝对值reduction");
        count--;
        N++;
        changeCount++;
        StdDraw.point(changeCount, count);
        System.out.println("N + \" \" +count = " + changeCount + " " +count);
    }

    /**
     * Returns the current value of this counter.
     *
     * @return the current value of this counter
     */
    public int tally() {
        return count;
    }

    /**
     * Returns a string representation of this counter.
     *
     * @return a string representation of this counter
     */
    public String toString() {
        return count + " " + name;
    }


    public static void main(String[] args) {
        int N = 1000, max = 100;

        // 设置图像坐标范围
        StdDraw.setXscale(0, 1000);
        StdDraw.setYscale(-max, max);

        VisualCounter visualCounter = new VisualCounter("counter",N,max);

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 100; i++) {
                visualCounter.increment();
            }
            for (int i = 0; i < 100; i++) {
                visualCounter.reduction();
            }
        }

//        for (int i = 0; i < 10000; i++) {
//
//            StdDraw.point(0.1*i,0.1*i);
//            StdDraw.point(0.3*i,-0.3*i);
//
//        }
//        StdDraw.line(0.1,0.2,99,4.0);
//        StdDraw.line(1,2,50,100.0);
        System.out.println(" = ");
    }
}
