package com.ligf.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName TreeNumThree
 * @Description 589.N-ary Tree Preorder Traversal
 * @Author Garment Lee
 * @Date 2021/3/3 23:50
 **/
public class TreeNumThree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    List<Integer> nodeList = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true){
            //添加第一个结点到返回链表中
            nodeList.add(root.val);

            //结点没有子结点
            if (root.children == null || root.children.size() == 0){
                //栈为空，已经没有可遍历的结点，直接返回
                if (stack.empty()){
                    break;
                }
                //从栈中取出一个结点对象
                root = stack.pop();
            } else {
                //有子结点，先把子结点入栈
                pushChildrenToStack(root, stack);
                root = root.children.get(0);
            }
        }

        return nodeList;
    }

    /**
     * 把除了第一个结点之外的其他子结点入栈，从链表尾部还是入栈
     * @param root
     * @param stack
     */
    private void pushChildrenToStack(Node root, Stack<Node> stack){
        if (root.children != null){
            int size = root.children.size();
            for (int i = size -1; i > 0; i--){
                stack.push(root.children.get(i));
            }
        }
    }

}
