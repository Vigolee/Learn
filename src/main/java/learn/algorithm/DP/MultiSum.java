package learn.algorithm.DP;

/**
 * Created by Vigo on 16/12/18.
 */
public class MultiSum {

    int K;

    int[] num;

    int[] count;

    boolean[][] dp;

    int[][] path;

    public MultiSum(int K, int[] num, int[] count) {
        this.K = K;
        this.num = num;
        this.count = count;
        this.dp = new boolean[num.length + 1][K + 1];
        this.path = new int[num.length + 1][K + 1];
    }

    public void solve(){
        dp[0][0] = true;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j <= K; j++) {
                    for (int k = 0; k <= count[i] && k*num[i] <= j; k++) {
                            dp[i + 1][j] |= dp[i][j - k*num[i]];
                    }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        if (dp[num.length][K]){
            System.out.println("Yes");
        }
    }

    public static void main(String[] args) {
        int[] num = {3, 5, 8};
        int[] count = {3, 2, 2};
        int K = 17;
        new MultiSum(K, num, count).solve();
    }

}
