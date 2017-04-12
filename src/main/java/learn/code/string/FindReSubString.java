package learn.code.string;

/**
 * 寻找一个字符串中最长的重复子串
 * （最长公共子串变种）
 * Created by Vigo on 17/3/16.
 */
public class FindReSubString {

    public int[][] getLCSubString(String a, String b){
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if(a.charAt(i) == b.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
            }
        }
        return dp;
    }

    public void find(String a){
        int[][] dp = getLCSubString(a, a);
        int max = 0;
        int end = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (i != j && dp[i][j] > max){
                        max = dp[i][j];
                        end = i - 1;
                }
            }
        }
        if (max != 0){
            System.out.println("max: " + max);
            StringBuilder sb = new StringBuilder();
            while (max > 0){
                sb.append(a.charAt(end));
                end--;
                max--;
            }
            System.out.println(sb.reverse());
        }else {
            System.out.println("there is no rs");
        }
    }

    public static void main(String[] args) {
       new FindReSubString().find("abcabec");
    }
}
