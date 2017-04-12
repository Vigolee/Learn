package learn.code.string;

/**
 * 最长公共子串
 * Created by Vigo on 17/3/16.
 */
public class LCSubString {
    public void getLCSubString(String a, String b){
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        int max = 0;
        int last_i = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if(a.charAt(i) == b.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if(dp[i + 1][j + 1] > max){
                        max = dp[i + 1][j + 1];
                        last_i = i;
                    }
                }
            }
        }
        int k = max;
        StringBuilder sb = new StringBuilder();
        while (k > 0){
            sb.append(String.valueOf(a.charAt(last_i)));
            last_i--;
            k--;
        }
        System.out.println("max : " + max);
        System.out.println(sb.reverse());

    }


    public static void main(String[] args) {
        new LCSubString().getLCSubString("abcgecade","dcgecadde");
    }
}
