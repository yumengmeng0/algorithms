package list;

/**
 * @author: ymm
 * @date: 2021/6/20
 * @version: 1.0.0
 * @description:
 */
public class Main {


    public static void main(String[] args) {
        double log = Math.log(2);
        System.out.println(log);

        FinalTest finalTest = new FinalTest();
        FinalTest that = new FinalTest();


        FinalTestSub finalTestSub = new FinalTestSub();
        finalTestSub.plus(that);

    }
}
