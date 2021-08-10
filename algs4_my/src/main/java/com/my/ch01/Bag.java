package com.my.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author: ymm
 * @date: 2021/5/17
 * @version: 1.0.0
 * @description: 包
 * 1.目的：帮助搜集元素并迭代遍历所有收集到的元素
 * 2.无序
 * 3.栈或队列实现
 *
 * 实现的是java.lang.Iterable的接口
 */
public class Bag<Item> implements Iterable<Item> {

    /**
     * 包的起始节点
     */
    private Node<Item> first;

    /**
     * 包的大小
     */
    private int n;

    /**
     * Returns an iterator over elements of type {@code T}.
     *  返回迭代器对象
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }


    /**
     * 节点
     * @param <Item>
     */
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * 创建一个空包
     */
    public Bag() {
        first = null;
        n = 0;
    }

    /**
     * 添加一个元素
     * @param item
     *
     * 类似栈、first指向新增的节点
     */
    public void add(Item item){
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    /**
     * 背包是否为空
     * @return
     */
    public boolean isEmpty(){
        return n == 0;
    }

    /**
     * 背包中的元素的数量
     * @return
     */
    public int size() {
        return n;
    }

    /**
     * 自定义迭代器的内部类
     * @param <Item> 包的首节点
     * 实现的是java.util.Iterator接口
     */
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            // 遍历结束
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        /**
         * Bag不支持删除元素的操作
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        bag.add("one");
        bag.add("two");
        bag.add("three");

        System.out.println("bag.size() = " + bag.size());

        //for-each 不适用于表达式类型
        for (String s : bag) {
            System.out.println("s = " + s);
        }


    }


}
