package learn.algorithm.DP;

/**
 * 最大子矩阵和
 * Created by Vigo on 16/10/16.
 */
public class MaxSubMatrix {

    public void getMaxSubMatrix(int[][] A, int m, int n){
        int[][] total = getTotal(A, m, n);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m ; j++) {
                //result 保存的是从 i 行 到第 j 行 所对应的矩阵上下值的和
                int[] result = new int[n];
                for (int k = 0; k < n; k++) {
                    if (i == 0){
                        result[k] = total[j][k];
                    }else {
                        result[k] = total[j][k] - total[i - 1][k];
                    }
                }
                int tmp = getMax(result, n);
                if (max < tmp ){
                    max = tmp;
                }
                }
            }
        System.out.println(max);
        }

    /**
     * 获取一维数组中，连续最大和
     * @param result
     * @param n
     * @return
     */
    public int getMax(int[] result, int n){
        int max = Integer.MIN_VALUE;
        int[] sum = new int[n];
        sum[0] = result[0];
        for (int i = 1; i < result.length; i++) {
            if (sum[i - 1] + result[i] < result[i]){
                sum[i] = result[i];
            }else {
                sum[i] = sum[i - 1] + result[i];
            }
            if (max < sum[i]){
                max = sum[i];
            }
        }
        return max;
    }

    /**
     * 构造i行和j行相加和
     * @param A
     * @param m
     * @param n
     * @return
     */
    public int[][] getTotal(int[][] A, int m, int n){
        int[][] total = new int[m][n];
        for (int k = 0; k < n; k++) {
            total[0][k] = A[0][k];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total[i][j] += total[i - 1][j] + A[i][j];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] A = {{0,-2,-7,0},{9,2,-6,2},{-4,1,-4,1},{-1,8,0,-2}};
        int m = 4;
        int n = 4;
        new MaxSubMatrix().getMaxSubMatrix(A, m, n);
    }
}
