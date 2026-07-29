class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int i=0,j=0;
        int ct=0,max=0;
        while(i<n && j<n){
            if(nums[j]==1){
                
            }
            else{
                ct++;
                if(ct>k){
                    while(i<j && nums[i]!=0) i++;
                    i++;
                    ct--;
                }            
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}