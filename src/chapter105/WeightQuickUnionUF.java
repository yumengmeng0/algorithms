package chapter105;

/**
 * @author: ymm
 * @date: 2021/7/4
 * @version: 1.0.0
 * @description:
 */
public class WeightQuickUnionUF {

    private int[] id; // ���������飨�ɴ���������
    private int[] sz; // ���ɴ��������ģ��������ڵ�����Ӧ�ķ�����С
    private int count; // ��ͨ����������

    public WeightQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        // ���������ҵ����ڵ�
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // ��С���ĸ��ڵ����ӵ������ĸ��ڵ�
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[i] += sz[j];
        } else {
            id[j] = i;
            sz[j] = sz[i];
        }
        count--;
    }

}
