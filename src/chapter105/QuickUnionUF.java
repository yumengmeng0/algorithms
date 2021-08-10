package chapter105;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/2
 * @version: 1.0.0
 * @description:
 */
public class QuickUnionUF {

    private int[] id; // ����id���Դ�����Ϊ������
    private int count; // ��������


    public QuickUnionUF(int N) {
        // ��ʼ������id����
        count = N;
        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {

        return find(p) == find(q);
    }

    /**
     * quick-union�㷨
     *
     * ֻ��i == id[i]��¼�ĵ�i��¼������ͬ��ͨ����ֵ
     *
     * @param p
     * @return
     */
    private int find(int p) {
        // �ҳ�����������
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        // ��p��q�ĸ��ڵ�ͳһ
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;

        count--;
    }

    public static void main(String[] args) {
        // �����StdIn�õ��Ķ�̬��ͨ������
        int N = StdIn.readInt();    // ��ȡ��������
        QuickUnionUF uf = new QuickUnionUF(N);          // ��ʼ��N������

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();            // ��ȡ������
            if (uf.connected(p, q)) continue;   // �������ͨ�����
            uf.union(p, q);                     // �鲢����
            StdOut.println(p + " " + q);        // ��ӡ����
        }

        StdOut.println(uf.count() + "components");
    }

}
