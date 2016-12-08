package learn.algorithm.DP;

/**
 * 最长公共子序列（动态规划）
 * Created by Vigo on 16/9/30.
 */
public class LCS {

    public void getLCS(String a, String b){
        char[] m = a.toCharArray();
        char[] n = b.toCharArray();

        int[][] count = new int[m.length ][n.length];
        String[][] path = new String[m.length ][n.length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < n.length; j++) {
                if (m[i] == n[j]){
                    if(i == 0 || j == 0){
                        count[i][j] = 1;
                    }else {
                        count[i][j] = count[i - 1][j - 1] + 1;
                    }
                    path[i][j] = "diagonal";
                } else if (m[i] != n[j]) {
                    int tmp_i = i > 0 ? count[i - 1][j] : 0;
                    int tmp_j = j > 0 ? count[i][j - 1] : 0;
                    count[i][j] = tmp_i > tmp_j ? tmp_i : tmp_j;
                    if (count[i][j] == tmp_i){
                        path[i][j] = "up";
                    }else {
                        path[i][j] = "left";
                    }
                }
            }
        }
     //   printCount(count);
        printPath(path);
//        printSubString(m, path, m.length - 1, n.length - 1);
        printAllSubString(m, n, count, m.length - 1, n.length - 1, "");

    }

    /**
     * 打印最长子序列个数
     * @param count
     */
    void printCount(int[][] count){
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i].length; j++) {
                System.out.print(count[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 打印路径
     * @param path
     */
    void printPath(String[][] path){
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                System.out.print(path[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 输出一个最长子序列
     * @param m
     * @param path
     * @param i
     * @param j
     */
    void printSubString(char[] m,String[][] path, int i, int j){
        if (i < 0 || j < 0){
            return;
        }
        if (path[i][j].equals("diagonal")){
            System.out.print(m[i]);
            printSubString(m, path, i - 1, j - 1);
        }else if (path[i][j].equals("up")){
            printSubString(m, path, i - 1, j);
        }else if (path[i][j].equals("left")){
            printSubString(m, path, i, j - 1);
        }
    }

    void printAllSubString(char[] m, char[] n, int[][] count, int i, int j, String lcs){
        if (i < 0 || j < 0){
            //list.add(lcs);
            System.out.println(lcs);
            return;
        }
        if (m[i] == n[j]){
            lcs += m[i];
            printAllSubString(m, n, count, i - 1, j - 1, lcs);
        }else {
            if (count[i - 1][j] > count[i][j - 1]){
                printAllSubString(m, n, count, i - 1, j, lcs);
            }else if (count[i - 1][j] < count[i][j - 1]){
                printAllSubString(m, n, count, i, j - 1, lcs);
            }else {
                printAllSubString(m, n, count, i - 1, j, lcs);
                printAllSubString(m, n, count, i, j - 1, lcs);
            }
        }
    }

    public static void main(String[] args) {
        new LCS().getLCS("ABCBDAB","BDCABA");
    }
}
