package learn.algorithm.DP;

/**
 * 最大连续子数组
 * sum[i]为以第i个元素结尾且和最大的连续子数组
 * sum[i] = max(sum[i-1] + a[i], a[i])
 * Created by Vigo on 16/10/16.
 */
public class MaxSerialSubArray {

    public void getMaxSubArraySum(int[] A, int n){
        int[] sum = new int[n];
        sum[0] = A[0];
        int max = sum[0];
        for (int i = 1; i < n; i++) {
            if (sum[i - 1] + A[i] > A[i]){
                sum[i] = sum[i - 1] + A[i];
            }else {
                sum[i] = A[i];
            }

            if (sum[i] > max){
                max = sum[i];
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] A = {1, -2, 3, 10, -4, 7, 2, -5};
        new MaxSerialSubArray().getMaxSubArraySum(A, 8);
    }
}
