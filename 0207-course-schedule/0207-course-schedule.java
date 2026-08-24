class Solution {
    public boolean canFinish(int V, int[][] edges) {
        int id[]=new int[V];
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<V;i++) list.add(new ArrayList<>());
        for(int a[]:edges){
            list.get(a[0]).add(a[1]);
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++){
            for(int num:list.get(i)){
                id[num]++;
            }
        }
        for(int i=0;i<V;i++){
            if(id[i]==0) q.add(i);
        }
        List<Integer>l=new ArrayList<>();
        while(q.size()!=0){
            int num=q.poll();
            l.add(num);
            for(int node:list.get(num)){
                id[node]--;
                if(id[node]==0) q.add(node);
            }
        }
        return (l.size()==V);
    }
}