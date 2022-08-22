class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int node;
        Queue<List<Integer>> source = new LinkedList<>();
        path.add(0);
        source.add(path);
        while (!source.isEmpty()) {
            path = source.poll();
            node = path.get(path.size() - 1);
            for (int neighbor : graph[node]) {
                List<Integer> newPath = new ArrayList<>();
                newPath.addAll(path);
                newPath.add(neighbor);
                if (neighbor == graph.length - 1) {
                    allPaths.add(newPath);
                } else {
                    source.add(newPath);
                }
            }
        }
        return allPaths;
    }
}