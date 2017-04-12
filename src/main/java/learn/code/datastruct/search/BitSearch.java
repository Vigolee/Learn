package learn.code.datastruct.search;

/**
 * 二分查找
 * Created by Vigo on 17/3/30.
 */
public class BitSearch {

    public int biSearch(int[] nums, int key){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == key){
                return mid + 1;
            }else if(nums[mid] > key){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归二分查找
     * @param nums
     * @param key
     * @return
     */
    public int BSearch(int[] nums, int key){
        return get(nums, key, 0, nums.length - 1);
    }

    private int get(int[] nums, int key, int left, int right){
        if(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == key)
                return mid + 1;
            if(nums[mid] > key)
                get(nums, key, left, mid - 1);
            if (nums[mid] < key)
                get(nums, key, mid + 1, right);
        }
        return -1;
    }
}
