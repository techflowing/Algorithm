package win.techflowing.sort;

/**
 * 快速排序，复杂度为 O(n*log2(n)）
 */
public class QuickSortSentry implements Sort {

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

    /**
     * 哨兵法实现
     * 1、分为左右两个哨兵位
     * 2、左哨兵由前向后找比基准哨兵位大的数，右哨兵由后向前找比基准哨兵位小的数
     * 3、左右哨兵位的数互相交换
     * 4、重复2和3，直到左右哨兵相遇，此时相遇位置的数以及左边的数都比基准哨兵位置数字小，相遇位置右边的数都比基准哨兵位置数大
     * 5、交换左右哨兵相遇位置和基准哨兵位置的数字
     * 6、递归排序相遇位置两边的数
     */
    public void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        // 基准哨兵
        int standard = arr[left];

        while (i < j) {
            // 需要右哨兵先出发
            while (i < j && arr[j] >= standard) {
                j--;
            }

            while (i < j && arr[i] <= standard) {
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
        arr[i] = standard;
        // 递归调用
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    @Override
    public String getName() {
        return "快速排序-哨兵";
    }
}
