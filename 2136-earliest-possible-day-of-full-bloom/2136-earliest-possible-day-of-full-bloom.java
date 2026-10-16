class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {

        int n=plantTime.length;
        List<int[]>list=new ArrayList<>();
        for(int i =0;i<n;i++){
            list.add(new int[]{plantTime[i],growTime[i]});
        }
        list.sort((a,b)->Integer.compare(b[1],a[1]));
        int maxDays=0;

        int day=0;
        for(int i =0;i<n;i++){
            int[] pair = list.get(i);
            day += pair[0];

            int currSum = day + pair[1];
            maxDays = Math.max(maxDays, currSum);
            

           


        }

        return maxDays;

        
    }
}