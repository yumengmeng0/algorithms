package question103;

import java.util.Iterator;

/**
 * @author: ymm
 * @date: 2021/6/29
 * @version: 1.0.0
 * @description:
 */
public class List<Item> implements Iterable<Item> {

    private Node<Item> first; // 链表首结点
    private Node<Item> last; // 链表首结点
    private int N;      // 链表长度


    private static class Node<Item> {
        Item item;
        Node<Item> prev;  // 前置结点
        Node<Item> next;

        public Node(Node<Item> prev, Item item, Node<Item> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 向链表尾部添加元素
     *
     * @param item
     */
    public void add(Item item) {
        Node<Item> node = new Node(null, item, null);

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            node.prev = last;
            last.next = node;
            last = last.next;
        }

        N++;
    }

    /**
     * 返回链表中第i个元素
     *
     * @param i
     * @return
     */
    public Item get(int i) {
        if (i >= N || i < 0) throw new IndexOutOfBoundsException(i);

        Node<Item> node = first;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        return node.item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 删除链表尾部元素
     *
     * @return
     */
    public Item deleteTail() {
        if (last == null) return null;
        Item item = last.item;
        last = last.prev;
        last.next = null;
        N--;
        return item;
    }

    public Item deleteTail1() {
        if (N == 0) throw new IndexOutOfBoundsException(N - 1);
        Node<Item> current = first;
        for (int i = 0; i < N - 1; i++) {
            current = current.next;
        }
        current.next = null;
        N--;
        return current.item;
    }

    /**
     * 删除第k个元素
     *
     * @param k
     * @return
     */
    public Item delete(int k) {
        if (k < 0 || k >= N) throw new IndexOutOfBoundsException(k);

        Item item;
        Node<Item> current = first;
        for (int i = 0; i < k; i++) {
            current = current.next;
        }

        item = current.item;
        if (current.prev != null) // 删除的不是是头结点
            current.prev.next = current.next;
        else {
            first = current.next;
            current.next = null;
        }
        N--;
        return item;
    }

    // 没有previous的时候
    public Item delete1(int k) {
        if (k < 0 || k >= N) throw new IndexOutOfBoundsException(k);

        Item item;

        if (k == 0) { // 删除头结点
            item = first.item;
            first = first.next;
        } else {
            Node<Item> previousNode = first; // 当k>0时，previousNode指向要删除的元素的前置结点
            for (int i = 0; i < k - 1; i++) {
                previousNode = previousNode.next;
            }
            item = previousNode.next.item;
            if (k == N) { // 删除的是链表尾部元素
                previousNode.next = null;
                last = previousNode;
            }

        }

        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        Node<Item> current = first;
        int i = 0;

        @Override
        public boolean hasNext() {
            return i != N;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            i++;
            return item;
        }

        @Override
        public void remove() {

        }
    }


    /**
     * 查找链表list的item中是否存在item，存在方法true，否则返回false
     *
     * @param list
     * @param item
     * @param <Item>
     * @return
     */
    public static <Item> boolean find(List<Item> list, Item item) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(item)) return true;
        }
        return false;
    }

    /**
     * 返回node结点在链表中的索引，若结点不在链表中，则返回-1
     *
     * @param node
     * @return
     */
    private int indexOfList(Node<Item> node) {
        if (node == null) return -1;

        Node<Item> current = first;
        for (int index = 0; index < N; index++) {
            if (current == node)
                return index;
            current.next = current;
        }

        return -1;
    }

    // 1.3.24

    /**
     * 删除node的后续结点
     *
     * @param node
     */
    private void removeAfter(Node<Item> node) {
        if (node == null) return;
        int index = indexOfList(node);
        if (index == -1) return; // 结点不在链表中

        node.next = null;
        last = node;  // 尾结点为当前结点
        N = index + 1;
    }

    // 1.3.25

    /**
     * 向firstNode结点后插入secondNode结点
     *
     * @param firstNode
     * @param secondNode
     */
    private void insertAfter(Node<Item> firstNode, Node<Item> secondNode) {
        if (indexOfList(firstNode) == -1) return; // firstNode结点不在链表中
        if (firstNode == null || secondNode == null) return;
        secondNode.prev = firstNode;
        secondNode.next = firstNode.next;
        firstNode.next = secondNode;
        N++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<Item> current = first;
        sb.append("List{");
        for (int i = 0; i < N; i++) {
            if (current != null) {
                sb.append(current.item);
                if (i != N - 1) sb.append(',');
                current = current.next;
            }
        }
        sb.append('}');
        sb.append(",size = " + N);

//        return "List{" +
//                "first=" + first +
//                ", last=" + last +
//                ", N=" + N +
//                '}';
        return sb.toString();
    }

    // 1.3.26

    /**
     * @param list
     * @param key
     * @param <Item>
     * @return
     */
    public static <Item> int remove(List<Item> list, Item key) {
        if (list == null) return 0;
        Node current = list.first;
        int size = list.size(), count = 0;

        for (int i = 0; i < size; i++) {
            if (current.item.equals(key)) {
                if (current == list.first) { // 删除头结点，需要修改头结点
                    list.first = list.first.next;
                } else {
                    current.prev.next = current.next;
                }

                if (current == list.last) { // 删除的是尾结点，需要修改尾结点指针
                    list.last = list.last.prev;
                } else {
                    current.next.prev = current.prev;
                }
//                System.out.println("current.prev.item = " + current.prev.item);
//                System.out.println("current.item = " + current.item);
//                System.out.println(current.prev.item == list.first);


                Node<Item> t = current;

                current = current.next;

                t.prev = null;
                t.next = null;
                list.N--;
                count++;

            } else {
                current = current.next;
            }
        }
        return count;
    }


    // 1.3.27

    /**
     * 根据链表首节点找出链表中的最大值
     *
     * @param firstNode
     * @return
     */
    private int max(Node<Integer> firstNode) {
        if (firstNode == null) return 0;

        Node<Integer> current = firstNode;
        Integer max = firstNode.item;

        for (int i = 0; i < N; i++) {
            if (max < current.item) max = current.item;
            current = current.next;
        }

        return max;
    }

    // 1.3.28

    /**
     * 根据链表首节点找出链表中的最大值（递归）
     *
     * @param firstNode
     * @return
     */
    private int max1(Node<Integer> firstNode) {
        return 0;
    }


    public static void main(String[] args) {
        List<String> list = new List<>();
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("three");
        list.add("three");
        System.out.println("list = " + list);
        System.out.println();
        remove(list, "three");
        System.out.println("list = " + list);

        List<Integer> intList = new List<>();
        intList.add(42);
        intList.add(44);
        intList.add(85);
        intList.add(11);
        intList.add(3);
        int max = intList.max(intList.first);
        System.out.println("max = " + max);

//        remove(list, "three");
//        for (String s : list) {
//            System.out.print(s + ", ");
//        }
//        System.out.println();
//
//        // 1.3.21
//        boolean three = find(list, "three");
//        boolean one1 = find(list, "one1");
//        System.out.println(three + "," + one1);
//
////        System.out.println("list.get(2) = " + list.get(0));
////        System.out.println("list.get(2) = " + list.get(1));
////        System.out.println("list.get(2) = " + list.get(2));
////        System.out.println("list.get(2) = " + list.get(3));
//        for (String s : list) {
//            System.out.print(s + ", ");
//        }
//        System.out.println();
//
////        for (int i = 0; i < 3; i++) {
//        String deletedItem = list.delete(1);
//        System.out.println(deletedItem);
//        System.out.println("==========");
//        for (String s : list) {
//            System.out.print(s + ", ");
//        }
//        }


//        System.out.println();
//        list.deleteTail();
//        for (String s : list) {
//            System.out.print(s + ", ");
//        }
//        System.out.println();
//        list.deleteTail();
//        for (String s : list) {
//            System.out.print(s + ", ");
//        }
//        list.deleteTail();


    }

}

