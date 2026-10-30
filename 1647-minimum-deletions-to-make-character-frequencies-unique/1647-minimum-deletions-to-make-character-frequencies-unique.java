class Solution {
    public int minDeletions(String s) {
        int n=s.length();
        int ans=0;
        if(n==1){
            ans=0;
        }
        HashMap<Character,Integer>map=new HashMap<>();
          for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Set<Integer> seen = new HashSet<>();
        for (int freq : map.values()) {
            while (freq > 0 && seen.contains(freq)) {
                freq--;
                ans++;
            }

            if (freq > 0) {
                seen.add(freq);
            }
        }
        return ans;


        
    }
}