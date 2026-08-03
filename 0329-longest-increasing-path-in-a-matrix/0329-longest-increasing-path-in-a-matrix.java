class Solution {
    int dir[][]={{0,1},{1,0},{-1,0},{0,-1}};
    int n,m;
    int dp[][];
    public int longestIncreasingPath(int[][] mat) {
        int max=1;
        n=mat.length;
        m=mat[0].length;
        dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max=Math.max(max,solve(mat,i,j));
            }
        }
        return max;
    }
    public int solve(int mat[][], int r, int c){
        if(dp[r][c]!=0) return dp[r][c];
        int ct=1;
        for(int i=0;i<4;i++){
            int nr=r+dir[i][0];
            int nc=c+dir[i][1];
            if(nr>=0 && nc>=0 && nr<n && nc<m && mat[r][c]<mat[nr][nc]){
                int x=1+solve(mat,nr,nc);
                ct=Math.max(ct,x);
            }
        }
        return dp[r][c]=ct;
    }
}