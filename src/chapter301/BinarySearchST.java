package chapter301;

/**
 * @author: ymm
 * @date: 2021/7/9
 * @version: 1.0.0
 * @description: ���ֲ��ң������������飩
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    public void put(Key key, Value val) {

        // ���Ҽ����ҵ������ֵ�����򴴽���Ԫ��
        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        for (int j = N; j > i; j++) {
            // [i..N]�Ƶ�[i+1..N+1]
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
            // ���뵽[i]
            keys[i] = key;
            vals[i] = val;
            N++;
        }
    }

    public int rank(Key key) {
        return 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
