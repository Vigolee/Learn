package learn.code.datastruct.sort;

/**
 * 快排，最坏时间复杂度O(n2)，平均时间复杂度O(nlogn)，不稳定
 * Created by Vigo on 17/3/9.
 */
public class QucikSort {


    public void sort(int[] arr, int low, int high){

        if (low <= high){
            int p = part(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }

    }

    public int part(int[] arr, int low, int high){
        int key = arr[low];
        while (low < high){
            while (low < high && arr[high] >= key) // 注意：先高后低（原因：保证low最后指向一定小于key）
                high--;
            if(low < high){
                arr[low] = arr[high];
            }
            while (low < high && arr[low] <= key)
                low++;
            if (low < high){
                arr[high] = arr[low];
            }
        }
        arr[low] = key;
        return low;

    }


    public static void main(String[] args) {
        int[] a = {1,3,2,5,4,9,8,0};
        new QucikSort().sort(a, 0 ,a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
