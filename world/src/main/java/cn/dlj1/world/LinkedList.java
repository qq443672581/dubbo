package cn.dlj1.world;

/**
 * 单向链表
 *
 * @param <T>
 */
public class LinkedList<T> {


    public Node<T> first;

    public void add(T t) {

        if (null == first) {
            first = new Node<T>(t, null);
            return;
        }

        Node<T> node = first;
        while (null != node.next) {
            node = node.next;
        }
        node.next = new Node<T>(t, null);
    }

    public void reverse() {
        Node<T> node = first;
        if (null == node || null == node.next) {
            return;
        }

        Node<T> n1 = node;
        Node<T> n2 = node.next;
        n1.next = null;

        while (null != n2) {

            Node<T> t = n2.next;
            n2.next = n1;

            n1 = n2;
            n2 = t;

        }

        first = n1;
    }

    public static class Node<T> {
        public T t;
        public Node<T> next;

        public Node(T t, Node<T> next) {
            this.t = t;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 1; i < 10; i++) {

            list.add(i);
        }

        Node<Integer> node = list.first;
        if (null == node) {
            return;
        }

        while (null != node) {
            System.out.print(node.t);
            node = node.next;
        }

        //
        System.out.println();
        //
        list.reverse();
        node = list.first;

        while (null != node) {
            System.out.print(node.t);
            node = node.next;
        }


    }

}
