package win.techflowing.search;


/**
 * 二分查找
 * 要求待查表为有序表
 */
public class BinarySearch {

    public void search(int[] arr, int target) {
        System.out.println("递归实现：" + searchRecursion(arr, target, 0, arr.length - 1));
        System.out.println("非递归实现：" + searchNonRecursion(arr, target));
    }

    /**
     * 递归实现
     */
    private int searchRecursion(int[] arr, int target, int left, int right) {
        if (target < arr[left] || target > arr[right] || left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (arr[middle] > target) {
            return searchRecursion(arr, target, left, middle - 1);
        } else if (arr[middle] < target) {
            return searchRecursion(arr, target, middle + 1, right);
        } else {
            return middle;
        }
    }

    /**
     * 非递归实现
     */
    private int searchNonRecursion(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        if (target < arr[left] || target > arr[right] || left > right) {
            return -1;
        }

        while (left < right) {
            int middle = (left + right) / 2;
            if (arr[middle] > target) {
                right = middle - 1;
            } else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 6;
        new BinarySearch().search(arr, target);
    }
}
