/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private static class NodeBounds {
        TreeNode node;
        long min;
        long max;

        NodeBounds(TreeNode node, long min, long max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<NodeBounds> queue = new ArrayDeque<>();
        queue.offer(new NodeBounds(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!queue.isEmpty()) {
            NodeBounds current = queue.poll();
            TreeNode node = current.node;
            long min = current.min;
            long max = current.max;

            if (node.val <= min || node.val >= max) {
                return false;
            }

            if (node.left != null) {
                queue.offer(new NodeBounds(node.left, min, node.val));
            }
            if (node.right != null) {
                queue.offer(new NodeBounds(node.right, node.val, max));
            }
        }

        return true;
    }
}
