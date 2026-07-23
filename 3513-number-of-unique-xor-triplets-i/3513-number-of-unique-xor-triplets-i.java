/////////////////////////------------------------------------
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        int m=0;
        for(int num:nums){
            m|=num;
        }
        return m+1;
    }
}