class Solution {
    public int longestSubsequence(int[] nums) {
        int x=0;
        int n=nums.length;
        int ct=0;
        for(int num:nums){
            x=x^num;
            if(num==0) ct++;
        }
        if(ct==n) return 0;
        if(x!=0) return n;
        return n-1;
    }
}