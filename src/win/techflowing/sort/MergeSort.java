package win.techflowing.sort;

/**
 * 归并排序，复杂度为O(n*log2(n)）
 */
public class MergeSort {
    /**
     * 按中点切割表，划分成左右两个子表，再继续对左右两个子表分别进行划分，
     * 直到无法划分为止，然后两两合并
     * 总体分为两步：
     * 1、划分半子表
     * 2、合并半子表
     */
    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归拆分半子表
     *
     * @param arr   数组
     * @param left  数组起始下标
     * @param right 数组终止下标
     */
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * 合并半子表，此处写法不唯一
     *
     * @param arr   数组
     * @param left  数组起始下标
     * @param mid   数组中点下标
     * @param right 数组终止下标
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int leftIndex;
        int rightIndex;
        // 辅助数组,暂存合并的结果
        int[] tempArr = new int[right - left + 1];
        int index = 0;
        // 将数组前半部分和后半部分合并成一个有序表
        for (leftIndex = left, rightIndex = mid + 1; leftIndex <= mid && rightIndex <= right; index++) {
            if (arr[leftIndex] < arr[rightIndex]) {
                tempArr[index] = arr[leftIndex++];
            } else {
                tempArr[index] = arr[rightIndex++];
            }
        }

        // 将剩余的（比另一边多出来的个数）放到temp数组中
        while (leftIndex <= mid) {
            tempArr[index++] = arr[leftIndex++];
        }

        while (rightIndex <= right) {
            tempArr[index++] = arr[rightIndex++];
        }

        // 将temp数组中的元素写入到待排数组中
        for (int i = 0; i < tempArr.length; i++) {
            arr[left + i] = tempArr[i];
        }
    }
}
