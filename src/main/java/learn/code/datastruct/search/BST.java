package learn.code.datastruct.search;

/**
 * 二叉排序树
 * Created by Vigo on 17/4/10.
 */
public class BST {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 查找BST中是否存在某节点
     * @param root
     * @param key
     * @return
     */
    public boolean searchBST(Node root, int key){
        if(root == null)
            return false;
        if(root.data == key){
            return true;
        }else if(root.data < key){
            return searchBST(root.left, key);
        }else {
            return searchBST(root.right, key);
        }
    }

    /**
     * 插入节点
     * @param root
     * @param key
     */
    public void insert(Node root, int key){
        if(root == null){
            root = new Node(key);
        }else {
            Node p = root;
            /**记录查找结点的前一个结点*/
            Node pre = null;
            while (p != null){
                pre = p;
                if(p.data < key){
                    p = p.left;
                }else if(p.data > key){
                    p = p.right;
                }else {
                    return;
                }
            }
            /** 找到插入位置*/
            if(key < pre.data)
                pre.left = new Node(key);
            if(key > pre.data)
                pre.right = new Node(key);
        }
    }

    public boolean deleteBST(Node root, int key){
        if(root == null)
            return false;
        if(root.data == key)
            return delete(root);
        if (root.data < key){
            return deleteBST(root.left, key);
        }else {
            return deleteBST(root.right, key);
        }
    }

    private boolean delete(Node node){
        if(node.left == null){
            node = node.right;
        } else if (node.right == null){
            node = node.left;
        } else {

            Node pre = node;
            /**转向左子树，然后向右走到“尽头”*/
            Node p = node.left;

            while (p.right != null){
                pre = p;
                p = p.right;
            }
            node.data = p.data;
            if (pre != node){// 注意此处
                pre.right = p.left;
            }else {
                pre.left = p.left;
            }
        }
        return true;

    }
}
