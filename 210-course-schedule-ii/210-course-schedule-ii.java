class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> ordering = new ArrayList<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] prereq : prerequisites) {
            inDegree.put(prereq[0], inDegree.get(prereq[0]) + 1);
            graph.get(prereq[1]).add(prereq[0]);
        }
        
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.offer(entry.getKey());
            }
        }
        
        while (!sources.isEmpty()) {
            int source = sources.poll();
            ordering.add(source);
            List<Integer> neighbors = graph.get(source);
            for (int neighbor : neighbors) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    sources.add(neighbor);
                }
            }
        }
        
        if (ordering.size() != numCourses) {
            return new int[0];
        }
        
        int[] order = new int[ordering.size()];
        for (int i = 0; i < ordering.size(); i++) {
            order[i] = ordering.get(i);
        }
        
        return order;
    }
}