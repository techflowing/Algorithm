package win.techflowing.queue;

/**
 * 基于链表实现的简单队列
 */
public class ListQueue<E> {

    /** 队头节点 */
    private Node<E> head = null;
    /** 队尾节点 */
    private Node<E> tail = null;

    /**
     * 队列是否空
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * 入队
     */
    public void offer(E e) {
        Node<E> node = new Node<>(e);
        if (isEmpty()) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    /**
     * 出队
     */
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E data = head.data;
        head = head.next;
        return data;
    }

    /**
     * 数据节点
     *
     * @param <T>
     */
    private class Node<T> {
        Node<T> next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }
}
