class Solution {
    public boolean canFinish(int tasks, int[][] prerequisites) {
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> ordering = new ArrayList<>();
        for (int i = 0; i < tasks; i++) {
          inDegree.put(i, 0);
          graph.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
          inDegree.put(prereq[1], inDegree.get(prereq[1]) + 1);
          graph.get(prereq[0]).add(prereq[1]);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
          if (entry.getValue() == 0) {
            sources.add(entry.getKey());
          }
        }

        while (!sources.isEmpty()) {
          int source = sources.remove();
          List<Integer> neighbors = graph.get(source);
          ordering.add(source);
          for (int neighbor : neighbors) {
            inDegree.put(neighbor, inDegree.get(neighbor) - 1);
            if (inDegree.get(neighbor) == 0) {
              sources.add(neighbor);
            }
          }
        }
        return ordering.size() == tasks;
    }
}