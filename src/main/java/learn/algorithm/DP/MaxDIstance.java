package learn.algorithm.DP;

/**
 * Created by Vigo on 17/3/30.
 */
public class MaxDIstance {

    public static void handle(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if((nums[i] - min) > max){
                max = nums[i] - min;
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] nums = {3,1,4,5,7,6};
       handle(nums);
    }
}
