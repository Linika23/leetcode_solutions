class Solution {
    public int partitionString(String s) {
        int seen = 0;      // bitmask: bit i is set if letter 'a'+i is in the current substring
        int count = 1;     // at least one substring

        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');
            if ((seen & bit) != 0) {   // repeat found
                count++;               // start a new substring
                seen = 0;              // reset
            }
            seen |= bit;               // add the current char
        }
        return count;
    }
}