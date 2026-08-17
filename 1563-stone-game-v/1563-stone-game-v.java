/////////////---------------
class Solution {
    public int[] pre;
    public int[][] dp;
    public int stoneGameV(int[] stoneValue) {
        pre = new int[stoneValue.length];
        pre[0] = stoneValue[0];
        for(int i = 1; i < pre.length; i++)
            pre[i] = pre[i - 1] + stoneValue[i];        
        dp = new int[stoneValue.length][stoneValue.length];
        return find(stoneValue, 0, stoneValue.length - 1);
    }
    
    public int find(int[] values, int si, int ei){
        if(si == ei)
            return 0;
        if(dp[si][ei] != 0)
            return dp[si][ei];        
        int max = Integer.MIN_VALUE;
        for(int i = si; i < ei; i++){
            int left = pre[i] - (si == 0 ? 0: pre[si - 1]);
            int right = pre[ei] - pre[i];
            if(left > right)
                max = Math.max(max, right + find(values, i + 1, ei));
            else if(left < right)
                max = Math.max(max, left + find(values, si, i));
            else
                max = Math.max(max, Math.max(left + find(values, si, i), right + find(values, i + 1, ei)));
        }
        return dp[si][ei] = max;
    }
}