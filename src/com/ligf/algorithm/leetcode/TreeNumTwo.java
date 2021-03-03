package com.ligf.algorithm.leetcode;

import com.ligf.algorithm.tree.TreeNode;

import java.util.ArrayList;

/**
 * @ClassName TreeNumTwo
 * @Description 04.03.List of Depth LCCI
 * @Author Garment Lee
 * @Date 2021/3/3 0:21
 **/
public class TreeNumTwo {


    /**
     * 内部类，链表结点
     */
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    ArrayList<ListNode> listNodes = new ArrayList<>();


    /**
     * 将树结构转化成链表数组
     * <p> 解题思路：通过结点的深度，判断同一深度的结点放到同一个链表中，对应深度的链表放到对应位置的数组中，为了与数组向对应，结点的深度从0开始算。
     *              由于要得到结点的深度，使用前序遍历树结构（递归的方式）。
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        preTraversal(tree, -1);
        ListNode[] listNodeArr = new ListNode[listNodes.size()];
        for (int i = 0; i < listNodes.size(); i ++){
            listNodeArr[i] = listNodes.get(i);
        }
        return listNodeArr;
    }

    private void preTraversal(TreeNode treeNode, int depth){
        if (treeNode != null){
            depth = depth + 1;
            ListNode listNode = new ListNode(treeNode.value);
            ListNode head = null;
            if (listNodes.size() > 0){
                 head = listNodes.get(depth);
            }
            if (head == null){
                head = listNode;
                listNodes.add(depth, head);
            } else {
                insertListNode(head, listNode);
            }
            preTraversal(treeNode.left, depth);
            preTraversal(treeNode.right, depth);
        }
    }

    /**
     * 把元素插入到链表尾部
     * @param listNode
     * @param insertNode
     */
    private void insertListNode(ListNode listNode, ListNode insertNode){
        while (listNode.next != null){
            listNode = listNode.next;
        }
        listNode.next = insertNode;
    }
}
