class Solution {
    public int maxScore(int[] a, int k) {
        int sum=0,r=0,n=a.length;
        for(int i=0;i<k;i++) sum+=a[i];
        int max=sum;
        int i=k-1,j=n-1;
        while(i>=0){
            sum-=a[i--];
            sum+=a[j--];
            max=Math.max(sum,max);
        }
        return max;
    }
}