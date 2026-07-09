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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode>st=new Stack<>();
        HashSet<TreeNode>s=new HashSet<>();
        st.push(root);
        while(st.size()!=0){
            TreeNode r=st.peek();
            if(r.left!=null && !s.contains(r.left)){
                st.push(r.left);
                continue;
            }
            s.add(st.peek());
            ans.add(st.pop().val);
            if(r.right!=null && !s.contains(r.right)){
                st.push(r.right);
                continue;
            }
        }
        return ans;
    }
}