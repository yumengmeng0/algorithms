package chapter103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description: ��ѹ��ջ������ʵ�֣�
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first; // ջ���������ӵ�Ԫ�أ�
    private int N; // Ԫ������

    private class Node {
        // �����˽ڵ��Ƕ����
        Item item;
        Node next;
    }

    public void push(Item item) {
        // ��ջ�����Ԫ��
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        // ��ջ��ɾ��Ԫ��
        Item item = first.item;
        first = first.next;
        N--;
//        System.out.println("item = " + item);
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }


    /**
     * ���������ӵ�Ԫ�ض�������
     * @return
     */
    public Item peek() {
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }

        StdOut.println("(" + s.size() + " left on stack)");

    }
}
