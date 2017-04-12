package learn.code.datastruct.sort;

/**
 * 归并排序，时间复杂度O(nlogn),空间复杂度O(n)，稳定
 * Created by Vigo on 17/4/9.
 */
public class MergeSort {

    /**
     * 自顶向下
     * @param arr
     */
    public void mergeSort(int[] arr){

        sort(arr,0 ,arr.length - 1);
    }
    private void sort(int[] arr,int start, int end){
        if (start < end){
            int mid = (end + start) / 2;
            sort(arr, start, mid); // 左边
            sort(arr, mid + 1, end);// 右边
            merge(arr, start, mid, end); // 合并
        }
    }

    private void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end - start + 1]; // 暂时存放有序数组
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                k++;
                i++;
            }else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        while (i <= mid){
            temp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= end){
            temp[k] = arr[j];
            k++;
            j++;
        }
        for (int l = 0; l < temp.length; l++) {
            arr[l + start] = temp[l];
        }
    }

    /**
     * 自顶向下
     * @param arr
     */
    public void mergeSortFromDown(int[] arr){
        for (int i = 1; i < arr.length; i *= 2){
            for (int low = 0; low < arr.length - i; low += i*2) {
                merge(arr, low, low + i - 1, Math.min(low + i * 2 - 1, arr.length - 1));
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        new MergeSort().mergeSortFromDown(nums);
//        new MergeSort().mergeSort(nums);
        for(int a : nums)
            System.out.println(a);
    }
}
