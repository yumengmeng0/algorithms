package chapter301;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/7/8
 * @version: 1.0.0
 * @description:
 */
public class FrequencyCounter {

    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]); // ��С����
        ST<String, Integer> st = new ST<String, Integer>();

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minlen) continue; // ���Խ϶̵ĵ���
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }

        // �ҳ�����Ƶ����ߵĵ���
        String max = " ";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }

        StdOut.println(max + " " + st.get(max));
    }
}
