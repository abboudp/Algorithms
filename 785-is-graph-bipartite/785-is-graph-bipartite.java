class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int node = q.remove();
                    for (int j = 0; j < graph[node].length; j++) {
                        if (color[graph[node][j]] == color[node]) {
                            return false;
                        }
                        if (color[graph[node][j]] == 0) {
                            color[graph[node][j]] = -color[node];
                            q.add(graph[node][j]);
                        }
                    }
                }
            }
        }
        return true;
    }
}