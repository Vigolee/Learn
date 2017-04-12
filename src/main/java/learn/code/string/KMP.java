package learn.code.string;

/**
 * KMP算法
 * 时间复杂度O(m+n)
 * next数组可以优化
 * Created by lwg on 15/8/23.
 */
public class KMP {

    public void getNextArray(String str, int[] next) {

        next[0] = -1;

        int len = str.length();

        int k = -1;
        int j = 0;

        while (j < (len - 1)) {
            //str[k]表示前缀，str[j]表示后缀
            if (k == -1 || str.charAt(k) == str.charAt(j)) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
                for (int i = 0; i < next.length; ++i)
            System.out.print(next[i] + ",");
    }

    public int KMPSearch(String str, String p) {


        int plen = p.length();
        int slen = str.length();

        int[] next = new int[slen];
        getNextArray(str, next);

        int i = 0;
        int j = 0;
        while (i < plen && j < slen) {
            if (j == -1 || p.charAt(i) == str.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        System.out.print(i);
        if (j == slen)
            return i - j;
        else
            return -1;

    }

    public static void main(String[] args) {
        String str = "ABCDABD";
        String p = "BBC ABCDAB ABCDABCDABDEFGADFASDFASDF";
        int len = new KMP().KMPSearch(str, p);
        System.out.print(len);
//


    }
}
