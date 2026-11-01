class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        HashSet<Integer> set = new HashSet<>();
        int ans;
        

        for(int i=0;i<n;i++){
            set.add(candyType[i]);
        }

        int availableCandy= set.size();

        if(availableCandy < n/2){
           ans=availableCandy;
        }
        else{
            ans= n/2;
        }
        

        return ans;
        
    }
}