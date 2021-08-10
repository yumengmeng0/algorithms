package chapter204;

/**
 * @author: ymm
 * @date: 2021/7/7
 * @version: 1.0.0
 * @description: p202 �㷨2.6���ڶѵ����ȶ���
 */
public class HeapMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq; //���ڶѵ���ȫ������
    private int N = 0; //�洢��pq[1..N]�У�pq[0]û��ʹ��

    /**
     * ����һ����ʼ����Ϊmax�����ȶ���
     *
     * @param maxN
     */
    public HeapMaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1]; // pq[0]����
    }

    /**
     * ������в���һ��Ԫ��
     *
     * @param v
     */
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    /**
     * �������ϵĶ�����
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) { // k / 2��k�ڵ�ĸ��ڵ�
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * �������µĶ����򻯣��³���
     *
     * @param k
     */
    private void sink(int k) {
        while (2 * k < N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
     * �������Ԫ��
     *
     * @return
     */
    public Key max() {
        return pq[1]; // ���ڵ������ڵ�
    }

    /**
     * ɾ�����������Ԫ��
     *
     * @return
     */
    public Key delMax() {
        Key max = pq[1]; // �Ӹ��ڵ�õ����Ԫ��
        exch(1, N--); // ��������һ���ڵ㽻��
        pq[N + 1] = null; // ��ֹ��������
        sink(1);
        return max;
    }

    /**
     * ���ض����Ƿ�Ϊ��
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * �������ȶ����е�Ԫ�ظ���
     *
     * @return
     */
    public int size() {
        return N;
    }

//    public static void sort(Comparable[] a) {
//        int N = a.length;
//        for (int k = N / 2; k >= 1; k++) ;
////            sink()
//    }

    public static void main(String[] args) {
        HeapMaxPQ<String> stringHeapMaxPQ = new HeapMaxPQ<String>(99);
        stringHeapMaxPQ.insert("z");
        stringHeapMaxPQ.insert("b");
        stringHeapMaxPQ.insert("c");
        stringHeapMaxPQ.insert("d");
        System.out.println(stringHeapMaxPQ.max());
    }

}
