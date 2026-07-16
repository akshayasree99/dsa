class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        for (int i = 0, mx = 0; i < n; i++) nums[i] = gcd(nums[i], mx = Math.max(mx, nums[i])); 
        Arrays.sort(nums);
        return IntStream.range(0, n / 2).mapToLong(i -> gcd(nums[i], nums[n - 1 - i])).sum();  
    }
    private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
}