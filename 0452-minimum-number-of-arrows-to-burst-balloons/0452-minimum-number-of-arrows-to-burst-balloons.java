class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(x,y)->{
            return Integer.compare(x[1],y[1]);
        });
        int min=points[0][1];
        int ct=1;
        for(int i=1;i<points.length;i++){
            if(min<points[i][0]){
                min=points[i][1];
                ct++;
            }
        }
        return ct;
    }
}