package com.my.ch01.com.my.ch01new;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author: ymm
 * @date: 2021/5/19
 * @version: 1.0.0
 * @description:
 * 带泛型的变长的栈(参考优化)
 * 底层用数组存节点
 */
public class UnfixedCapacityStack<Item> implements Iterable<Item>{
//    private Node<Item> top;
    private Item[] stack;  // 栈
    private int N; // 栈的大小

    /**
     * 创建以一个给定容量的空栈
     * @param capacity
     */
    public UnfixedCapacityStack(int capacity) {
        stack = (Item[]) new Object[capacity];
        N = 0;
    }

    /**
     * 入栈
     * @param item
     */
    public void push(Item item) {
        // 栈已满
        if (N == stack.length)
            resize(2*stack.length);

        stack[N++] = item;
    }

    /**
     * 出栈
     * @return
     */
    public Item pop() {
        Item item = stack[--N];
        // 游离：保存一个不需要的对象
        stack[N] = null; // 避免对象游离
        // 缩减栈的容量
        if (N > 0 && N == stack.length/4)
            resize(stack.length/2);

        return item;
    }

    public boolean isEmpty() {
        return N == 0;
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

    /**
     * 调整数组大小
     * @param max
     */
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    public static void main(String[] args) {
        UnfixedCapacityStack<String> stack = new UnfixedCapacityStack(10);

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
