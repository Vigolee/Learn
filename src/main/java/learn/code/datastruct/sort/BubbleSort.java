package learn.code.datastruct.sort;

/**
 * 冒泡排序，最好时间复杂度O(n)，最坏O(n2)，平均O(n2);稳定
 * Created by Vigo on 17/3/30.
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) { // 注意此处
                if(arr[j] > arr[j + 1]){ // 注意此处
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void bubbleSort_Op(int[] arr){
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,2,1,3,7,5};
        bubbleSort_Op(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
