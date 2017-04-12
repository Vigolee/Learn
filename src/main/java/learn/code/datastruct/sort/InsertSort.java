package learn.code.datastruct.sort;

/**
 * 直接插入 最好时间复杂度O(n)，最坏O(n2)，性能比选择和冒泡好，因为平均比较次数少；稳定
 * Created by Vigo on 17/4/9.
 */
public class InsertSort {

    public void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0){
                if(key > arr[j]){
                    break;
                }else {
                    arr[j + 1] = arr[j]; // 后移动
                }
                j--;
            }
            arr[j + 1] = key; // 注意此处
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        new InsertSort().insertSort(nums);
        for(int a : nums)
            System.out.println(a);
    }
}
