package Graphs;

import java.util.*;

public class AlienDictionary {
    public String findOrder(String[] words) {
        if(words == null || words.length == 0) return "";

        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();

        for (String word : words){
            for (char ch : word.toCharArray()){
                graph.putIfAbsent(ch,new ArrayList<>());
                indegree.putIfAbsent(ch,0);
            }
        }

        for (int i = 0; i < words.length -1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            // eliminate wrong values && prefix problem

            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);

                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);
                    break;
                }
            }
        }
            // built queue for topological sort
            Queue<Character> queue = new LinkedList<>();
            StringBuilder result = new StringBuilder();

            for(char ch : indegree.keySet()){
                if(indegree.get(ch) == 0) queue.offer(ch);
            }

            while (!queue.isEmpty()){
                char ch = queue.poll();
                result.append(ch);
                for (char next : graph.get(ch)) {
                    indegree.put(next,indegree.get(next)-1);
                    if(indegree.get(next) == 0) queue.offer(next);
                }
            }

            return result.length() != indegree.size() ? "" : result.toString();
        }
    }

