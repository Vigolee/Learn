package learn.code.datastruct.tree;

/**
 * Created by Vigo on 17/3/27.
 */
public class AvlTree {
    static class Node{
        String value;
        Node left;
        Node right;
    }

    /**
     * 判断是否为平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(Node root){
        if (root == null)
            return true;
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        int diff = left - right;
        if (diff < - 1 || diff > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 数高度
     * @param root
     * @return
     */
    private int getHigh(Node root){
        if(root == null)
            return 0;
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        return left > right ? left + 1 : right + 1;
    }

    static class Depth{
        int depth;

        public Depth(int depth) {
            this.depth = depth;
        }
    }

    /**
     * 后序遍历判断
     * @param root
     * @return
     */
    public boolean isBalanced2(Node root){
        Depth d = new Depth(0);
        return getHigh2(root, d);
    }

    private boolean getHigh2(Node root, Depth d){
        if(root == null){
            d.depth = 0;
            return true;
        }
        Depth left = new Depth(0);
        Depth right = new Depth(0);
        if(getHigh2(root.left, d) && getHigh2(root.right, d)){
            int diff = left.depth - right.depth;
            if(diff <= 1 && diff >= -1){
                d.depth = 1+(left.depth > right.depth ?left.depth : right.depth);
                return true;
            }
        }
        return false;
    }
}
