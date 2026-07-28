class Solution {
    public int maxScore(int[] a, int k) {
        int sum=0,l=0,r=0,max=0,n=a.length;
        for(int i=0;i<k;i++) l+=a[i];
        max=l;sum=l;
        int i=k-1,j=n-1;
        while(i>=0){
            sum-=a[i--];
            sum+=a[j--];
            max=Math.max(sum,max);
        }
        return max;
    }
}