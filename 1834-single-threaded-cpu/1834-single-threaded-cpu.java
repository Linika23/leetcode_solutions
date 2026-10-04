class Solution {
    public int[] getOrder(int[][] tasks) {


        int n =tasks.length;

        int[][] arr=new int[n][3];
        for(int i=0;i<arr.length;i++){
            arr[i][0]=tasks[i][0];
            arr[i][1]=tasks[i][1];
            arr[i][2]=i;
        }

        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->a[0] != b[0] ? Integer.compare(a[0], b[0]): Integer.compare(a[1], b[1]));

        int[] ans = new int[n];
        int idx = 0;        // next slot in ans
        int i = 0;          // next task to enqueue
        long currTime = 0;

        while (idx < n) {
            // CPU idle: jump to the next arrival
            if (pq.isEmpty() && currTime < arr[i][0]) {
                currTime = arr[i][0];
            }

            // add ALL tasks that have arrived by now
            while (i < n && arr[i][0] <= currTime) {
                pq.add(new int[]{arr[i][1], arr[i][2]});
                i++;
            }

            int[] cur = pq.poll();
            currTime += cur[0];
            ans[idx++] = cur[1];

        


        }

        return ans;

    }
}