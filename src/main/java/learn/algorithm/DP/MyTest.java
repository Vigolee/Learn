package learn.algorithm.DP;

/**
 * Created by Vigo on 17/8/31.
 */
public class MyTest {
    public static int myAtoi(String str) {
        if(str == null || str.equals(""))
            return 0;
        str = str.trim();
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        char[] c = str.toCharArray();
        boolean flag = false;
        int start = 0;
        if(c[0] == '-'){
            flag = true;
            start++;
        }
        if(c[0] == '+'){
            start++;
        }
        long num = 0l;
        for(int i = start; i < c.length; ++i){
            if(c[i] >= '0' && c[i] <= '9'){
                if (flag){
                    if(i == start){
                        num -= num + (c[i] - '0');
                    }else {
                        num = num * 10 - (c[i] - '0');
                    }
                    // 判断溢出
                    if(num > max || num < min){
                        num = num > 0 ? max : min;
                        break;
                    }
                }else {
                    if(i == start){
                        num += num + (c[i] - '0');
                    }else {
                        num = num * 10 + (c[i] - '0');
                    }
                    // 判断溢出
                    if(num > max || num < min){
                        num = num > 0 ? max : min;
                        break;
                    }
                }
            }else{
                break;
            }
        }
        return (int) num;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483648"));


    }
}
