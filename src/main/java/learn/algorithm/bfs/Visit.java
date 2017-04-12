package learn.algorithm.bfs;


public class Visit {
    public int countPath(int[][] map, int n, int m) {

        int start_x = 0;
        int start_y = 0;

        int end_x = 0;
        int end_y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1){
                    start_x = i;
                    start_y = j;
                    // break;
                }

                if(map[i][j] == 2) {
                    end_x = i;
                    end_y = j;
                }
            }
        }

        int direct_x = -1;
        int direct_y = -1;

        if (start_x < end_x){
            direct_x = 1;
        }

        if (start_y < end_y){
            direct_y = 1;
        }


        int[][] visit = new int[n][m];

        int count = dfs(map,n, m,start_x,start_y, direct_x, direct_y,visit);
        System.out.println(count);
        return count;
    }

    public int dfs(int[][]map, int n, int m, int x, int y,int direct_x, int direct_y, int[][] visit) {
        if (x < 0 || x >= n || y < 0 || y >= m){
            return 0;
        }
        if (map[x][y] == -1){
            return 0;
        }
        if (map[x][y] == 2){
            return 1;
        }
        if (visit[x][y] == 1){
            return 0;
        }
        visit[x][y] = 1;
        int count = dfs(map, n, m, x + direct_x, y, direct_x, direct_y,visit) +
                dfs(map, n, m, x, y + direct_y, direct_x, direct_y,visit);
        visit[x][y] = 0;
        return count;
    }


    public static void main(String[] args) {
        int[] A = {2,7,9,4,1};

    }
}