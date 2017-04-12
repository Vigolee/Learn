package learn.code.datastruct.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Vigo on 17/3/14.
 */
public class TwoTree {

    static class Node{
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }
    }

    /**
     * 构造二叉树
     * @param data
     * @param index
     * @return
     */
    public Node buildTree(String[] data, int index){
        if(data[index].equals("#")){
            return null;
        }
        Node node = new Node(data[index]);
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if(left < data.length){
            node.left = buildTree(data, left);
        }

        if(right < data.length){
            node.right = buildTree(data, right);
        }
        return node;
    }

    /**
     * 根据前、中序构造树
     * @param preorder
     * @param inorder
     * @return
     */
    public Node buildTree(String[] preorder, String[] inorder) {
        int pre_len = preorder.length;
        int in_len = inorder.length;
        return buildTree(preorder, 0, pre_len - 1, inorder, 0, in_len - 1);
    }

    private Node buildTree(String[] preorder, int pre_start, int pre_end, String[] inorder, int in_start,int in_end){
        if(pre_start > pre_end || in_start > in_end){
            return null;
        }
        String root_val = preorder[pre_start];
        int index = 0;
        for(int i = in_start; i<= in_end; ++i){
            if(inorder[i].equals(root_val)){
                index = i;
                break;
            }
        }
        int len = index - in_start;
        Node root = new Node(root_val);
        root.left = buildTree(preorder, pre_start + 1, pre_start + len, inorder, in_start, index - 1);
        root.right = buildTree(preorder, pre_start + len + 1, pre_end, inorder, index + 1, in_end);
        return root;
    }

    /**
     * 前序递归
     * @param root
     */
    public void pre(Node root) {
        if (root != null) {
            System.out.println(root.value);
            pre(root.left);
            pre(root.right);
        }
    }

    /**
     * 前序非递归
     * @param root
     */
    public void preStack(Node root){
        if (root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        while(root!=null||!stack.isEmpty()){
            while (root != null){
                System.out.println(root.value);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    /**
     * 中序非递归
     * @param root
     */
    public void mid(Node root){
        if (root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.value);
            root = root.right;
        }
    }

    /**
     * 后序非递归实现
     * @param root
     */
    public void thePostOrder(Node root){
        if (root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> output = new Stack<Node>();
        while (root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                output.push(root);
                root = root.right;
            }else {
                root = stack.pop();
                root = root.left;
            }
        }
        while (!output.isEmpty()){
            System.out.print(output.pop().value + " ");
        }
        System.out.println();
    }

    /**
     * 层次遍历
     * @param root
     */
    public void levelTravel(Node root){
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.value);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    /**
     * 二叉树高度(最大深度)
     * @param root
     * @return
     */
    public int treeHigh(Node root){
        if (root == null)
            return 0;
        int left = treeHigh(root.left);
        int right = treeHigh(root.right);
        return (left > right ? left : right) + 1;
    }

    /**
     * 二叉树最小深度
     * @param root
     * @return
     */
    public int minDeath(Node root){
        if(root == null)
            return 0;
        return getMin(root);
    }

    private int getMin(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null)
            return 1;
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }

    /**
     * 叶子数
     * @param root
     * @return
     */
    public int leafNum(Node root){
        if (root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return leafNum(root.left) + leafNum(root.right);
    }

    /**
     * 求二叉树中第k层节点的个数
     * @param root
     * @param k
     * @return
     */
    public int numsOfkLevelTreeNode(Node root,int k){
        if(root == null)
            return 0;
        if(k == 1)
            return 1;
        int left = numsOfkLevelTreeNode(root.left, k - 1);
        int right = numsOfkLevelTreeNode(root.right, k - 1);
        return left + right;
    }

    boolean isSameTreeNode(Node t1,Node t2){
        if(t1 == null && t2 == null)
            return true;
        if(!t1.value.equals(t2.value))
            return false;
        boolean left = isSameTreeNode(t1.left, t2.left);
        boolean right = isSameTreeNode(t1.right, t2.right);
        return left && right;
    }

    /**
     * 交换左右子树
     * @param root
     */
    public void exchangeTree(Node root) {
        if (root == null)
            return;
        if (root.left != null || root.right != null) {
            Node node = root.left;
            root.left = root.right;
            root.right = node;
            exchangeTree(root.left);
            exchangeTree(root.right);
        }
    }

    /**
     * 非递归实现交换左右子树
     * @param root
     */
    public void exchangeTreeStack(Node root){
        if (root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            Node tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }

    /**
     * 翻转二叉树or镜像二叉树
     * @param root
     * @return
     */
    public Node mirrorTreeNode(Node root){
        if(root == null)
            return null;
        Node left = mirrorTreeNode(root.left);
        Node right = mirrorTreeNode(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 求二叉树中两个节点的最低公共祖先节点
     * @param root
     * @param t1
     * @param t2
     * @return
     */
    public Node getLastCommonParent(Node root, Node t1,Node t2){
        if(findNode(root.left, t1)){
            if(findNode(root.right, t2)){
                return root;
            }else {
                return getLastCommonParent(root.left, t1, t2);
            }
        }else {
            if(findNode(root.left, t2)){
                return root;
            }else {
                return getLastCommonParent(root.right, t1, t2);
            }
        }
    }

    /**
     * 查找节点node是否在当前 二叉树中
     * @param root
     * @param node
     * @return
     */
    private boolean findNode(Node root, Node node){
        if(root == null)
            return false;
        if(root == node)
            return true;
        boolean flag = findNode(root.left, node);
         if(!flag){
             flag = findNode(root.right, node);
         }
        return flag;
    }


    public static void main(String[] args) {
        String[] data = {"1","2","3","4","5","#","6","#","#","7","8"};
        TwoTree tree = new TwoTree();
        Node root = tree.buildTree(data, 0);
        tree.thePostOrder(root);
        System.out.println(tree.getMin(root));


    }
}
