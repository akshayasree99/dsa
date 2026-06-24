class Solution {
    public int largestAltitude(int[] gain) {
       int a=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<gain.length;i++){
            a=a+gain[i];
            max=Math.max(a,max);
        }
        return max>0?max:0;
    }
}