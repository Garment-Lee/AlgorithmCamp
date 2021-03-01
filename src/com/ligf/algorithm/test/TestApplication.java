package com.ligf.algorithm.test;

import com.ligf.algorithm.tree.TreeNode;
import com.ligf.algorithm.tree.TreeUtil;

/**
 * @ClassName TestApplication
 * @Description 测试程序
 * @Author Garment Lee
 * @Date 2021/2/25 0:57
 **/
public class TestApplication {

    public static void main(String[] argS){
        TreeNode tree = TreeUtil.initTree();
        TreeUtil.preOrderTraversal(tree);
    }
}