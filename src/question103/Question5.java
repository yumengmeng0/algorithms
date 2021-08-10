package question103;

import chapter103.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description:
 */
public class Question5 {

    public static void main(String[] args) {
        int N = 50;
        Stack<Integer> stack = new Stack<Integer>();
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) {
            StdOut.print(d);
        }
        StdOut.println();
    }

}
