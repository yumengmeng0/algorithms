package question103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.IllegalFormatCodePointException;
import java.util.Iterator;
import java.util.Queue;

/**
 * @author: ymm
 * @date: 2021/6/30
 * @version: 1.0.0
 * @description: 环形链表实现的队列
 */
public class CircularQueue<Item> implements Iterable<Item> {

    private Node<Item> last;  // 指向最近添加的节点的链接，last.next的值为first
    private int N;      // 队列中的元素数量

    private class Node<Item> {
        // 定义节点的嵌套类
        Item item;
        Node<Item> next;
//        Node<Item> prev;
    }

    /**
     * 入队
     *
     * @param item
     */
    public void enqueue(Item item) {
        // 向标尾添加元素
        Node<Item> newNode = new Node();
        newNode.item = item;

        if (isEmpty()) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        N++;
    }

    /**
     * 出队
     *
     * @return
     */
    public Item dequeue() {
        if (isEmpty()) return null;
        Item item = last.next.item;

        if (N == 1) last = null;
        else {
            Node<Item> t = last.next;
            item = t.item;
            last.next = last.next.next;
            t.next = null;
        }
        N--;
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("CircularQueue{");
        if (N > 0) {
            Node<Item> current = last.next;
            for (int i = 0; i < N; i++) {
                sb.append(current.item);
                current = current.next;
                if (i != N - 1) sb.append(',');
            }
        }
        sb.append('}');
        sb.append(", size = " + N);

        return sb.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        CircularQueue<String> queue = new CircularQueue<>();
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");

        for (int i = 0; i < 3; i++) {
            System.out.println("queue = " + queue.dequeue());
            System.out.println("queue = " + queue);
        }
    }


}
