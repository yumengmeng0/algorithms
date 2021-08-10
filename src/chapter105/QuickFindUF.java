package chapter105;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/2
 * @version: 1.0.0
 * @description:
 */
public class QuickFindUF {

    private int[] id; // ����id���Դ�����Ϊ������
    private int count; // ��������


    public QuickFindUF(int N) {
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
     * quick-find�㷨
     *
     * @param p
     * @return
     */
    private int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        // ��p��q�鲢����ͬ�ķ�����
        int pID = find(p);
        int qID = find(q);

        // ���p��q�Ѿ�����ͬ�ķ���֮������Ҫ��ȡ�κ��ж�
        if (pID == qID) return;

        // ��p�ķ���������Ϊq������
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[i] = qID;
        }

        count--;
    }

    public static void main(String[] args) {
        // �����StdIn�õ��Ķ�̬��ͨ������
        int N = StdIn.readInt();    // ��ȡ��������
        QuickFindUF uf = new QuickFindUF(N);          // ��ʼ��N������

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();            // ��ȡ������
            if (uf.connected(p, q)) continue;   // �������ͨ�����
            uf.union(p, q);                     // �鲢����
            StdOut.println(p + " " + q);        // ��ӡ����
        }

        StdOut.println(uf.count() + " components"); // ��ͨ�����ĸ���
    }

}
