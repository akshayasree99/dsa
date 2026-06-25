class Solution {
    public int[][] merge(int[][] a) {
        int r=a.length;
        int c=0;
        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));
       List<List<Integer>>list=new ArrayList<>();
       for(int i=0;i<r-1;)
       {
        int k=a[i][0];
        int m=a[i][1];
        while( m>=a[i+1][0])
         {
            i++;
            k=Math.min(k,a[i][0]);
            m=Math.max(m,a[i][1]);
            if(i>=r-1)
            {
                c=1;
                break;
            }
         }
        List<Integer>l=new ArrayList();
        l.add(k);
        l.add(m);
        list.add(l);
        if(c==0)
        {
            i++;
        }
       }
       if(c==0)
       {
          List<Integer>l=new ArrayList();
          l.add(a[r-1][0]);
          l.add(a[r-1][1]);
          list.add(l);
       }
       int ans[][]=new int[list.size()][2];
       for(int i=0;i<list.size();i++)
       {
           ans[i][0]=list.get(i).get(0);
           ans[i][1]=list.get(i).get(1);
       }

       return ans;
    }
}