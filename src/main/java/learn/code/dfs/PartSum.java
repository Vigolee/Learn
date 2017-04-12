package learn.code.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Vigo on 17/3/18.
 */
public class PartSum {

    /**
     * 给定整数a1，a2,...,an,判断是否可以从中选出若干数，使它们的和恰好为k
     * @param A
     * @param k
     * @return
     */
    public boolean findSum(int[] A, int k){
        return search(A, 0, 0, k);
    }

    private boolean search(int[] A, int i, int sum, int k){
        if (i == A.length)
            return sum == k;
        if(sum == k)
            return true;
        if(search(A, i + 1, sum + A[i], k))
            return true;
        if(search(A, i + 1, sum, k))
            return true;
        return false;
    }

    public List<List<Integer>> threeSum(int[] nums, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            /**
             * 去重
             */
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int a = nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high){
                int b = nums[low];
                int c = nums[high];
                if((a + b + c) == k){
                    ArrayList<Integer> n = new ArrayList<Integer>();
                    n.add(a);
                    n.add(b);
                    n.add(c);
                    list.add(n);
                    /**
                     * 去重
                     */
                    while (low < high && nums[low] == nums[low + 1])
                        low++;
                    while (high > low && nums[high] == nums[high - 1])
                        high--;
                    low++;
                    high--;
                }else if((a + b + c) < k){
                    low++;
                }else {
                    high--;
                }
            }

        }
        return list;
    }



    public static void main(String[] args) {
        int[] A = {1,9,4,7,6};
        int k = 3;
        System.out.println(new PartSum().findSum(A, k));

        int[] nums = {0, -1, 2, -3, 1, -1};
        System.out.println(new PartSum().threeSum(nums, 0));

    }
}
