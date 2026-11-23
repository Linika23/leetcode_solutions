
import java.util.*;

class Solution {

    public int ladderLength(String beginWord,
                            String endWord,
                            List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        // End word must exist in dictionary
        if(!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        // Starting word is at level 1
        int steps = 1;

        while(!q.isEmpty()) {

            int size = q.size();

            // Process current BFS level
            for(int s = 0; s < size; s++) {

                String word = q.poll();

                if(word.equals(endWord)) {
                    return steps;
                }

                char[] arr = word.toCharArray();

                // Change each character
                for(int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for(char ch = 'a'; ch <= 'z'; ch++) {

                        arr[i] = ch;

                        String newWord = new String(arr);

                        if(set.contains(newWord)) {

                            q.add(newWord);

                            // Mark visited
                            set.remove(newWord);
                        }
                    }

                    // Restore original character
                    arr[i] = original;
                }
            }

            steps++;
        }

        return 0;
    }
}
