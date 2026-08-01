class Solution {
    public int eraseOverlapIntervals(int[][] in) {
       int n=in.length;
       Arrays.sort(in,(x,y)->{
            return Integer.compare(x[1],y[1]);
        });
        int min=in[0][1];
        int ct=1;
        for(int i=1;i<in.length;i++){
            if(min<=in[i][0]){
                min=in[i][1];
                ct++;
            }
        }
        return n-ct;
    }
}