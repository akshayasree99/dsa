class Solution {
    public int maximumMinutes(int[][] grid) {
        int dir[][]={{1,0},{0,1},{0,-1},{-1,0}};
        int min=Integer.MAX_VALUE;
        int n=grid.length;
        int m=grid[0].length;
        int fire[][]=new int[n][m];
        for(int a[]:fire) Arrays.fill(a,Integer.MAX_VALUE);
        Queue<int []>fq=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    fq.add(new int[]{i,j});
                    fire[i][j]=0;
                }
            }
        }
        while(fq.size()!=0){
            int a[]=fq.poll();
            for(int i=0;i<4;i++){
                int nr=a[0]+dir[i][0];
                int nc=a[1]+dir[i][1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==0 && fire[nr][nc]==Integer.MAX_VALUE){
                    fire[nr][nc]=fire[a[0]][a[1]]+1;
                    fq.add(new int[]{nr,nc});
                }
            }
        }
        boolean pos=false;
        Queue<int []>q=new LinkedList<>();
        int hu[][]=new int[n][m];
        for(int a[]:hu) Arrays.fill(a,-1);
        int vis[][]=new int[n][m];
        vis[0][0]=1;
        hu[0][0]=0;
        q.add(new int[]{0,0,0});
        while(q.size()!=0){
            int a[]=q.poll();
            for(int i=0;i<4;i++){
                int nr=a[0]+dir[i][0];
                int nc=a[1]+dir[i][1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==0 && vis[nr][nc]==0){
                    if(nr==n-1 && nc==m-1){
                        if(a[2]+1<=fire[nr][nc]){
                            if(hu[nr][nc] == -1) hu[nr][nc]=hu[a[0]][a[1]]+1;
                            pos=true;
                        }
                    }
                    else{
                        if(a[2]+1<fire[nr][nc]){
                            vis[nr][nc]=1;
                            hu[nr][nc]=a[2]+1;
                            q.add(new int[]{nr,nc,a[2]+1});
                        }
                    }
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(hu[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("---------");
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(fire[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int t=fire[n-1][m-1]-hu[n-1][m-1];
        if(!pos || t<0) return -1;
        if(fire[n-1][m-1]==Integer.MAX_VALUE) return 1000000000;
        int gap1=(n>1 && hu[n-2][m-1]!=-1)?fire[n-2][m-1]-hu[n-2][m-1]:-1;
        int gap2=(m>1 && hu[n-1][m-2]!=-1)?fire[n-1][m-2]-hu[n-1][m-2]:-1;
        return (gap1>t ||gap2>t )?t:t-1;
    }
}
