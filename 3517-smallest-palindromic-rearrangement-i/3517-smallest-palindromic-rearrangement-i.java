class Solution {
    public String smallestPalindrome(String s) {
        Map<Character,Integer>map=new TreeMap<>();
        for(char c:s.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder e=new StringBuilder();
        StringBuilder e2=new StringBuilder();
        StringBuilder o=new StringBuilder();
         for (Map.Entry<Character, Integer> entry : map.entrySet()) 
         {
            int num = entry.getValue();
            if(num%2==0)
            {
                char ch=entry.getKey();
                e.append(String.valueOf(ch).repeat(num/2));
                e2.insert(0,String.valueOf(ch).repeat(num/2));
            }
            else
            {
                char ch=entry.getKey();
                e.append(String.valueOf(ch).repeat(num/2));
                e2.insert(0, String.valueOf(ch).repeat(num/2));
                if (o.length()==0) 
                {
                    o.append(ch);  
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        ans.append(e);
        ans.append(o);
        ans.append(e2);
        return ans.toString();
    }
}