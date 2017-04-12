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

    public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        new ShellSort().shellSort(nums);
        for(int a : nums)
            System.out.println(a);
    }
}
