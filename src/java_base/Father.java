package java_base;

/**
 * @author: ymm
 * @date: 2021/6/27
 * @version: 1.0.0
 * @description:
 */
public class Father {
    public int publicField = 1;
    private int privateField = 11;

    public final int publicFinalField;  // final修饰的在子类中不能重新赋值
    private final int privateFinalField;

    public static int publicStaticField = 3;
    private static final int privateStaticField = 33;

    public Father(int finalField, int privateFinalField) {
        this.publicFinalField = finalField;
        this.privateFinalField = privateFinalField;
    }
}
