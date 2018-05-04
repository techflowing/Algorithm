package win.techflowing.queue;

import java.util.Arrays;

/**
 * 基于数组实现的简单队列
 */
public class ArrayQueue<E> {

    /** 初始大小 */
    private static final int INIT_SIZE = 10;
    /** 扩容大小 */
    private static final int EXTEND_SIZE = 10;
    /** 存储的数组 */
    private Object[] queueArray;
    /** 队列大小 */
    private int size;

    /**
     * 构造函数
     */
    public ArrayQueue() {
        queueArray = new Object[INIT_SIZE];
    }

    /**
     * 队列是否空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 出队
     */
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E data = (E) queueArray[0];
        System.arraycopy(queueArray, 1, queueArray, 0, size - 1);
        size--;
        return data;
    }

    /**
     * 入队
     */
    public void offer(E data) {
        ensureCapacity(size + 1);
        queueArray[size++] = data;
    }

    /**
     * 队列扩容
     */
    private void ensureCapacity(int size) {
        if (size > queueArray.length) {
            int len = queueArray.length + EXTEND_SIZE;
            queueArray = Arrays.copyOf(queueArray, len);
        }
    }
}
