package chapter103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description: ���Ͷ���ջ
 */
public class FixedCapacityStack<Item> {

    private Item[] a; // ջ��Ԫ��
    private int N;  // ջ�Ĵ�С

    /**
     * ����һ������Ϊn�Ŀ�ջ
     *
     * @param cap
     */
    public FixedCapacityStack(int cap) {
//        a = new String[n];
        // Java�в���������������
        /**
         * ����ʱ���棺
         *
         * ע: chapter103\FixedCapacityStack.javaʹ����δ�����򲻰�ȫ�Ĳ�����
         * ע: �й���ϸ��Ϣ, ��ʹ�� -Xlint:unchecked ���±��롣
         *
         * ����ʱ���棺
         *
         * chapter103\FixedCapacityStack.java:29: ����: [unchecked] δ������ת��
         *         a = (Item[]) new Object[n];
         *                      ^
         *   ��Ҫ: Item[]
         *   �ҵ�:    Object[]
         *   ����, Item�����ͱ���:
         *     Item��չ������ FixedCapacityStack��������Object
         * 1 ������
         */
        a = (Item[]) new Object[cap];
    }

    /**
     * ���һ��Ԫ��
     *
     * @param item
     */
    public void push(Item item) {
        a[N++] = item;
    }

    /**
     * ɾ�������ӵ�Ԫ��
     *
     * @return
     */
    public Item pop() {
        return a[--N];
    }

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

    public static void main(String[] args) {
        FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }

        StdOut.println("(" + s.size() + " left on stack)");

    }
}
