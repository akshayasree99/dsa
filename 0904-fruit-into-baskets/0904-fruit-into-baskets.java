class Solution {
    public int totalFruit(int[] f) {
        int max=0;
        int i=0,j=0,n=f.length;
        Map<Integer,Integer>map=new HashMap<>();
        while(i<n && j<n){
            map.put(f[j],j);
            if(map.size()>2) {
                int min=Integer.MAX_VALUE;
                for(int x:map.values()){
                    min=Math.min(min,x);
                }
                map.remove(f[min]);
                i=min+1;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}