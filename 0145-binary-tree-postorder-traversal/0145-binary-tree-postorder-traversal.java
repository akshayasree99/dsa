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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        Stack<TreeNode>st=new Stack<>();
        if(root==null) return ans;
        st.push(root);
        while(st.size()!=0){
            TreeNode r=st.pop();
            ans.add(r.val);
            if(r.left!=null) {
                st.push(r.left);
            }
            if(r.right!=null){ 
                st.push(r.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}