class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n=profits.length;

        int[][] projects=new int[n][2];

        for(int i=0;i<n;i++){
            projects[i][0]=capital[i];
            projects[i][1]=profits[i];

        }

        Arrays.sort(projects,(a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        

        
        int i = 0;

        for (int count = 0; count < k; count++) {

            // Add all currently affordable projects
            while (i < n && projects[i][0] <= w) {
                pq.add(projects[i][1]);
                i++;
            }

            // No project is affordable
            if (pq.isEmpty()) {
                break;
            }

            // Select the most profitable affordable project
            w += pq.poll();
        }

        return w;



        
    }
}