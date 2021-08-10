package chapter103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description: ����
 */
public class Queue<Item> implements Iterable<Item> {

    private Node first; // ָ��������ӵĽ�������
    private Node last;  // ָ�������ӵĽڵ������
    private int N;      // �����е�Ԫ������

    private class Node {
        // ����ڵ��Ƕ����
        Item item;
        Node next;
    }

    public void enqueue(Item item) {
        // ���β���Ԫ��
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last; //��ԭ���ǿն��У���ͷ��λִ��ͬһ��Ԫ��
        else oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        // �ӱ�ͷɾ��Ԫ��
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }

        StdOut.println("(" + q.size() + " left on queue)");
    }

}
