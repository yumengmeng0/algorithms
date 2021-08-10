package com.my.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author: ymm
 * @date: 2021/5/17
 * @version: 1.0.0
 * @description:
 * 固定容量的栈
 */
public class FixedCapacityStackOfStrings {
    /**
     * 栈顶元素
     */
    private Node<String> top;
    private int n;
    private int capacity;
    // 栈最大容量
//    private static int MAX_CAPACITY = 1000;

    private static class Node<String> {
        private String item;
        private Node<String> next;
    }

    public FixedCapacityStackOfStrings(int cap) {
        capacity = cap;
        top = null;
        n = 0;
    }

//    public FixedCapacityStackOfStrings() {
//        top = null;
//        n = 0;
//    }

    /**
     * 入栈
     *
     * @param string
     */
    public void push(String string) {
        if (n < capacity) {
            // 引用
            Node<String> oldTop = top;
            top = new Node<String>();
            top.item = string;
            top.next = oldTop;
            n++;
        }else {
            throw new NoCapacityException("栈已满");
        }
    }

    /**
     * 出栈
     *
     * @return
     */
    public String pop() {
        // 空栈
        if (n > 0) {
            // 保存栈顶元素指针
            Node<String> oldTop = top;
            // 栈顶元素指针执行下一个节点
            top = top.next;
            n--;
            return oldTop.item;
        }
        return null;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }


    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);

        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("three");
//        stack.push("three");
//        stack.push("three");
//        stack.push("three");
//        stack.push("three");
//        stack.push("three");
//        stack.push("three");
//        stack.push("three");
        java.lang.String s = "";

        while ((s = stack.pop()) != null) {
            System.out.println("s = " + s);
        }

    }
}
