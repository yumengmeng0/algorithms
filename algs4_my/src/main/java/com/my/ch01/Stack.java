package com.my.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author: ymm
 * @date: 2021/5/17
 * @version: 1.0.0
 * @description:
 */
public class Stack<Item> implements Iterable<Item> {

    private Node<Item> top; // 栈顶（最近添加的元素）
    private int n;          // 元素的数量

    // 定义节点的嵌套类
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() {
        top = null;
        n = 0;
    }

    /**
     * 入栈
     * @param item
     */
    public void push(Item item) {
        // 引用
        Node<Item> oldTop = top;
        top = new Node<Item>();
        top.item = item;
        top.next = oldTop;
        n++;
    }

    /**
     * 出栈
     * @return
     */
    public Item pop() {
        // 空栈
        if (n > 0) {
            // 保存栈顶元素指针
            Node<Item> oldTop = top;
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


    /**
     * 返回栈最近添加的元素而不弹出它
     * @return
     */
    public Item peek() {
        return top.item;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(top);
    }


    private class ListIterator<Item> implements Iterator<Item>{
        private Node<Item> cur;

        public ListIterator(Node<Item> first) {
            cur = first;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = cur.item;
            cur = cur.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        System.out.println("==============遍历栈===============");
        stack.push("one");
        stack.push("two");
        stack.push("three");

        for (String s : stack) {
            System.out.println("s = " + s);
        }

        String s = "";
        System.out.println("=============================");
        while ((s = stack.pop()) != null) {
            System.out.println("s = " + s);
        }



    }
}
