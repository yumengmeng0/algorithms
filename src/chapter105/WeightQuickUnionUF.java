package chapter105;

/**
 * @author: ymm
 * @date: 2021/7/4
 * @version: 1.0.0
 * @description:
 */
public class WeightQuickUnionUF {

    private int[] id; // 父连接数组（由触点索引）
    private int[] sz; // （由触点索引的）各个根节点所对应的分量大小
    private int count; // 连通分量的数量

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
        // 跟随连接找到根节点
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // 将小树的根节点连接到大树的根节点
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
