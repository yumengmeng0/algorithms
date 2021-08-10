package com.my.ch01;

import java.util.Iterator;

/**
 * @author: ymm
 * @date: 2021/5/17
 * @version: 1.0.0
 * @description: 队列
 */
public class Queue<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        head = null;
        tail = null;
        n = 0;
    }

    /**
     * 入队
     *
     * @param item
     */
    public void enqueue(Item item) {
        Node<Item> oldTail = tail;
        // 为新节点分配空间
        tail = new Node<Item>();
        tail.item = item;

        if (n == 0) { // 首次入队
            head = tail;
            // 此时 oldTail == null
        }else {
            oldTail.next = tail;
        }
        n++;
    }

    /**
     * 出队
     *
     * @return
     */
    public Item dequeue() {
        // 非空队列
        if (n > 0) {
            Item headItem = head.item;
            head = head.next;
            n--;
            return headItem;
        }
        // 空队列
        return null;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return null;
    }


    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        System.out.println("queue.size() = " + queue.size());
        String s = null;

        while ((s = queue.dequeue()) != null) {
            System.out.println("s = " + s);
        }
    }
}
