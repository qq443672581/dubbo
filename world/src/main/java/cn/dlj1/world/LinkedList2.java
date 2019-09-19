package cn.dlj1.world;

/**
 * 双向链表
 * @param <T>
 */
public class LinkedList2<T> {

    public Node<T> first;

    public void add(T t) {

        if (null == first) {
            first = new Node<T>(t, null, null);
            return;
        }

        Node<T> node = first;
        while (null != node.next) {
            node = node.next;
        }
        node.next = new Node<T>(t, node, null);
    }

    public void reverse() {
        Node<T> node = first;
        if (null == node || null == node.next || 1 == 2) {
            return;
        }

        Node<T> n1 = node;
        Node<T> n2 = node;

        n1.prev = n1.next;
        n1.next = null;

        while (null != n1) {
            n2 = n1;

            Node<T> t = n1.next;
            n1.next = n1.prev;
            n1.prev = t;


            n1 = t;
        }

        first = n2;
    }

    public static class Node<T> {
        public Node<T> prev;
        public T t;
        public Node<T> next;

        public Node(T t, Node<T> prev, Node<T> next) {
            this.t = t;
            this.prev = prev;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        LinkedList2<Integer> list = new LinkedList2<Integer>();

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
