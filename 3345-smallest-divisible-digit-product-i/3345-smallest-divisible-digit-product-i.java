class Solution {
    public int smallestNumber(int n, int t) {
        int temp=n;
        int b=pro(temp);
        
        while(b%t!=0)
            {
                n++;
               b=pro(n);
            }
        
        
        return n;
    }
    public int pro(int x)
    {
        int a=1;
        while(x>0)
            {
                a=a*(x%10);
                x=x/10;
            }
        return a;
    }
}