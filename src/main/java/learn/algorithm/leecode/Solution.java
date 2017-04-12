package learn.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Vigo on 17/3/10.
 */
public class Solution {

    public String lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            //寻找以i为中心的奇数长度的回文
            int low = i - 1;
            int high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
                if (high - low + 1 > max){
                    max = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }
            //寻找以i为中心的偶数长度的回文
            low = i - 1;
            high = i;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
                if (high - low + 1 > max){
                    max = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }
        }
        System.out.println(start);
        System.out.println(max);
        System.out.println(s.length());
        return s.substring(start, max + start);
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList();
        String[] num = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] tmp = new char[digits.length()];
        dfs(digits, 0, tmp, list, num);
        return list;
    }

    public void dfs(String digits, int i, char[] tmp, ArrayList<String> list,String[] num){
        if(i == digits.length()){
            list.add(new String(tmp));
            return;
        }else{
            int s = Integer.valueOf(String.valueOf(digits.charAt(i)));
            for(int j = 0; j < num[s].length(); ++j){
                tmp[i] = num[s].charAt(j);
                dfs(digits,i + 1, tmp,list,num);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
        Stack<Character> stack = new Stack<Character>();

//        System.out.println(Integer.valueOf(Integer.valueOf(String.valueOf("23".charAt(0)))));
//        System.out.println(new Solution().lengthOfLongestSubstring("aaaa"));
    }
}