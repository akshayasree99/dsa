class Solution {
    public int findCheapestPrice(int n, int[][] grid, int src, int dst, int k) {
        List<List<int []>>list=new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        for(int a[]:grid) list.get(a[0]).add(new int[]{a[1],a[2]});

        int dis[]=new int[n];
        for(int i=0;i<n;i++) Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;

        Queue<int []>q=new LinkedList<>();
        q.add(new int[]{src,0});
        while(q.size()!=0 && k-->=0){
            int s=q.size();
            for(int j=0;j<s;j++){
                int a[]=q.poll();
                int node=a[0],cost=a[1];
                for(int x[]:list.get(node)){
                    int v=x[0];
                    int p=x[1];
                    if(cost+p<dis[v]){
                        dis[v]=cost+p;
                        q.add(new int[]{v,dis[v]});
                    }
                }
            }
        }
        return dis[dst]==Integer.MAX_VALUE?-1:dis[dst];
    }
}