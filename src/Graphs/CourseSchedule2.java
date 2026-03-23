package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add( new ArrayList<>());
        }
        int[] dependency = new int[numCourses];

        for (int [] course: prerequisites){
            int toComplete = course[0];
            int first = course[1];

            dependency[toComplete]++;
            adj.get(first).add(toComplete);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if(dependency[i]== 0) queue.offer(i);
        }

        int count = 0;
        int [] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()){
            int curr = queue.poll();
            // course completed
            count ++;
            result[index++] = curr;

            // process its dependencies
            for (Integer next : adj.get(curr)){
                dependency[next]--; // dependency decreased
                if(dependency[next] == 0) queue.offer(next);
            }
        }
        return count < numCourses ? new int[] {} : result;
    }
}
