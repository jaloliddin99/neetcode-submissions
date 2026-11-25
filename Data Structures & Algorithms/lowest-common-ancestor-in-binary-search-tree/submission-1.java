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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Map<TreeNode, TreeNode> childToParent = new HashMap<>();
        childToParent.put(root, null);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!childToParent.containsKey(p) || !childToParent.containsKey(q)){

            TreeNode node = queue.poll();

            if(node.left != null){
                childToParent.put(node.left, node);
                queue.offer(node.left);
            }

            if(node.right != null){
                childToParent.put(node.right, node);
                queue.offer(node.right);
            }
        }


        Set<TreeNode> ancestors = new HashSet<>();

        while(p != null){
            ancestors.add(p);
            p = childToParent.get(p);
        }

        while(!ancestors.contains(q)){
            q = childToParent.get(q);
        }

        return q;

    }

    
}
