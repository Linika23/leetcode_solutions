class Solution {
    public int minStoneSum(int[] piles, int k) {

        int total=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0;i<piles.length;i++){
            total=total+piles[i];
            pq.add(piles[i]);
        }

        

        for(int i =0;i<k;i++){
            int temp=pq.poll();
            int removed=temp/2;
            total=total-removed;
            pq.add(temp-removed);
        }
        return total;
        
    }
}