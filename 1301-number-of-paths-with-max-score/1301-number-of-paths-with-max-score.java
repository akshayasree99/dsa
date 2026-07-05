class Solution {
    int mod = 1_000_000_007;
    int[][] dp1;
    int[][] dp2;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        char[][] grid = new char[n][n];
        for (int i=0;i<n;i++){
            grid[i] = board.get(i).toCharArray();
        }

        dp1 = new int[n][n];
        for (int[] d: dp1) Arrays.fill(d,-1);
        dp2 = new int[n][n];
        for (int[] d: dp2) Arrays.fill(d,-1);  

        int res1 = solve1(n-1,n-1,grid);
        if (res1<0) res1=0; 
        int res2 = solve2(n-1,n-1,0,grid);

        int[] res = new int[2];
        res[0] = res1;
        res[1] = res2;
        return res;


    }

    private int solve1(int i, int j, char[][] grid){
        int n = grid.length;
        if (i<0 || j<0) return Integer.MIN_VALUE;
        if (grid[i][j]=='X') return Integer.MIN_VALUE; 
        if (i==0 && j==0) return 0; 
        if (dp1[i][j]!=-1) return dp1[i][j];

        int res = 0;
        if (!(i==n-1 && j==n-1)) res+= grid[i][j]-'0';

        int up = solve1(i-1,j,grid);
        int left = solve1(i,j-1,grid);
        int dia = solve1(i-1,j-1,grid);
        int ans = res + Math.max(dia,Math.max(up,left));
        return dp1[i][j] = ans;
    }

    private int solve2(int i,int j,int score,char[][] grid){
        int n = grid.length;
        if (i==0 && j==0 ) { 
            return (score==dp1[n-1][n-1])?1:0;
        }
        if (i<0 || j<0 || grid[i][j]=='X') return 0;
        if (score<(dp1[n-1][n-1]-dp1[i][j])) return 0;
        if (dp2[i][j]!=-1) return dp2[i][j];


        int val = 0;
        if (!(i==n-1 && j==n-1)) val+=grid[i][j]-'0';
        int up  = solve2(i-1,j,score+val,grid);
        int left = solve2(i,j-1,score+val,grid);
        int dia = solve2(i-1,j-1,score+val,grid); 
        
        int tot = ((up+left+dia)-mod)%mod;
        if (tot<0) tot+=mod; 
        return dp2[i][j] = tot;

    }

}