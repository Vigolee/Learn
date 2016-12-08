package learn.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 迷宫最短路径（bfs）
 * 描述:给定一个大小为N X M的迷宫。迷宫由通道和墙壁组成，每一步可以向邻接的上下左右四格移动。
 * 求：从起点到终点所需要的最小步数。
 * Created by Vigo on 16/12/6.
 */
public class Maze {

    /**
     * 起点坐标
     */
    int start_x = 0;
    int start_y = 1;
    /**
     * 终点坐标
     */
    int end_x = 9;
    int end_y = 8;

    /**
     * 表示方向:上、下、左、右
     */
    int[] direct_x = {-1, 0, 0, 1};
    int[] direct_y = {0, 1, -1, 0};

    int n;
    int m;

    /**
     * 记录起点到每个位置的距离，不可达值为-1
     */
    int[][] distance;

    public Maze(int n, int m){
        this.n = n;
        this.m = m;
        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = -1;
            }
        }
    }

    public int bfs(char[][] maze){
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(start_x, start_y, maze[start_x][start_y]));
        distance[start_x][start_y] = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.x == this.end_x && node.y == this.end_y){
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + direct_x[i];
                int ny = node.y + direct_y[i];
                if (nx >=0 && nx < n && ny >=0 && ny < m &&
                        maze[nx][ny] != '#' && distance[nx][ny] == -1){
                    queue.offer(new Node(nx, ny, maze[nx][ny]));
                    System.out.println(nx + "->" + ny);
                    distance[nx][ny] = distance[node.x][node.y] + 1;
                }
            }
        }
        return distance[end_x][end_y];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String num = scanner.nextLine();
            String[] s = num.split(" ");
            int n = Integer.valueOf(s[0]);
            int m = Integer.valueOf(s[1]);
            char[][] maze = new char[n][m];
            for (int i = 0; i < maze.length; i++) {
                maze[i] = scanner.nextLine().toCharArray();
            }
            int result = new Maze(n, m).bfs(maze);
            System.out.println("result : " + result);
        }
    }


    /**
     * 每个位置看作一个节点
     */
    static class Node{
        int x;
        int y;
        char c;

        public Node(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
}
