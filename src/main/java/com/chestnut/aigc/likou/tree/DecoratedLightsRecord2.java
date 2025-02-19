package com.chestnut.aigc.likou.tree;

import java.util.*;

public class DecoratedLightsRecord2 {


    public List<List<Integer>> decorateRecord(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode remove = queue.remove();
                temp.add(remove.val);
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode var18 = new TreeNode(18, null, null);
        TreeNode var17 = new TreeNode(17, var18, null);
        TreeNode var6 = new TreeNode(6, null, null);
        TreeNode var21 = new TreeNode(21, null, var6);
        TreeNode var8 = new TreeNode(8, var17, var21);
        DecoratedLightsRecord2 decoratedLightsRecord2 = new DecoratedLightsRecord2();
        List<List<Integer>> lists = decoratedLightsRecord2.decorateRecord(var8);
        System.out.println(lists);
    }
}
