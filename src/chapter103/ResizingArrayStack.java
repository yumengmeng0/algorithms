package chapter103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description:
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1]; // ջԪ��
    private int N = 0; // Ԫ������

    /**
     * ջ�Ƿ�Ϊ��
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * ջ��Ԫ�ص�����
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * @param max
     */
    private void resize(int max) {
        // ��ջ�ƶ���һ����СΪmax��������
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    /**
     * ���һ��Ԫ��
     *
     * @param item
     */
    public void push(Item item) {
        // ��Ԫ����ӵĵ�ջ��
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    /**
     * ɾ�������ӵ�Ԫ��
     *
     * @return
     */
    public Item pop() {
        // ��ջ��ɾ��Ԫ��
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        // ֧�ֺ��ȳ��ĵ���
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack s = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }

        StdOut.println("(" + s.size() + " left on stack)");

    }
}
