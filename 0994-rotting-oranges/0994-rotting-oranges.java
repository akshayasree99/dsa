class Solution {
    public int orangesRotting(int[][] grid) {
        int ct=0,ans=0;
        int a[][]={{1,0},{0,1},{-1,0},{0,-1}};
        int n=grid.length;
        int m=grid[0].length;
        Queue<int []>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) q.add(new int[]{i,j});
                if(grid[i][j]==1) ct++;
            }
        }
        while(q.size()!=0){
            int s=q.size();
            for(int j=0;j<s;j++){
                int x[]=q.poll();
                for(int i=0;i<4;i++){
                    int nr=a[i][0]+x[0];
                    int nc=a[i][1]+x[1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        ct--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            if(q.size()>0) ans++;
        }
        return ct>0?-1:ans;
    }
}