package chapter301;

/**
 * @author: ymm
 * @date: 2021/7/8
 * @version: 1.0.0
 * @description: һ�ּ򵥵ķ��ű�API
 */
public class ST311<Key, Value> {

    /**
     * ����һ�ŷ��ű�
     */
    public ST311() {
    }

    /**
     * ����ֵ������У���ֵΪ�ս���key�ӱ���ɾ����
     *
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {

    }

    /**
     * ��ȡkey��Ӧ��ֵ
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        return null;
    }

    /**
     * �ӱ���ɾȥ��key�������Ӧ��ֵ��
     *
     * @param key
     */
    public void delete(Key key) {

    }

    /**
     * ��key�ڱ����Ƿ��ж�Ӧ��ֵ
     *
     * @param key
     * @return
     */
    public boolean contains(Key key) {
        return false;
    }

    /**
     * ���Ƿ�Ϊ��
     *
     * @return
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * ���м�ֵ�Ե�����
     *
     * @return
     */
    public int size() {
        return 0;
    }

    /**
     * �������м��ļ���
     *
     * @return
     */
    public Iterable<Key> keys() {
        return null;
    }


}
