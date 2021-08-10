package question103;

import chapter103.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description:
 */
public class Question9 {

    /**
     * 待完善
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        Queue<String> inQueue = new Queue<>();
        Queue<String> outQueue = new Queue<>();
        Queue<String> tempQueue = new Queue<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals(")")) {
                outQueue.enqueue("(");
                while (!tempQueue.isEmpty()) {
                    outQueue.enqueue(tempQueue.dequeue());
                }
                outQueue.enqueue(s);
            } else if (s.equals("*")) {
                outQueue.enqueue(s);
            } else {
                tempQueue.enqueue(s);
            }

        }

//        for (String s : outQueue) {
//            System.out.print(s + " ");
//        }

        while (!outQueue.isEmpty()) {
            System.out.print(outQueue.dequeue() + " ");
        }
    }
}
