class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max=Arrays.stream(nums).max().orElse(0);
        long div[]=new long[max+1];// div[in] stores how many nums are divisible by 'in'.
        for(int i:nums){
            for(int j=1;j*j<=i;j++){
                if(i%j==0){
                    div[j]++;
                    if(j!=i/j){
                        div[i/j]++;
                    }
                }
            }
        }
        long pairs[]=new long[max+1];
        for(int i=max;i>0;i--){
            pairs[i]=(div[i]*(div[i]-1))/2;//nC2
            // remove additional pair counts
            for(int j=2*i;j<=max;j+=i){
                pairs[i]-=pairs[j];
            }
        }
        long presum[]=new long[max+1];
        for(int i=1;i<=max;i++){
            presum[i]=presum[i-1]+pairs[i];
        }
        int n=queries.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            long que=queries[i]+1;
            ans[i]=lowerbound(que,presum);
        }
        return ans;
    }
    public static int lowerbound(long que,long pre[]){
        int l=0,r=pre.length-1;
        int ans=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(pre[m]>=que){
                r=m-1;
                ans=m;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
}