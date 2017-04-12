package learn.code.string;

/**
 * 最长公共子序列
 * Created by Vigo on 17/3/16.
 */
public class LCS {

    public void getLCS(String a, String b){
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        String[][] path = new String[a.length() + 1][b.length() + 1];

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    path[i + 1][j + 1] = "xie";
                } else if (a.charAt(i) != b.charAt(j)) {
                    /**
                     * 特别注意
                     */
                    int tmp_up = i > 0 ? dp[i][j + 1] : 0;
                    int tmp_left = j > 0 ? dp[i + 1][j] : 0;
                    if (tmp_up > tmp_left) {
                        dp[i + 1][j + 1] = tmp_up;
                        path[i + 1][j + 1] = "up";
                    } else {
                        dp[i + 1][j + 1] = tmp_left;
                        path[i + 1][j + 1] = "left";
                    }
                }
            }
        }
        System.out.println("===== 打印最长子序列=======");
        System.out.println(print(a, path, a.length(), b.length()));
        System.out.println("count : " + dp[a.length()][b.length()]);
    }

    private String print(String a, String[][] path, int i, int j){
        if (i < 1 || j < 1){
            return "";
        }
        if(path[i][j].equals("xie")){
            i--;
            j--;
            return print(a, path, i, j) + a.charAt(i);
        }else if (path[i][j].equals("up")){
            i--;
            return print(a, path, i, j);
        }else if (path[i][j].equals("left")){
            j--;
            return print(a, path, i, j);
        }
        return "";
    }


    public static void main(String[] args) {
//        new LCS().getLCS("ABCBDAB","BDCABA");
        new LCS().getLCS("BACBCBABB", "BBABCBCAB");
    }

}
