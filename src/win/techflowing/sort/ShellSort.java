package win.techflowing.sort;

/**
 * 希尔排序，复杂度为 O(n^1.3)
 */
public class ShellSort implements Sort {
    /**
     * 先将待排序的元素分为多个子序列，使得每个子序列的元素个数相对较少
     * 然后对各个子序列分别进行直接插入排序，待整个待排序序列 "基本有序"后
     * 最后对所有数据进行一次直接插入排序
     * 具体流程如下：
     * 1、将包含n个元素的数组，分成n/2个数组序列，第一个数据和第n/2 + 1个数据为一对...
     * 2、对每对数据进行比较和交换，排好顺序
     * 3、然后分成n/4个数组序列，再次排序
     * 4、不断重复以上过程，随着序列减少并直至为1，排序完成
     */
    @Override
    public void sort(int[] arr) {
        // 划组，gap 步长
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            // 组内插入排序
            for (int i = gap; i < arr.length; i++) {
                int current = arr[i];
                int position = i;
                // 一次插入
                while (position - gap >= 0 && arr[position - gap] > current) {
                    arr[position] = arr[position - gap];
                    position = position - gap;
                }
                arr[position] = current;
            }
        }
    }

    @Override
    public String getName() {
        return "希尔排序";
    }
}
