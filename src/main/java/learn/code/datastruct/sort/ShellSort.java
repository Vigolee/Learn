package learn.code.datastruct.sort;

/**
 * Created by Vigo on 17/4/9.
 */
public class ShellSort {

    public void shellSort(int[] arr){
        int increment = arr.length;
        while (increment > 1){
            increment = increment/ 3 +1;
            for (int i = 0; i < arr.length; i ++) {
                insertSort(arr, i, increment);
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     * @param start
     * @param increment
     */
    private void insertSort(int[] arr, int start, int increment){
        for (int i = start + increment; i < arr.length; i += increment) {
            int j = i - increment;
            int key = arr[i];
            while (j >= 0){
                if(arr[j] > key){
                    arr[j + increment] = arr[j];
                }else {
                    break;
                }
                j -= increment;
            }
            arr[j + increment] = key;
        }
    }

    void test(int[] arr){
        int increment = arr.length;
        while (increment > 1){
            increment = increment/ 3 +1; // 增量
            for (int i = increment; i < arr.length; ++i){
                int j = i - increment; // 有序数组下标
                int key = arr[i]; // 待插入元素
                while (j >=0){
                    if(key < arr[j]){
                        arr[j + increment] = arr[j];
                        j -= increment;
                    }else {
                        break;
                    }
                    arr[j + increment] = key; // 插入
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 , -1};
        new ShellSort().test(nums);
        for(int a : nums)
            System.out.println(a);
    }
}
