class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (int k = 0; k < moves.length(); k++) {
            char c = moves.charAt(k);
            if (c == 'U') y++;
            else if (c == 'D') y--;
            else if (c == 'R') x++;
            else if (c == 'L') x--;
        }

        return x == 0 && y == 0;
    }
}