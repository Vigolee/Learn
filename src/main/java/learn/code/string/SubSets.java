package learn.code.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求子集合
 * Created by Vigo on 17/3/17.
 */
public class SubSets {

    /**
     * 不包含重复元素的集合S，求其所有子集
     * @param nums
     * @return
     */
    public List<List<Integer>> getDistinctSubSets(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int len = res.size();
            for (int j = 0; j < len; j++) {
                List<Integer> tmp = new ArrayList<Integer>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }

    /**
     * 包含重复元素的集合S，求其所有子集
     * @param nums
     * @return
     */
    public List<List<Integer>> getSubSets(int[] nums){
        Arrays.sort(nums);// 排序
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        int front = 0; // 记录前一个数，新加入多少个子集
        for (int i = 0; i < nums.length; i++) {
            if(i - 1 >= 0 && nums[i - 1] == nums[i]){//如果当前数和前一个数相等, 则只对第一个数加入的子集添加当前数
                int len = res.size();
                int start = len - front;
                front = 0;
                for (int j = start; j < len; j++) {
                    List<Integer> tmp = new ArrayList<Integer>(res.get(j));
                    tmp.add(nums[i]);
                    res.add(tmp);
                    front++;
                }
            }else {
                int len = res.size();
                front = 0;
                for (int j = 0; j < len; j++) {
                    List<Integer> tmp = new ArrayList<Integer>(res.get(j));
                    tmp.add(nums[i]);
                    res.add(tmp);
                    front++;
                }
            }
        }
        return res;
    }




    public static void main(String[] args) {
        int[] x= {1,2,2};
        System.out.println(new SubSets().getSubSets(x));
    }
}
