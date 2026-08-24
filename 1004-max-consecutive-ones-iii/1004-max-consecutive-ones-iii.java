class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int n=nums.length;
        int ct=0,ans=0;
        while(i<n && j<n){
            if(nums[j]==0){
                ct++;
                while(ct>k){
                    if(nums[i]==0) ct--;
                    i++;
                }
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}