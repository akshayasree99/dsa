class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int f=Integer.MAX_VALUE;
        int s=Integer.MAX_VALUE;
        for(int num:nums){
            if(num<=f) f=num;
            else if(num<=s) s=num;
            else return true;
        }
        return false;
    }
}