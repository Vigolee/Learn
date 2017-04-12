package learn.code.string;

/**
 * 全排列
 * Created by Vigo on 17/3/31.
 */
public class Permutation {

    public static void Permutation(char[] buf, int start, int end){
        if(start == end){
            for (int i = 0; i <= end; i++) {
                System.out.print(buf[i]);
            }
            System.out.println();
        }else {
            for (int i = start; i <= end; i++) { // 例如：abc，固定a，重排列bc，固定b,重排列ac
                char tmp = buf[i];
                buf[i] = buf[start];
                buf[start] = tmp;
                Permutation(buf, start + 1, end);
                tmp = buf[i];
                buf[i] = buf[start];
                buf[start] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        char[] buf = {'a', 'b','c'};
        Permutation(buf, 0 , buf.length - 1);
    }

}
