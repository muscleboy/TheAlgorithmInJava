package xyz.bugcoder.tree;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.tree
 * @Description: 二叉排序树(拥有不错的查找性能(二分查找)和良好的删除、插入性能)，中序遍历直接会得到从小到达排序
 * @Date: 2019-10-21 20:57
 * @Author: Wyj
 */
public class BinarySortTree {

    // 二叉排序树节点
    static class Node{

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        /**
        * @Description: 给二叉排序树添加节点
        * @Param: [node]
        * @return: void
        */
        public void add(Node node) {

            // 传入的值与根结点的值进行比较, 小的放在当前节点的左边，大的放在当前节点的放右边
            if (node.value < this.value){
                // 还需要判断当前节点的左二子是否为空
                if (this.left == null)
                    this.left = node;
                else {
                    this.left.add(node);
                }
            }else {
                if (this.right == null)
                    this.right = node;
                else {
                    this.right.add(node);
                }
            }
        }

        /** 
        * @Description: 中序遍历二叉查找树，直接得到一个升序的排列 
        * @Param: [node] 
        * @return: void
        */ 
        public void midShow(Node node){

            if (node == null)
                return;
            
            midShow(node.left);
            System.out.print(node.value + " ");
            midShow(node.right);
        }

        public Node search(int i) {

            if (this.value == i){

                return this;
            }
            // 要查找的值<当前值的时候，还需要判断当前节点的左二子是否为空
            else if (i < this.value){
                if (this.left == null)
                    return null;
                else
                    return this.left.search(i);
            }
            else {
                if (this.right == null)
                    return null;
                else
                    return this.right.search(i);
            }

        }

        @Override
        public String toString() {
            return this.value + " ";
        }
    }

    Node root;

    // 二叉排序树的添加
    public void add(Node node){

        if (root == null)
            root = node;
        else
            root.add(node);

    }

    // 中序遍历
    public void midShow(){

        if (root != null){
            root.midShow(root);
        }
    }

    // 二叉排序树的查找
    public Node search(int i){

        if (root == null)
            return null;
        else
            return root.search(i);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,4,23,65,54,7,8};
        BinarySortTree bst = new BinarySortTree();
        for (int i : arr) {
            bst.add(new Node(i));
        }
        bst.midShow();
        System.out.println();
        System.out.println(bst.search(11));

    }

}
