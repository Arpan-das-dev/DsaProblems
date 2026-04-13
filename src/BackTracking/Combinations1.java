package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(1,n,k,result,new ArrayList<Integer>());
        return result;
    }

    private void backTrack(int integer, int n, int k, List<List<Integer>> result, ArrayList<Integer> integers) {
        if (integers.size() == k) {
            result.add(new ArrayList<>(integers));
            return;
        }

        for (int i = integer; i <= n - (k - integers.size()) + 1; i++) { // early pruning
            integers.add(i);
            backTrack(i + 1, n, k, result, integers);
            integers.removeLast();
        }
    }
}
