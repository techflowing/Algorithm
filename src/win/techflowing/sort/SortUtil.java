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
    private static int[] buildArray(int size) {
        return buildArray(100, size);
    }

    /**
     * 生成随机数组
     *
     * @param limit 数组元素大小限制
     * @param size  数组大小
     * @return 数组
     */
    private static int[] buildArray(int limit, int size) {
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
    private static void printArray(int[] arr) {
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
    private static boolean verify(int[] arr) {
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

    /**
     * 获取排序算法类
     */
    private static Class[] getSortClass() {
        return new Class[]{BubbleSort.class,
                InsertSort.class,
                MergeSort.class,
                QuickSort.class,
                SelectSort.class};
    }

    /**
     * 测试排序算法
     */
    private static void test(Sort sortClass) {
        if (sortClass == null) {
            System.out.printf("排序类实例为空");
            return;
        }
        boolean result = true;
        // 排序次数，避免偶然性
        float count = 100;
        // 数组大小
        int arrSize = 10000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            int[] arr = SortUtil.buildArray(arrSize);
            sortClass.sort(arr);
            result = result & verify(arr);
        }
        System.out.print(sortClass.getName() + ",验证结果：" + result);
        System.out.println(" ,平均耗时(毫秒)：" + (System.currentTimeMillis() - startTime) / count);
    }

    public static void main(String[] args) {
        for (Class sortClass : getSortClass()) {
            Sort sort = null;
            try {
                sort = (Sort) Class.forName(sortClass.getName()).newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (sort != null) {
                test(sort);
            }
        }
    }
}
