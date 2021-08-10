package list;

/**
 * @author: ymm
 * @date: 2021/6/27
 * @version: 1.0.0
 * @description:
 */
public class FinalTestSub extends FinalTest {
    private int finalVar = 3;

    public int plus(FinalTest that) {
        System.out.println("FinalTestSub finalVar = " + finalVar)
        ;
        // that.finalVar   final修饰的域可以在同类中直接.取，在其他类中不行
        return this.finalVar;
    }
}
