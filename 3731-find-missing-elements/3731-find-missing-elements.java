class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer>list=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        int a=nums[0];
        int b=nums[n-1];
        HashSet<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        for(int i=a;i<=b;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}