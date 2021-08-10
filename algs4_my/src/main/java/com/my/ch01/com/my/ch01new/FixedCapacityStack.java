package com.my.ch01.com.my.ch01new;

import com.my.ch01.NoCapacityException;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author: ymm
 * @date: 2021/5/19
 * @version: 1.0.0
 * @description:
 * 带泛型的固定容量的栈(参考优化)
 * 底层用数组存节点
 */
public class FixedCapacityStack<Item> implements Iterable<Item>{
//    private Node<Item> top;
    private Item[] stack;  // 栈，用数组存储
    private int N; // 栈的大小

    /**
     * 创建以一个给定容量的空栈
     * @param capacity
     */
    public FixedCapacityStack(int capacity) {
        stack = (Item[]) new Object[capacity];
        N = 0;
    }

    /**
     * 入栈
     * @param item
     */
    public void push(Item item) {
        stack[N++] = item;
    }

    /**
     * 出栈
     * @return
     */
    public Item pop() {
        // 空栈
        return stack[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == stack.length;
    }

    public int size() {
        return N;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<Item> {

        private int i = N - 1;

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return stack[i--];
        }

        @Override
        public void remove() {
            throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack(10);

        stack.push("one");
        stack.push("two");
        stack.push("three");
//        stack.push("three");
//        stack.push("three");
//        stack.push("three");
//        stack.push("three");
//        stack.push("three");
//        stack.push("three");
//        stack.push("three");
//        stack.push("three");
        String s = "";

//        while ((s = stack.pop()) != null) {
//            System.out.println("s = " + s);
//        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

        for (String s1 : stack) {
            System.out.println("s1 = " + s1);
        }

    }


}
