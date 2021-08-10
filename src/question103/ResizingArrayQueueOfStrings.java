package question103;


/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description:
 */
public class ResizingArrayQueueOfStrings {

    private String[] a;
    private int first;
    private int last;
    private int N;

    /**
     * 创建容量为cap的字符串队列
     *
     * @param cap
     */
    public ResizingArrayQueueOfStrings(int cap) {
        a = new String[cap];
    }

    public void enqueue(String s) {
        if (N == a.length) resize(2 * a.length);
        a[last++] = s;
        N++;
    }

    public String dequeue() {
        String s = a[0];

        for (int i = 0; i < last - 1; i--) {
            a[i] = a[i + 1];
        }
        a[--last] = null;
        N--;
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return s;
    }

    /**
     * 栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 栈中元素的数量
     *
     * @return
     */
    public int size() {
        return N;
    }


    /**
     * 重新设置数组容量
     *
     * @param max
     */
    private void resize(int max) {
        String[] temp = new String[max];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings(10);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        queue.enqueue("7");
        queue.enqueue("8");
        queue.enqueue("9");
        queue.enqueue("10");
        queue.enqueue("11");
        queue.enqueue("12");
        System.out.println("queue.size() = " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue() + " ");
        }
    }
}
