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
        treeNode2.setLeft(treeNode3);
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
     * @param root
     * @return
     */
//    public static int getTreeDepth(TreeNode root){
//
//    }

}
