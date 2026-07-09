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

 /////// 2 stack
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        Stack<TreeNode>st1=new Stack<>();
        Stack<TreeNode>st2=new Stack<>();
        if(root==null) return ans;
        st1.push(root);
        while(st1.size()!=0){
            TreeNode r=st1.pop();
            st2.push(r);
            if(r.left!=null) {
                st1.push(r.left);
            }
            if(r.right!=null){ 
                st1.push(r.right);
            }
        }
        while(st2.size()!=0){ 
            ans.add(st2.pop().val);
        }
        return ans;
    }
}