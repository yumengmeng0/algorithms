package chapter301;

/**
 * @author: ymm
 * @date: 2021/7/8
 * @version: 1.0.0
 * @description: ˳����ң�������������
 */
public class SequentialSearchST<Key, Value> {

    private Node first;

    private class Node { // ����Ľڵ�Ķ���
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        // ���Ҹ����ļ��������������ֵ
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value; // ����
            }
        }
        return null; // δ����
    }

    public void put(Key key, Value val) {
        // ���Ҹ����ļ����ҵ��������ֵ�������ڱ����½��ڵ�
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {  // ���У�����
                x.value = val;
                return;
            }
        }
        first = new Node(key, val, first); // ����ͷ��
    }

    public static void main(String[] args) {
        
    }

}
