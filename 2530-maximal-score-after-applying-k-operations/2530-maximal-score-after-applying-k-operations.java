class Solution {
    public long maxKelements(int[] nums, int k) {

        //ceil=int(numsi/3)+1
        //max heap needed
        //pop eleement add to score
        // peek= ceil
        //max heap iterate till k
        //k--
        //return ans

        


        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        long score=0;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }

        while(k>0){
            int temp=pq.poll();
            score=score+temp;
            
            pq.add((int)Math.ceil((double)temp/3));
            k--;
        }

        
        
        return score;

        
    }
}