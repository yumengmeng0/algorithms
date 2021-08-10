package question103;

import chapter103.Queue;
import edu.princeton.cs.algs4.StdIn;

/**
 * @author: ymm
 * @date: 2021/6/29
 * @version: 1.0.0
 * @description:
 */
public class Question15 {

    /**
     * 1.3.15
     * 打印标准输入中倒数第k个字符串
     * @param args
     */
    public static void main(String[] args) {
        int k = StdIn.readInt();
        Queue<String> queue = new Queue<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            queue.enqueue(s);
        }
        String lastK;
        k = queue.size() - k;
        do {
            lastK = queue.dequeue();
            System.out.println("1lastK = " + lastK);
        } while (k-- != 0);
        System.out.println("lastK = " + lastK);
    }
}
