package win.techflowing.sort;

/**
 * 快速排序，复杂度为O(n*log2(n)）
 */
public class QuickSort implements Sort {

    /**
     * 快速排序基本分为三步：
     * 1、先从数列中取出一个数作为基准数
     * 2、分区，将比这个数大的数放在基准数的右边，小于或等于它的数全放在基准数右边
     * 3、对左右区间重复第二步，直到区间只有一个数
     */
    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        // 基准哨兵
        int sentry = arr[left];

        while (i < j) {
            while (i < j && sentry <= arr[j]) {
                j--;
            }

            while (i < j && sentry >= arr[i]) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 交换基准哨兵位置 和 i、j相遇位置的数
        arr[left] = arr[i];
        arr[i] = sentry;
        // 递归调用
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    @Override
    public String getName() {
        return "快速排序";
    }
}
