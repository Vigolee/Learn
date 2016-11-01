package learn.algorithm.DP;

/**
 * 最长递增子序列：
 * 如在序列1,-1,2,-3,4,-5,6,-7中，最长递增序列为1,2,4,6。
 * LIS[i] = max{ 1, LIS[k]+1 }, 0 <= k < i, a[i]>a[k]
 * Created by Vigo on 16/10/16.
 */
public class LIS {

    public void getLIS(int[] A, int n){
        int[] count = new int[n];//表示数组前i个元素中（包括第i个），最长递增子序列的长度
        int[] index = new int[n];//记录子序列元素
        index[0] = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && (count[j] + 1) > count[i]){
                    count[i] = count[j] + 1;
                    index[i] = j;
                }
            }
        }

        int max = 0;
        int end_index = 0;
        for (int i = 0; i < n; i++) {
            if (max < count[i]){
                max = count[i];
                end_index = i;
            }
        }
        System.out.println(max);// 输出最长长度

        /**
         * 输出子序列元素
         */
        while (end_index >= 0){
            System.out.println(A[end_index]);
            end_index = index[end_index];
        }
    }

    public static void main(String[] args) {
        int[] A = {1,-1,2,-3,4,-5,6,-7};
        new LIS().getLIS(A, 8);
    }
}
