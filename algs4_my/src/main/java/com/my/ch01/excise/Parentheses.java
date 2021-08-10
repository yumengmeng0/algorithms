package com.my.ch01.excise;

import com.my.ch01.Stack;

/**
 * @author: ymm
 * @date: 2021/5/23
 * @version: 1.0.0
 * @description:
 */
public class Parentheses {

    public static void main(String[] args) {
        char[] a = {'[','(', ')', '{', '}', ')'};

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            // 左括号入栈
            if (a[i] == '[' || a[i] == '{' || a[i] == '('){
                stack.push(a[i]);
            }

            if (a[i] == ')') {
                if (stack.pop() == '(') {
                    continue;
                }else {
                    throw new RuntimeException("(括号不匹配");
                }
            }

            if (a[i] == '}') {
                if (stack.pop() == '{') {
                    continue;
                }else {
                    throw new RuntimeException("{括号不匹配");
                }
            }

            if (a[i] == ']') {
                if (stack.pop() == '[') {
                    continue;
                }else {
                    throw new RuntimeException("[括号不匹配");
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("括号匹配" );
        }
    }
}
