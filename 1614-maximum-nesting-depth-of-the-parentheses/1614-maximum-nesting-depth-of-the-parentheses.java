class Solution {
    public int maxDepth(String s) {
        int ct=0;
        int max=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                ct++;
            }
            if(c==')'){
                ct--;
            }
            max=Math.max(max,ct);
        }
        return max;
    }
}