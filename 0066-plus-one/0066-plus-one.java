class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;

        int i = n - 1; // Start from last digit

        while (i >= 0) {

            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }

            // We got 9, so 9 + 1 = 10
            digits[i] = 0;
            i--;
        }

        // If all digits were 9, we need an extra digit
        int[] arr = new int[n + 1];
        arr[0] = 1;

        return arr;
    }
}