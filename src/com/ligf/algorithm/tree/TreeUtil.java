package com.ligf.algorithm.tree;

/**
 * @ClassName TreeUtil
 * @Description 树数据结构工具类
 * @Author Garment Lee
 * @Date 2021/2/24 23:37
 **/
public class TreeUtil {

    /**
     * 初始化一棵树结构
     * @return
     */
    public static TreeNode initTree(){
        TreeNode headNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(10);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(12);
        TreeNode treeNode6 = new TreeNode(9);
        headNode.setLeft(treeNode1);
        headNode.setRight(treeNode5);
        treeNode1.setLeft(treeNode2);
//        treeNode2.setLeft(treeNode3);
        treeNode2.setRight(treeNode4);
        treeNode5.setLeft(treeNode6);
        return headNode;
    }

    /**
     * 先序遍历树，输出树所有数据（递归实现）
     * @param root
     */
    public static void preOrderTraversal(TreeNode root){
        if (root != null){
            System.out.println(root.getValue());
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
    }

    /**
     * 中序遍历树，输出树的所有数据（递归实现）
     * @param root
     */
    public static void middleOrderTraversal(TreeNode root){
        if (root != null){
            middleOrderTraversal(root.getLeft());
            System.out.println(root.getValue());
            middleOrderTraversal(root.getRight());
        }
    }

    /**
     * 后序遍历树，输出树的所有数据（递归实现）
     * @param root
     */
    public static void postOrderTraversal(TreeNode root){
        if (root != null){
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            System.out.println(root.getValue());
        }
    }

    /**
     * 遍历树并得到树的深度
     * <p>思路：计算树的深度，使用前序遍历的方法(递归方式)。
     *          1）递归函数传递参数；
     *          2）递归函数不需要返回值；
     *          2）跳出递归的条件：判断结点是否为null。
     * @param root
     * @return
     */
    public static int result; //保存数的最大深度
    public static void maxDepth(TreeNode root, int depth){
        if (root != null){
            depth = depth + 1;
            result = Math.max(result, depth);
            maxDepth(root.getLeft(), depth);
            maxDepth(root.getRight(), depth);
        }
    }

    /**
     * 遍历树结构，并得到树的高度
     * <p> 思路：计算树的高度，使用后序遍历（递归方式）。
     *          1）不传递递归函数参数；
     *          2）递归函数需要返回值，该值就是树的最大高度；
     *          3）跳出递归的条件：判断结点是否为null。
     * @param root
     * @return
     */
    public static int maxHeight(TreeNode root){
        int height = 0;
        if (root != null){
            int left = maxHeight(root.getLeft());
            int right = maxHeight(root.getRight());
            height = Math.max(left, right) + 1;
        }
        return height;
    }

}
