package learn.algorithm;

/**
 * Created by Vigo on 16/10/13.
 */
public class Bag {

    public void getMaxValue(int[] weight, int[] value, int m, int n) {
        int[][] c = new int[n][m + 1];
        int[][] path = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if (weight[i] > j){

                    if (i == 0){
                        c[i][j] = 0;
                    }else {
                        c[i][j] = c[i - 1][j];
                    }

                }else if (weight[i] <= j) {
                    if (i == 0){
                        c[i][j] = value[i];
                        path[i][j] = 1;
                    }else {
                        if (j - weight[i] >=0 && c[i - 1][j] < c[i - 1][j - weight[i]] + value[i]){
                            c[i][j] = c[i - 1][j - weight[i]] + value[i];
                            path[i][j] = 1;
                        }else {
                            c[i][j] = c[i - 1][j];
                        }
                    }
                }

            }
        }

//        for (int i = 0; i < c.length; i++) {
//            for (int j = 0; j < c[i].length; j++) {
//                System.out.print(c[i][j] + " ");
//            }
//            System.out.println();
//        }


//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j < path[i].length; j++) {
//                System.out.print(path[i][j] + " ");
//            }
//            System.out.println();
//        }

        printPath(path, weight);


    }

    public void printPath(int[][] path, int[] weight){
        int i = path.length - 1;
        int j = path[0].length - 1;

        while (i >= 0 && j >= 0){
            if (path[i][j] == 1){
                System.out.println("thing: " + weight[i]);
                j -= weight[i];
            }
            i--;
        }
    }

    public static void main(String[] args) {

        Bag bag = new Bag();
//        int[] weight = {2,2,6,5,4};
//        int[] value = {6,3,5,4,6};
//        int n = 5;
//        int m = 10;
        int[] weight = {3,4,5};
        int[] value = {4,5,6};
        int n = 3;
        int m = 10;
        bag.getMaxValue(weight, value, m, n);

    }
}