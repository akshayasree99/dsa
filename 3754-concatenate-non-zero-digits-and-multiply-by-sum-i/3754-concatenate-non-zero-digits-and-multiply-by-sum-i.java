class Solution {
    public long sumAndMultiply(int n) {
        long x=0;
        int s=0;
        long a=1;
        while(n>0){
            int r=n%10;
            if(r!=0){
                x=r*a+x; 
                s+=r;
                a*=10;
            }
            n=n/10;
        }
        return x*s;
    }
}