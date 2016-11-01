package learn.algorithm;

/**
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
