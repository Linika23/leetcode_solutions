class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n =costs.length;

        PriorityQueue<Integer>pq1=new PriorityQueue<>();
        PriorityQueue<Integer>pq2=new PriorityQueue<>();

        long ans=0;
        int hired=0;

        int i=0;

        int j=n-1;

        while(hired < k){

            while(pq1.size()<candidates && i<=j){
                pq1.add(costs[i]);
                i++;
            }
             while(pq2.size()<candidates && j>=i){
                pq2.add(costs[j]);
                j--;
            }

            int min1=!pq1.isEmpty()? pq1.peek() : Integer.MAX_VALUE;
            int min2=!pq2.isEmpty()? pq2.peek() : Integer.MAX_VALUE;

            if(min1<min2){
                ans+=min1;
                pq1.poll();
            }
            else if(min1==min2){
                ans+=min1;
                pq1.poll();

            }else{
               ans+=min2;
               pq2.poll(); 
            }

            hired++;

        }

        return ans;
        
    }
}