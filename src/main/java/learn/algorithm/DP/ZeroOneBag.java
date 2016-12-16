package learn.algorithm.DP;

/**
 * Created by Vigo on 16/12/15.
 */
public class ZeroOneBag {

    int MAX_VALUE;

    int[] weight;

    int[] value;

    int[][] dp;

    int[][] path;

    public ZeroOneBag(int MAX_VALUE, int[] weight, int[] value) {
        this.MAX_VALUE = MAX_VALUE;
        this.weight = weight;
        this.value = value;
        this.dp = new int[weight.length + 1][MAX_VALUE + 1];
        this.path = new int[weight.length + 1][MAX_VALUE + 1];
    }

    public void solve(){

        for (int i = 0; i < weight.length; i++) {
            for (int j = 1; j <= MAX_VALUE; j++) {
                if (weight[i] > j){
                    dp[i + 1][j] = dp[i][j];
                }else {
                    dp[i + 1][j] = max(dp[i][j], dp[i][j - weight[i]] + value[i]);
                    if (dp[i + 1][j] == dp[i][j - weight[i]] + value[i]){
                        path[i + 1][j] = 1;
                    }
                }
            }
        }
        printPath();

    }

    private int max(int a, int b){
        return a > b ? a : b;
    }

    /**
     * 输出放入包中物品和价值
     */
    private void printPath(){
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0){
            if (path[i][j] == 1){
                System.out.println(weight[i - 1] + "-->" +value[i - 1]);
                j = j - weight[i - 1];
            }
            i--;
        }

    }

    public static void main(String[] args) {
        int[] w = {2, 1, 3, 2};
        int[] v = {3, 2, 4, 2};
        ZeroOneBag zeroOneBag = new ZeroOneBag(5,w, v);
        zeroOneBag.solve();
    }
}
