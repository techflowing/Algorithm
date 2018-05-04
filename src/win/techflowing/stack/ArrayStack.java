package win.techflowing.stack;

import java.util.Arrays;

/**
 * 基于数组实现的简单栈
 */
public class ArrayStack<E> {
    /** 初始大小 */
    private static final int INIT_SIZE = 10;
    /** 扩容大小 */
    private static final int EXTEND_SIZE = 10;
    /** 存储的数组 */
    private Object[] stackArray;
    /** 栈大小 */
    private int size;

    /**
     * 构造函数
     */
    public ArrayStack() {
        stackArray = new Object[INIT_SIZE];
        size = 0;
    }

    /**
     * 栈是否空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取栈顶元素
     */
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) stackArray[size - 1];
    }

    /**
     * 出栈
     */
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        size--;
        return (E) stackArray[size];
    }

    /**
     * 入栈
     */
    public E push(E e) {
        ensureCapacity(size + 1);
        stackArray[size++] = e;
        return e;
    }

    /**
     * 栈扩容
     */
    private void ensureCapacity(int size) {
        if (size > stackArray.length) {
            int len = stackArray.length + EXTEND_SIZE;
            stackArray = Arrays.copyOf(stackArray, len);
        }
    }
}
