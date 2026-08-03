class Solution {
    public int twoCitySchedCost(int[][] c) {
        Arrays.sort(c,(a,b)->{
            return (a[0]-a[1]) - (b[0]-b[1]);
        });
        int sum=0;
        for(int i=0;i<c.length/2;i++) sum+=c[i][0]+c[(c.length/2)+i][1];
        return sum;
    }
}