
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        // Everyone gets at least one candy
        int total = n;

        int up = 0;
        int down = 0;
        int peak = 0;

        for (int i = 1; i < n; i++) {

            if (ratings[i] > ratings[i - 1]) {
                // Increasing slope
                up++;
                peak = up;
                down = 0;

                total += up;
            }

            else if (ratings[i] < ratings[i - 1]) {
                // Decreasing slope
                up = 0;
                down++;

                total += down;

                // Correct for the shared peak
                if (peak >= down) {
                    total--;
                }
            }

            else {
                // Equal ratings: a new slope begins
                up = 0;
                down = 0;
                peak = 0;
            }
        }

        return total;
    }
}
