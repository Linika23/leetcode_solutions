
import java.util.*;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        int currFuel = startFuel;
        int stops = 0;
        int i = 0;
        int n = stations.length;

        while (currFuel < target) {

            // Add fuel from every station we can currently reach
            while (i < n && stations[i][0] <= currFuel) {
                pq.offer(stations[i][1]);
                i++;
            }

            // No reachable station has fuel left to use
            if (pq.isEmpty()) {
                return -1;
            }

            // Refuel at the station offering the most fuel
            currFuel += pq.poll();
            stops++;
        }

        return stops;
    }
}
