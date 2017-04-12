package learn.code.datastruct.sort;

/**
 * 简单选择排序 时间复杂度O(n2)
 * Created by Vigo on 17/4/9.
 */
public class SimpleSelectSort {

    public void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            // 交换
            int tmp = arr[i];
            arr[i] =arr[index];
            arr[index] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,5,4,9,8,0,-1};
        new SimpleSelectSort().selectSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
