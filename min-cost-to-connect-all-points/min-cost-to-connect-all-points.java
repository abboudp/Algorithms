/*
1. Compute all edge weights and add edge sorted by weight to PriorityQueue
2. For each edge
    1. Union find on the vertices
    2. If creates a cycle, skip
    3. Else add to edge weight total
3. Return edge weight total
*/

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[] union = new int[points.length];
        for (int i = 0; i < union.length; i++) {
            union[i] = -1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        int edgeTotal = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.add(new int[]{i, j, dist});
            }
        }
        int[] minWeight;
        boolean unioned;
        while (!pq.isEmpty()) {
            minWeight = pq.remove();
            unioned = union(minWeight[0], minWeight[1], union);
            if (unioned) {
                edgeTotal += minWeight[2];
            }
        }
        return edgeTotal;
    }
    
    public int find(int p, int[] union) {
        while (union[p] >= 0) {
            p = union[p];
        }
        return p;
    }
    
    public boolean union(int s1, int s2, int[] union) {
        int p1 = find(s1, union);
        int p2 = find(s2, union);
        if (p1 == p2) {
            return false;
        } else {
            union[p2] = p1;
            return true;
        }
    }
}