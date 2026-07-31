class Solution {
    public int eraseOverlapIntervals(int[][] in) {
        ArrayList<int []>list=new ArrayList<>();
        int n=in.length;
        int st[]=new int[n];
        int fi[]=new int[n];
        for(int i=0;i<n;i++){
            st[i]=in[i][0];
            fi[i]=in[i][1];
        } 
        for(int i=0;i<n;i++) list.add(new int[]{st[i],fi[i]});
        Collections.sort(list,(x,y)->{
            return Integer.compare(x[1],y[1]);
        });
        int ct=1;
        int a[]=list.get(0);
        int min=a[1];
        for(int i=1;i<list.size();i++){
            int x[]=list.get(i);
            if(min<=x[0]){
                min=x[1];
                ct++;
            }
        }
        return n-ct;
    }
}