package learn.algorithm.dfs;

/**
 * 部分和：给定整数a1，a2,...,an,判断是否可以从中选出若干数，使它们的和恰好为k
 * Created by Vigo on 16/10/13.
 */
public class PartSum {
int k = 10;
    public boolean getSum(int[] array, int i, int sum){
        if (i == array.length){
            System.out.println("i is len: " + i);
            return sum == k;
        }
        if (sum == k){
            System.out.println("i: " + i);
            return true;
        }
        if (getSum(array, i + 1, sum + array[i]))
            return true;
        if (getSum(array, i + 1, sum))
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1,9,4,7,6};
        System.out.println(new PartSum().getSum(array,0,0));
    }
}
