package win.techflowing.sort;

/**
 * 排序算法的统一接口
 */
public interface Sort {
    /**
     * 排序
     *
     * @param arr 要排序的数组
     */
    void sort(int[] arr);

    /**
     * 获取排序算法名称
     */
    String getName();
}
