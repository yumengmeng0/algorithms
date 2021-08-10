package chapter102;

/**
 * @author: ymm
 * @date: 2021/6/26
 * @version: 1.0.0
 * @description:
 */
public class Question6 {


    /**
     * 判断字符串s和t是否互为的回环变位
     *
     * @param s
     * @param t
     * @return
     */
    private static boolean isCircularRotation(String s, String t) {

        for (int i = 0; i < s.length(); i++) {
            if (t.equals(s.substring(i) + s.substring(0, i)))
                return true;
        }
        return false;
    }

    // 回环变位
    public static void main(String[] args) {
//        String s = "ACTGACG", t = "TGACGAC";
        String s = "ACTGACG", t = "CGACTGA";

        boolean b = isCircularRotation(s, t);
        System.out.println("b = " + b);
    }
}
