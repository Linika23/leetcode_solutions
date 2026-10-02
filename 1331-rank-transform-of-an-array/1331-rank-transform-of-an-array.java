class Solution {
    public int[] arrayRankTransform(int[] arr) {

        
        

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int i=0;i<arr.length;i++){
            pq.add(new int[]{arr[i],i});

            

        }

        int[] ans = new int[arr.length];

        int rank=0;
        int prev=Integer.MIN_VALUE;

        while(!pq.isEmpty()){

        

        int[] pair=pq.poll();
        int value=pair[0];
        int idx=pair[1];

        if(value!=prev){
            rank++;
            prev=value;
        }

        ans[idx]=rank;

        }

        return ans;

        
    }
}