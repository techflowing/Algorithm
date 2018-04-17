package win.techflowing.sort;

/**
 * 插入排序，复杂度为 O(n^2)
 */
public class InsertSort {
    /**
     * 通过比较当前元素和其之前已排好序的元素的大小，
     * 找到合适的位置插入，并把插入位置后的元素往后移动
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 当前需要插入的元素
            int current = arr[i];
            int position = i;
            // 寻找插入的位置，从已排序序列的尾部开始逆序比较，
            // 只要比待插入的数据大，那就向后移动，直到不大于该数据，
            // 此时空出来的位置就放入待插入数据
            while (position > 0 && arr[position - 1] > current) {
                arr[position] = arr[position - 1];
                position--;
            }
            arr[position] = current;
        }
    }
}
