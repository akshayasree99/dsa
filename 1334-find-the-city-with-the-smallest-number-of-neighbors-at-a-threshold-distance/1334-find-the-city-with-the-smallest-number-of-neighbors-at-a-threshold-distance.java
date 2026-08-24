class Solution {
    public int findTheCity(int n, int[][] edges, int dis) {
        int cost[][]=new int[n][n];
        for(int a[]:cost) Arrays.fill(a,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) cost[i][j]=0;
            }
        }
        for(int a[]:edges){
            cost[a[0]][a[1]]=a[2];
            cost[a[1]][a[0]]=a[2];
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(cost[i][k]!=Integer.MAX_VALUE && cost[k][j]!=Integer.MAX_VALUE){
                        cost[i][j]=Math.min(cost[i][j],cost[i][k]+cost[k][j]);
                    }
                }
            }
        }
        int ans=0;
        int c=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int ct=0;
            for(int j=0;j<n;j++){
                if(cost[i][j]<=dis){
                    ct++;
                }
            }
            if(ct<=c){
                c=ct;
                ans=i;
            }
        }
        return ans;
    }
}