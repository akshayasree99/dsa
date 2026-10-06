class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>st=new Stack<>();
        int ans=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                st.push(c);
                ans++;
            }
            else {
                if(st.size()!=0){
                st.pop();
                ans--;
              }
              else
              {
                ans++;
              }
            }
        }
        return ans;
    }
}