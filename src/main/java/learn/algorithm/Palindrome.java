package learn.algorithm;

/**
 * 回文判断
 * Created by Vigo on 16/10/8.
 */
public class Palindrome {

    public void longestPalindrome(String str){
        str = markString(str);
        int max = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            int j = i - 1;
            int k = i + 1;
            while (j >= 0 && k < str.length() && str.charAt(j) == str.charAt(k)){
                if ((k - j + 1) > max){
                    max = k - j + 1;
                    start = j;
                }
                j--;
                k++;
            }
        }
        print(str, start, max);
    }

    public void print(String str, int start, int len){
        for (int i = start; i < start + len; i++) {
            if (str.charAt(i) != '#') {
                System.out.print(str.charAt(i));
            }
        }
    }

    public String markString(String str) {
        StringBuilder builder = new StringBuilder("#");
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
            builder.append("#");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        new Palindrome().longestPalindrome("abacba");
    }
}
