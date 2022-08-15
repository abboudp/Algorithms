/*
Understand:

points = [[1,3],[-2,2]], k = 1
[[-2,2]]

points = [[3,3],[5,-1],[-2,4]], k = 2
[[3,3],[-2,4]]

points = [[3,3],[-3,3]], k = 1
[[3,3]]

Match:

PriorityQueue since we need top K min distances to origin

Plan:
1. For each point, compute euclidean distance from origin
2. Insert point into priorityqueue based on distance computed 
3. Keep a max priorityqueue and evict when size > k
4. Put remaining elements into list and return

*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> distances = new PriorityQueue<>((a,b) -> Double.compare(Math.pow(b[0], 2) + Math.pow(b[1], 2), Math.pow(a[0], 2) + Math.pow(a[1], 2)));
        
        for (int[] point : points) {
            distances.add(point);
            if (distances.size() > k) {
                distances.poll();
            } 
        }
        
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = distances.poll();
        }
    
        return result;
    }
}