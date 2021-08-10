package chapter102;

/**
 * @author: ymm
 * @date: 2021/6/22
 * @version: 1.0.0
 * @description:
 */
public class Counter {

    private String id = "";
    private int count = 0;

    /**
     * 创建一个名为id的计数器
     * @param id
     */
    public Counter(String id) {
        this.id = id;
    }

    /**
     * 将计数器的值加1
     */
    public void increment(){
        count++;
    }

    /**
     * 该对象创建之后计数器被加1的次数
     * @return
     */
    public int tally(){
        return count;
    }

    /**
     * 对象的字符串表示
     * @return
     */
    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", count=" + count +
                '}';
    }

    public static void staticFun() {
        /**
         * static 不能修饰局部变量
         */
//        static int a = 1; //Modifier 'static' not allowed here
    }

    public static void main(String[] args) {
        Counter counter1 = new Counter("counter1");
        Counter counter3 = new Counter("counter3");
        System.out.println(counter1.tally());
        /**
         * final修饰的变量不能重新被赋值，初始化后不会被改变
         */
        final Counter counter2 = counter1;
//        counter2 = null;
//        counter2 = counter3; // Cannot assign a value to final variable 'counter2'
        counter2.increment();
        System.out.println("counter1 = " + counter1);
        System.out.println("counter2 = " + counter2);

    }
}
