package chapter101;

/**
 * @author: ymm
 * @date: 2021/6/21
 * @version: 1.0.0
 * @description: ɾ�������ظ�Ԫ��
 */
public class Exercise29 {

    /**
     * ��������a��С�ڼ�keyԪ������
     * @param key
     * @param a
     * @return
     */
    public static int rank(int key, int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (key < a[i]) count++;
        }
        return count;
    }

    /**
     * ��������a�е��ڼ�keyԪ������
     * @param key
     * @param a
     * @return
     */
    public static int count(int key, int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (key == a[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }


}
