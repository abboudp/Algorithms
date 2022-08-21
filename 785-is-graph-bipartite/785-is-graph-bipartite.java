class Solution {
    public boolean isBipartite(int[][] graph) {
            int len = graph.length;
            int[] color = new int[len];

            for(int i = 0; i < len; i++) {
                if(color[i] == 0) {
                    color[i] = 1;
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    while(!q.isEmpty()) {
                        int node = q.remove();

                        for(int neighbour: graph[node]) {
                            if(color[neighbour] == 0) {
                                color[neighbour] = -color[node];
                                q.add(neighbour);
                            } else if (color[neighbour] == color[node]) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
   
}