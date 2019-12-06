import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class GraphValidTree {

    /**
     * https://leetcode-cn.com/problems/graph-valid-tree/
     * 261. 以图判树
     * 思路： bfs 或者dfs 遍历图，判断是否有节点访问过两次，即图是否有环
     * 深度优先搜索
     * 广度优先搜索
     * 并查集
     *
     * 图三种表示方法
     * 矩阵 浪费空间
     * 邻接表
     * 边的数组 edge
     *
     *
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) {
            return true;
        }
        int[][] graph = new int[n][n];
        boolean[] visited = new boolean[n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        Stack<Integer> stack = new Stack();
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            System.out.print(cur);
            visited[cur] = true;
            for (int i = 0; i < n; i++) {
                if (graph[cur][i] == 1) {
                    if (visited[i]) {
                        return false;
                    }
                    visited[i] = true;
                    graph[cur][i] = 0;
                    graph[i][cur] = 0;
                    stack.push(i);
                }
            }
        }

        // 单连通分量
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean bfs(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        boolean[] visited = new boolean[n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            System.out.print(cur);
            for (int i = 0; i < n; i++) {
                if (graph[cur][i] == 1) {
                    if (visited[i]) {
                        return false;
                    }
                    visited[i] = true;
                    graph[cur][i] = 0;
                    graph[i][cur] = 0;
                    queue.add(i);
                }
            }


        }
        // 单连通分量
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        GraphValidTree graphValidTree = new GraphValidTree();
        System.out.println(graphValidTree.bfs(5, edges));
        System.out.print(graphValidTree.validTree(5, edges));
    }
}
