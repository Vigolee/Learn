package learn.algorithm.greedy;

/**
 * 硬币问题
 * Created by Vigo on 16/12/12.
 */
public class Coin {

    /**
     * 硬币面值
     */
    static final int[] V = {1, 5,10, 50, 100, 500};

    /**
     *
     * @param C 硬币面值个数
     * @param A 支付
     */
    public static void solve(int[] C, int A){
        int sum = 0;// 中间结果
        for (int i = V.length - 1; i >= 0; i--) {
            int min = getMinCoin(A, V[i], C[i]);
            A -= min * V[i];
            sum += min;
        }
        System.out.println("min coin count : " + sum);
    }

    private static int getMinCoin(int value, int coin_value, int coin_count){
        int count = value/coin_value;
        return count < coin_count ? count : coin_count;
    }

    public static void main(String[] args) {
        int[] C = {3, 2, 1, 3, 0, 2};
        int A = 620;
        Coin.solve(C, A);
    }
}
