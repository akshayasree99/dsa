class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
    public int solve(int a[] , int k){
        int i=0,ct=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int j=0;j<a.length;j++){
            map.put(a[j],map.getOrDefault(a[j],0)+1);
            while(map.size()>k){
                map.put(a[i],map.get(a[i])-1);
                if(map.get(a[i])==0) map.remove(a[i]);
                i++;
            }
            ct+=j-i+1;
        }
        return ct;
    }
}