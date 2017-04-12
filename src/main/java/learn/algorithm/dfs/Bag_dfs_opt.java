package learn.algorithm.dfs;

/**
 * Created by Vigo on 16/12/13.
 */
public class Bag_dfs_opt {

    int[][] path;
    int n;
    int[] w;
    int[] v;
    public int solve(int i, int j){
        if (path[i][j] > 0){
           return path[i][j];
        }
        int best = 0;// 最佳收益
        /**
         * i == n时，收益为0
         */
        if (i == n){
            best = 0;
        }else if (w[i] > j){
            /**
             * w[i] > j 物品不能放入
             */
            best = solve(i + 1, j);
        }else {
            /**
             * 物品不放入与放入两种选择
             */
            best = max(solve(i + 1, j), solve(i + 1, j - w[i]) + v[i]);
        }
        return path[i][j] = best;
    }

    public int max(int a, int b){
        return a > b ? a : b;
    }
}
