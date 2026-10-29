import java.util.Arrays;

class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);

        int count = 0;
        int currEnd = 0;
        int maxEnd = 0;
        int i = 0;
        int n = clips.length;

        while (currEnd < time) {

            while (i < n && clips[i][0] <= currEnd) {
                maxEnd = Math.max(maxEnd, clips[i][1]);
                i++;
            }

            if (maxEnd == currEnd) {
                return -1;
            }

            count++;
            currEnd = maxEnd;
        }

        return count;
    }
}