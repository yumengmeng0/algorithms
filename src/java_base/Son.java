package java_base;

/**
 * @author: ymm
 * @date: 2021/6/27
 * @version: 1.0.0
 * @description:
 */
public class Son extends Father{


    public Son(int finalField, int privateFinalField) {
        super(finalField, privateFinalField);
    }

    public void f1() {
        this.publicField = 2;
//        this.publicFinalField = 3; // Cannot assign a value to final variable 'publicFinalField'
    }
}
