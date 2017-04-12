package learn.code.datastruct.sort;

/**
 * 堆排序，平均时间复杂度O(nlogn)，最好最坏均为O(nlogn),不稳定
 * Created by Vigo on 17/4/10.
 */
public class HeapSort {
    public void heapSort(int[] data){
        for (int i = 0; i < data.length - 1; i++) {
            // 堆调整
            headAdjust(data, data.length - 1 - i);
            // 交换堆顶和最后一个元素
            int max = data[0];
            data[0] = data[data.length - 1 - i];
            data[data.length - 1 - i] = max;
        }
    }

    /**
     * 调整堆
     * @param data
     * @param lastIndex
     */
    private void headAdjust(int[] data, int lastIndex){
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0 ; i--) {
            int key = i;
            //如果当前k节点的子节点存在
            while (key * 2 + 1 <= lastIndex){
                int left = key * 2 + 1;
                if(left < lastIndex){ // 左节点和右节点均存在
                    if(data[left] < data[left + 1])
                        left++;
                }
                if(data[key] < data[left]){
                    // 交换
                    int tmp = data[key];
                    data[key] = data[left];
                    data[left] = tmp;

                    // 继续向下搜索,重新保证k节点的值大于其左右子节点的值
                    key = left;
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {1,3,2,5,4,9,8,0};
        new HeapSort().heapSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
