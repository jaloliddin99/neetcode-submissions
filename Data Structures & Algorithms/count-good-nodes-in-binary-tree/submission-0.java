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
    public int goodNodes(TreeNode root) {

        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();

        queue.offer(new Pair<>(root, Integer.MIN_VALUE));
        int res = 0;


        while(!queue.isEmpty()){

            Pair<TreeNode, Integer> pair = queue.poll();

            TreeNode node = pair.getKey();
            int maxVal = pair.getValue();

            if(node.val >= maxVal){
                res++;
            }

            if(node.left != null){
                queue.offer(new Pair<>(node.left, Math.max(maxVal, node.val)));
            }

            if(node.right != null){
                queue.offer(new Pair<>(node.right, Math.max(maxVal, node.val)));
            }
        }
        return res;
    }
}
