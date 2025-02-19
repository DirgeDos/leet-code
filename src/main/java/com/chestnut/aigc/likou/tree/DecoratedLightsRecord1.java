package com.chestnut.aigc.likou.tree;

import java.util.*;

public class DecoratedLightsRecord1 {


    public int[] decorateRecord(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode remove = queue.remove();
            list.add(remove.val);
            if (remove.left != null) {
                queue.add(remove.left);
            }
            if (remove.right != null) {
                queue.add(remove.right);
            }

        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TreeNode var18 = new TreeNode(18, null, null);
        TreeNode var17 = new TreeNode(17, var18, null);
        TreeNode var6 = new TreeNode(6, null, null);
        TreeNode var21 = new TreeNode(21, null, var6);
        TreeNode var8 = new TreeNode(8, var17, var21);
        DecoratedLightsRecord1 decoratedLightsRecord1 = new DecoratedLightsRecord1();
        System.out.println(Arrays.toString(decoratedLightsRecord1.decorateRecord(var8)));

    }
}
