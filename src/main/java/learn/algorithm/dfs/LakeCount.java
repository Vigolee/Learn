package learn.algorithm.dfs;

import java.util.Scanner;

/**
 * 有一个大小为N*M的园子，雨后积起了水。八连通的积水被认为是连接在一起的。请求出院子里共有多少水洼？
 *（八连通指的是下图相对W的*部分）
 * * * *
 * * W *
 * * * *
 * Created by Vigo on 16/12/6.
 */
public class LakeCount {
    private int n;
    private int m;

    public LakeCount(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public void dfs(char[][] ground, int dx, int dy){
        ground[dx][dy] = '.';

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = dx + i;
                int ny = dy + j;
                if (nx >=0 && nx < n && ny >=0 && ny < m && ground[nx][ny] == 'W')
                    dfs(ground, nx, ny);
            }
        }
    }


    public int solve(char[][] ground){
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ground[i][j] == 'W'){
                    dfs(ground, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String num = scanner.nextLine();
            String[] s = num.split(" ");
            int n = Integer.valueOf(s[0]);
            int m = Integer.valueOf(s[1]);
            char[][] ground = new char[n][m];
            for (int i = 0; i < ground.length; i++) {
                ground[i] = scanner.nextLine().toCharArray();
            }
            LakeCount lake = new LakeCount(n, m);
            int result = lake.solve(ground);
            System.out.println("result : " + result);
        }

    }
}

// 输入：
//        10 12
//        W........WW.
//        .WWW.....WWW
//        ....WW...WW.
//        .........WW.
//        .........W..
//        ..W......W..
//        .W.W.....WW.
//        W.W.W.....W.
//        .W.W......W.
//        ..W.......W.
// 输出：3
