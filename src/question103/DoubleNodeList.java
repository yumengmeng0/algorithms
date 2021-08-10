package question103;

import java.util.Iterator;

/**
 * @author: ymm
 * @date: 2021/6/30
 * @version: 1.0.0
 * @description: 1.3.31
 */
public class DoubleNodeList<Item> implements Iterable<Item> {

    private DoubleNode<Item> first;
    private DoubleNode<Item> last;
    private int N;

    private class DoubleNode<Item> {
        Item item;
        DoubleNode<Item> prev;
        DoubleNode<Item> next;
    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static <Item> void insertHead(Item item) {

    }

}
