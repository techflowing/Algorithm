package win.techflowing.sort;

/**
 * 计数排序，复杂度为 O(n+k)，k 标书数组中最大的元素
 * 局限性：数组元素要求正整数
 */
public class CountSort implements Sort {

    @Override
    public void sort(int[] arr) {
        int max = getMax(arr);
        int[] countArr = new int[max + 1];
        // 以元素为数组下标
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }
        // 取回元素
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                arr[index++] = i;
            }
        }
    }

    /**
     * 获取数组中最大的数字
     */
    private int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
        }
        return max;
    }

    @Override
    public String getName() {
        return "计数排序";
    }
}
