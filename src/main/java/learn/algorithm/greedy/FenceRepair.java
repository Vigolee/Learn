package learn.algorithm.greedy;

/**
 * 哈夫曼思想
 * Created by Vigo on 16/12/12.
 */
public class FenceRepair {

    public void solve(int a[], int n){
        int result = 0;
        while (n > 1){
            int min_fist = 0;
            int min_second = 1;
            if (a[min_fist] > a[min_second]){
                int tmp = min_fist;
                min_fist = min_second;
                min_second = tmp;
            }
            /**
             * 找到最小的两个点
             */
            for (int i = 2; i < n; i++) {
                if (a[min_fist] > a[i]){
                    min_second = min_fist;
                    min_fist = i;
                }else if (a[i] < a[min_second]){
                    min_second = i;
                }

            }
            int t = a[min_fist] + a[min_second];
            result += t;
            //由于先给min_first赋值，如果它正好是N-1单元的，min_second的会被重复
            if (min_fist == n - 1){
                int tmp = min_fist;
                min_fist = min_second;
                min_second = tmp;
            }
            a[min_fist] = t;
            a[min_second] = a[n - 1];
            n--;
        }
        System.out.println(result);
    }


    public static void main(String[] args) {
        int[]a ={8,5,8};
        new FenceRepair().solve(a,3);
    }
}
