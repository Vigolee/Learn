package learn.algorithm.greedy;

/**
 * 哨兵问题
 * Created by Vigo on 16/12/12.
 */
public class SarumanArmy {

    public void solve(int[] a, int r){
        int n = a.length;
        int i = 0;
        int count = 0;
        while (i < n){
            int start = a[i];
            i++;
            while (i < n && a[i] <= start + r)
                i++;
            int p = a[i - 1]; // 标记
            while (i < n && a[i] <= p + r)
                i++;
            count++;
        }
        System.out.println(count);

    }

    public static void main(String[] args) {
        int[]  a = {1,7,15,20,30,50};
        int r = 10;
        new SarumanArmy().solve(a, r);
    }
}
