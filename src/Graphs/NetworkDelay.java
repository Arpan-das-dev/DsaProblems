package Graphs;

import java.util.*;

public class NetworkDelay {
    public int NetworkDelayTime(int[][] times, int n, int k) {
        // create an adj graph
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int [] edge : times){
            graph.computeIfAbsent(edge[0],integer -> new ArrayList<>())
                    .add(new int[]{edge[1],edge[2]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[] {k,0});

        // create a visited node
        int [] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0; // to reach k node cost is 0;

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int node = curr[0];
            int distance = curr[1];

            // if we already find the min value then no proceed
            if(distance < dist[node]){
                continue;
            }

            // now process nodes
            if(graph.containsKey(node)){
                for (int[] neighbour : graph.get(node)){
                    int nextNode = neighbour[0];
                    int nextDistance = neighbour[1] + distance;

                    if(nextDistance < dist[nextNode]){
                        dist[nextNode] = nextDistance;
                        queue.offer(new int[]{nextNode,nextDistance});
                    }
                }
            }
        }
        int maxDistance = Arrays.stream(dist).skip(1).max().getAsInt();
        return maxDistance == Integer.MAX_VALUE ? -1 : maxDistance;
    }
}
