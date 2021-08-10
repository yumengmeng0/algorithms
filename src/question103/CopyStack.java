package question103;

import chapter103.Stack;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description:
 */
public class CopyStack {

    /**
     * 复制当前栈并返回
     *
     * @return
     */
    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> newStack = new Stack<String>();
        Stack<String> tempStack = new Stack<String>();
        for (String s : stack) {
            tempStack.push(s);
        }
        while (!tempStack.isEmpty()) {
            newStack.push(tempStack.pop());
        }
        return newStack;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("hello1");
        stack.push("world");
        stack.push("!");

        for (String s : stack) {
            System.out.print(s + " ");
        }

        Stack<String> copy = copy(stack);

        System.out.println();
        for (String s : copy) {
            System.out.print(s + " ");
        }

    }

}
