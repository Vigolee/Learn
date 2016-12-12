package learn.algorithm.greedy;

/**
 * 字典序最小问题
 * Created by Vigo on 16/12/12.
 */
public class BestCowLine {

    public void solve(String s, int N){

        int front_index = 0;
        int tail_index = N - 1;
        while (front_index <= tail_index){
            boolean left = false;// 判断从头还是尾取出字符
            for (int i = 0; front_index + i < tail_index; i++) {

                if (s.charAt(front_index + i) < s.charAt(tail_index - i)){
                    left = true;
                    break;
                }else if (s.charAt(front_index + i) > s.charAt(tail_index - i)){
                    left = false;
                    break;
                } else {
                    // 首尾相等继续循环判断下一个
                }
            }

            // 根据left判断取出的字符，并更新index
            if (left){
                System.out.print(s.charAt(front_index));
                front_index++;
            }else {
                System.out.print(s.charAt(tail_index));
                tail_index--;
            }
        }
    }

    public static void main(String[] args) {
        new BestCowLine().solve("ACDBCB", 6);
    }
}
