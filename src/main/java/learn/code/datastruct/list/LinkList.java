package learn.code.datastruct.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Vigo on 17/3/27.
 */
public class LinkList {

    static class Node{
        int value;
        Node next;
    }

    /**
     * 反转链表
     * @param root
     */
    public void reverse(Node root){
        if (root == null)
            return;
        Node current = root;
        Node pre = null;
        Node next = null;
        while (current != null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        root = pre;// 设置头结点
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 1; ++i){
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
                    break;
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
//        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new LinkList().threeSum(nums));



    }

}
