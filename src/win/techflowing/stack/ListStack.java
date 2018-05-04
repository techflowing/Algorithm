package win.techflowing.stack;

/**
 * 基于链表实现的简单栈
 */
public class ListStack<E> {

    /**
     * 栈顶指针
     */
    private Node<E> top;

    /**
     * 栈是否空
     */
    boolean isEmpty() {
        return top == null;
    }

    /**
     * 入栈
     */
    public void push(E e) {
        Node<E> node = new Node<>(e);
        node.next = top;
        top = node;
    }

    /**
     * 出栈
     */
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E data = top.data;
        top = top.next;
        return data;
    }

    /**
     * 获取栈顶元素
     */
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
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
