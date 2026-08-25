class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int i=k;
        while(true){
            if(!set.contains(i)){
                return i;
            }
            i+=k;
        }
    }
}