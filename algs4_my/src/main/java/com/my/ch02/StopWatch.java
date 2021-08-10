package com.my.ch02;

/**
 * @author: ymm
 * @date: 2021/5/23
 * @version: 1.0.0
 * @description:
 */
public class StopWatch {

    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    /**
     * elapsed(时间)消逝，流逝;
     *
     * @return 消耗的时间
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

}
