package win.techflowing.sort;

/**
 * 冒泡排序，复杂度为 O(n^2)
 */
public class BubbleSort implements Sort {
    /**
     * 从第一个记录开始依次对相邻的数进行比较，
     * 当前面的数字大于后面的数时，交换位置，
     * 进行一轮比较和换位后，最大的数位于第n位，
     * 然后对前n-1个数进行第二轮比较，重复该过程
     */
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "冒泡排序";
    }
}
