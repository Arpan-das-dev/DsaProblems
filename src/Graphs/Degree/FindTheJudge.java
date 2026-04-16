package Graphs.Degree;

public class FindTheJudge {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n + 1];

        for (int[] t : trust) {
            indegree[t[0]]--;
            indegree[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1) return i;
        }
        return -1;
    }
}
