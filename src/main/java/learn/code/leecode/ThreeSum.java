package learn.code.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [-1, 0, 1],[-1, -1, 2]
 * Created by Vigo on 17/3/27.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 1; ++i){
            if(i != 0 && nums[i] == nums[i - 1]) // 去重复
                continue;
            int a = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                if(a + nums[start] + nums[end] == 0){
                    ArrayList<Integer> res = new ArrayList<Integer>();
                    res.add(a);
                    res.add(nums[start]);
                    res.add(nums[end]);
                    list.add(res);
                    /**
                     * 去重
                     */
                    while(start < end && nums[start + 1] == nums[start])
                        start++;
                    while(start < end && nums[end - 1] == nums[end])
                        end--;
                    start++;
                    end--;
                }else if (a + nums[start] + nums[end] > 0) {
                    end--;
                }else{
                    start++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(new ThreeSum().threeSum(nums));
    }
}
