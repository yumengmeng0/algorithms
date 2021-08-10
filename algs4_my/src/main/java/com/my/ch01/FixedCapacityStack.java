package com.my.ch01;

/**
 * @author: ymm
 * @date: 2021/5/19
 * @version: 1.0.0
 * @description:
 * 带泛型的固定容量的栈
 *
 */
public class FixedCapacityStack<Item> {
    private Node<Item> top;
    private int n;
    private int capacity;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public FixedCapacityStack(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 入栈
     *
     * @param item
     */
    public void push(Item item) {
        if (n < capacity) {
            // 引用
            Node<Item> oldTop = top;
            top = new Node<Item>();
            top.item = item;
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

        while ((s = stack.pop()) != null) {
            System.out.println("s = " + s);
        }

    }

}
