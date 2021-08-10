package com.my.ch02.sort;

import java.util.Arrays;

/**
 * @author: ymm
 * @date: 2021/6/13
 * @version: 1.0.0
 * @description: 基于堆的优先队列
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq; // 基于堆的完全二叉树
    private int N = 0; //存储于pq[1..N]中，pq[0]没有使用

    /**
     * 创建一个初始容量为max的优先级队列
     *
     * @param maxN
     */
    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN];
    }

    /**
     * 向优先级队列中插入一个元素
     *
     * @param v
     */
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }


    /**
     * 删除并返回最大元素
     *
     * @return
     */
    public Key delMax() {
        Key max = pq[1]; // 从根节点得到最大元素
        exch(1, N--);  // 将其和最后一个节点交换
        pq[N + 1] = null;  // 防止对象游离
        sink(1);        // 恢复堆的有序性
        return max;
    }

    /**
     * 返回队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return 0 == N;
    }

    /**
     * 返回优先队列中的元素个数
     *
     * @return
     */
    public int size() {
        return N;
    }


    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 交换数组a的位置i和位置j的元素
     *
     * @param i
     * @param j
     */
    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    public static void main(String[] args) {
        MaxPQ<Character> pq = new MaxPQ<>(100);
        Character[] a = {'A','B','C','D'};
        for (Character character : a) {
            pq.insert(character);
            System.out.println("pq = " + pq);
        }

        System.out.println("pq = " + pq);
        
    }

    @Override
    public String toString() {
        return "MaxPQ{" +
                "pq=" + Arrays.toString(pq) +
                ", N=" + N +
                '}';
    }
}
