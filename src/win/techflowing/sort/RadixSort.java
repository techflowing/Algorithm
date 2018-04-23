package win.techflowing.sort;

/**
 * 基数排序，复杂度 O(d * (n + r))，d 为位数，r 为基数，n 为原数组元素个数
 * 局限性：数组元素要求正整数
 */
public class RadixSort implements Sort {

    /**
     * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零
     * 然后，从最低位开始，依次进行一次排序
     * 这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列
     * <p>
     * 1、先找出待排序数组的最大值，确定有多少位，确定要排多少次
     * 2、创建二维数组temp[10][arr.length]来存放每次排序好的元素
     * 3、每次排序好，遍历二维数组取回到arr[]中
     */
    @Override
    public void sort(int[] arr) {
        // 一共10个数字
        int numSize = 10;
        int[][] tempArr = new int[numSize][arr.length];
        int[] count = new int[numSize];

        int maxRadix = getRadixCount(getMax(arr));
        int place = 1;
        // 循环 "最大数字的位数" 次
        while (maxRadix > 0) {
            for (int i = 0; i < arr.length; i++) {
                // 获取当前位的数字
                int digit = (arr[i] / place) % 10;
                tempArr[digit][count[digit]] = arr[i];
                count[digit]++;
            }
            place *= 10;
            // 数组下标
            int index = 0;
            // 取回数据
            for (int i = 0; i < numSize; i++) {
                for (int j = 0; count[i] != 0 && j < count[i]; j++) {
                    arr[index++] = tempArr[i][j];
                }
                count[i] = 0;
            }
            maxRadix--;
        }
    }

    /**
     * 获取一个数字有几位
     */
    private int getRadixCount(int num) {
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
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
        return "基数排序";
    }
}
