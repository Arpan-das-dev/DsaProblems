package Bfs;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) return 0;

        Set<String> dict = new HashSet<>(wordList);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String item = queue.poll();

                if (item.equals(endWord)) return level;

                for (int j = 0; j < item.length(); j++) {
                    char[] chars = item.toCharArray();
                    for (char k = 'a'; k <= 'z'; k++) {
                        chars[j] = k;
                        String word = new String(chars);

                        if (dict.contains(word) && !visited.contains(word)) {
                            queue.offer(word);
                            visited.add(word);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
