import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 * 所有可能的路径
 */
public class AllPathsSourceTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int length = graph.length - 1;
        List<Integer> paths = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            paths.add(node);
            if (node == length) {
                res.add(paths);
                paths = new ArrayList<>();
            }
            for (int val : graph[node]) {
                queue.add(val);
            }

        }
        return res;

    }

    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        dfs(graph, ans, res, 0);
        return res;

    }

    public void dfs(int[][] graph, List<Integer> ans, List<List<Integer>> res, int node) {
        if (node == graph.length - 1) {
            res.add(new ArrayList(ans));
            return;
        }
        for (int i : graph[node]) {
            ans.add(i);
            dfs(graph, ans, res, i);
            ans.remove(ans.size() - 1);
        }

    }
}
