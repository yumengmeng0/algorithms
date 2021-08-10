package question103;

import chapter103.Stack;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description:
 */
public class Parentheses {


    /**
     * 检查字符串s中括号是否匹配
     *
     * @param s
     * @return
     */
    public static boolean check(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            }

            if (chars[i] == ')') {
                if (stack.pop() != '(') return false;
            } else if (chars[i] == ']') {
                if (stack.pop() != '[') return false;
            } else if (chars[i] == '}') {
                if (stack.pop() != '{') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "[()]{}{[()()]()}";
        String s2 = "[(])";
        boolean check = check(s1);
        System.out.println("check = " + check);
        boolean check1 = check(s2);
        System.out.println("check1 = " + check1);

    }
}
