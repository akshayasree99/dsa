class Solution {
    public int maxScore(int[] a, int k) {
        int sum=0,l=0,r=0,max=0,n=a.length;
        for(int i=0;i<k;i++) l+=a[i];
        max=l;
        int i=k-1,j=n-1;
        while(i>=0){
            l-=a[i];
            r+=a[j];
            sum=l+r;
            max=Math.max(sum,max);
            i--;
            j--;
        }
        return max;
    }
}