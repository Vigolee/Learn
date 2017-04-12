package learn.algorithm.dfs;

/**
 * Created by Vigo on 16/12/13.
 */
public class Bag_dfs {

    int[] w;
    int[] v;
    int n;
    public int getValue(int i, int j){
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
            best = getValue(i + 1 ,j);
        }else {
            /**
             * 物品不放入与放入两种选择
             */
            best = max(getValue(i + 1, j), getValue(i + 1, j - w[i]) + v[i]);
        }
        return best;
    }

    public int max(int a, int b){
        return a > b ? a : b;
    }

}
