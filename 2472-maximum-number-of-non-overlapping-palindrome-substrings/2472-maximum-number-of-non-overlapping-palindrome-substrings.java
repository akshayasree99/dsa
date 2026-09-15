////////////------------------------------------------------------------------
class Solution {
    int count  = 0;
    int leftLimit = 0;
    public int maxPalindromes(String s, int k) {

        for(int i = 0 ; i < s.length() ; i++){
            helper(s , i , i , k); // odd len
            helper(s , i , i+1 , k); // even len
        }
        return count;

    }
    public void helper(String s  , int left , int right , int k){
        while(leftLimit <= left && left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            int len = right-left+1;
            if(len >= k){
                count++;
                leftLimit = right + 1;
                break;
            }
            left--;
            right++;
        }
    }
}