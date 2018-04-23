package win.techflowing.sort;

/**
 * 快速排序，复杂度为 O(n*log2(n)）
 */
public class QuickSortHole implements Sort {

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
     * 挖坑法实现
     * 1、基准数挖出，形成第一个坑arr[i]
     * 2、右指针由后向前找比基准数小的数，找到后挖出此数填到前一个坑arr[i]中，此处形成坑arr[j]
     * 3、左指针由前向后找比基准数大的数，找到后挖出此数填到前一个坑arr[j]中，此处形成坑arr[i]
     * 4、重复2和3，知道左右指针相等，将基准数填到坑arr[i]中
     * 5、递归排序相遇位置两边的数
     */
    public void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int standard = arr[left];

        while (i < j) {
            // 右指针先走
            while (i < j && arr[j] >= standard) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }

            while (i < j && arr[i] <= standard) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        // 填坑
        arr[i] = standard;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    @Override
    public String getName() {
        return "快速排序-挖坑法";
    }
}
