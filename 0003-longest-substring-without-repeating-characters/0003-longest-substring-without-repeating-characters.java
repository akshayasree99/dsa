class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>set=new HashSet<>();
        int n=s.length();
        int max=0,i=0,j=0;
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
            }
            else{
                while(i<j){
                    set.remove(s.charAt(i));
                    if(s.charAt(i)==s.charAt(j)) {i++;break;}
                    i++;
                }
                set.add(s.charAt(j));
            }
            j++;
            max=Math.max(max,set.size());
        }
        return max;
    }
}