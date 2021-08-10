package chapter102;

/**
 * @author: ymm
 * @date: 2021/6/26
 * @version: 1.0.0
 * @description:
 */
public class Question7 {

    /**
     * 返回字符串s的反向字符串
     * @param s
     * @return
     */
    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
       String s = "helloworld";
        String mystery = mystery(s);
        System.out.println("mystery = " + mystery);
    }

}
