package win.techflowing.sort;

/**
 * 选择排序，复杂度为 O(n^2)
 */
public class SelectSort {

    /**
     * 经过一轮比较找到最小的数字，然后将该数字与第一个数交换
     * 接着对不包括第一个数以外的其他数进行第二轮比较，找到最小的数字，与第二个数交换
     * 重复该过程，直到最后只有一个数为止
     */
    public static void sort(int[] arr) {
        // 当前最小数的坐标位置
        int minPos;
        int min;
        for (int i = 0; i < arr.length; i++) {
            minPos = i;
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                // 寻找最小的数字position
                if (arr[j] < min) {
                    minPos = j;
                    min = arr[j];
                }
            }
            if (minPos != i) {
                int temp = arr[i];
                arr[i] = arr[minPos];
                arr[minPos] = temp;
            }
        }
    }

}
