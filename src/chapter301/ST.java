package chapter301;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.TreeMap;

/**
 * @author: ymm
 * @date: 2021/7/8
 * @version: 1.0.0
 * @description: һ������ķ��ű�API
 */
public class ST<Key extends Comparable<Key>, Value> {

    private TreeMap<Key, Value> st;

    /**
     * ����һ�ŷ��ű�
     */
    public ST() {
        st = new TreeMap<Key, Value>();
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
     * ��С�ļ�
     *
     * @return
     */
    public Key min() {
        return null;
    }

    /**
     * ���ļ�
     *
     * @return
     */
    public Key max() {
        return null;
    }


    /**
     * С�ڵ���key������
     *
     * @param key
     * @return
     */
    public Key floor(Key key) {
        return null;
    }

    /**
     * ���ڵ���key����С��
     *
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        return null;
    }


    /**
     * С��key�ļ�����
     *
     * @param key
     * @return
     */
    public int rank(Key key) {
        return 0;
    }

    /**
     * ����Ϊk�ļ�
     *
     * @param k
     * @return
     */
    public Key select(int k) {
        return null;
    }

    /**
     * ɾ����С�ļ�
     */
    public void deleteMin() {

    }

    /**
     * ɾ�����ļ�
     */
    public void deleteMax() {

    }


    /**
     * [lo,hi]֮��ļ�������
     *
     * @param lo
     * @param hi
     * @return
     */
    public int size(int lo, int hi) {
        return 0;
    }


    /**
     * @param lo
     * @param hi
     * @return
     */
    public Iterable<Key> keys(int lo, int hi) {
        return null;
    }

    /**
     * �������м��ļ��ϣ�������
     *
     * @return
     */
    public Iterable<Key> keys() {
        return null;
    }


    public static void main(String[] args) {
        ST<String, Integer> st;
        st = new ST<String, Integer>();

        for (int i = 0; !st.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
