package win.techflowing.sort;

import java.util.Random;

/**
 * 排序工具类
 */
public class SortUtil {

    /**
     * 生成随机数组
     *
     * @param size 数组大小
     * @return 数组
     */
    public static int[] buildArray(int size) {
        return buildArray(100, size);
    }

    /**
     * 生成随机数组
     *
     * @param limit 数组元素大小限制
     * @param size  数组大小
     * @return 数组
     */
    public static int[] buildArray(int limit, int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(limit);
        }
        return arr;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 验证是否从小到大排序
     *
     * @param arr 数组
     * @return 是否为排序数组
     */
    public static boolean verify(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (temp > arr[i]) {
                return false;
            }
            temp = arr[i];
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = true;
        float count = 100;
        int arrSize = 10000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            int[] arr = SortUtil.buildArray(arrSize);
            MergeSort.sort(arr);
            result = result & verify(arr);
        }
        System.out.println("验证结果：" + result);
        System.out.println("平均耗时(毫秒)：" + (System.currentTimeMillis() - startTime) / count);
    }
}
