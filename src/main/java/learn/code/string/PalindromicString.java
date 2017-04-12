package learn.code.string;

/**
 * 回文子串
 * Created by Vigo on 17/3/17.
 */
public class PalindromicString {

    /**
     * 返回最长回文子串
     * @return
     */
    public String getLPSubString(String s){
        int start = 0;
        int max = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            // 寻找以i为中心的奇数长度的回文
            int low = i - 1;
            int high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
                    if((high - low + 1) > max){
                        max = high - low + 1;
                        start = low;
                    }
                    low--;
                    high++;
            }

            //寻找以i为中心的偶数长度的回文
            low = i - 1;
            high = i;// 区别
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
                if((high - low + 1) > max){
                    max = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }
        }

        System.out.println("max : " + max);
        return s.substring(start,start + max);
    }

    /**
     * 判断是否是回文串
     * @param s
     * @return
     */
    public boolean isPalindromicString(String s){
        boolean flag = true;
        int low = 0;
        int high = s.length() - 1;
        while (low < high){
            if(s.charAt(low) == s.charAt(high)){
                low++;
                high--;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 方法一：动态规划方法求最长回文子序列
     * @param s
     * @return
     */
    public int getLPS(String s){
        String r = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length() + 1][r.length() + 1];
        String[][] path = new String[s.length() + 1][r.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < r.length(); j++) {
                if(s.charAt(i) == r.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    path[i + 1][j + 1] = "xie";
                }else {
                    /**
                     * 特别注意
                     */
                    int tmp_up = i > 0 ? dp[i][j + 1] : 0;
                    int tmp_left = j > 0 ? dp[i + 1][j] : 0;
                    if(tmp_left > tmp_up){
                        dp[i + 1][j + 1] = tmp_left;
                        path[i + 1][j + 1] = "left";
                    }else {
                        dp[i + 1][j + 1] = tmp_up;
                        path[i + 1][j + 1] = "up";
                    }
                }
            }
        }
        return dp[s.length()][r.length()];
    }

    /**
     * 方法二：递归求解删除最少字符，使字符串变为回文串
     * @param s
     */
    public void getLPS_2(String s){
        int max = digui(s, 0, s.length() - 1);
        int delete_num = s.length() - max;
        System.out.println("最少删除: " + delete_num);
    }

    private int digui(String s, int i, int j){
        if(i == j){
            return 1;//只有一个元素，回文长度为：1
        }
        if (i > j)
            return 0;
        if(s.charAt(i) == s.charAt(j)){//首尾相同
            return digui(s, i + 1, j -1) + 2;
        }
        return Math.max(digui(s, i + 1, j), digui(s, i, j - 1));//首尾不相同
    }

    public static void main(String[] args) {
//        System.out.println(new PalindromicString().getLPSubString("abeaba"));
//        System.out.println(new PalindromicString().isPalindromicString("aaaa"));
//        System.out.println(new PalindromicString().getLPS("abcdfcba"));
        new PalindromicString().getLPS_2("xsukkusxf");

    }
}
