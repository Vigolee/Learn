package learn.code;
import java.util.Scanner;

public class Main {
    public void handle(int n, int[] x, int[] y){
        int[] res = new int[n];
        res[0] = 0;
        for(int i = 1; i < n; ++i){

            for(int j = 0; j <= i; ++j){
                res[i] += Math.abs(x[j] - x[i-1]) + Math.abs(y[j] - y[i-1]);
            }
        }
        for(int i = 0; i < n; ++i){
            System.out.print(res[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String xl = sc.nextLine();
        String yl = sc.nextLine();
        String[] ax = xl.split(" ");
        String[] ay = yl.split(" ");
        int[] x = new int[ax.length];
        int[] y = new int[ay.length];
        for(int i =0; i < ax.length; ++i){
            x[i] = Integer.valueOf(ax[i]);
            y[i] = Integer.valueOf(ay[i]);
        }
        Main m = new Main();
        m.handle(n, x, y);
    }
}