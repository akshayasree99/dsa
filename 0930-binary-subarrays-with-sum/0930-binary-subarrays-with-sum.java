class Solution {
    public int numSubarraysWithSum(int[] nums, int g) {
        return solve(nums,g)-solve(nums,g-1);
    }
    public int solve(int nums[], int g){
        if(g<0) return 0;
        int n=nums.length;
        int i=0,j=0,ct=0,sum=0;
        while(i<n && j<n){
            sum+=nums[j];
            while(sum>g){
                sum-=nums[i];
                i++;
            }
            ct+=j-i+1;
            j++;
        }
        return ct;
    }
}