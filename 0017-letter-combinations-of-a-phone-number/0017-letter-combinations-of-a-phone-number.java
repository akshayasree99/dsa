class Solution {
    public String a[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        solve(0,new StringBuilder(),digits);
        return ans;
    }
    public void solve(int i , StringBuilder sb , String d){
        if(i==d.length()){
            ans.add(sb.toString());
            return;
        }
        int idx=d.charAt(i)-'0';
        String s=a[idx];
        for(char c : s.toCharArray()){
            sb.append(c);
            solve(i+1,sb,d);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}