/*
Understand:

nums1 = [1,7,11], nums2 = [2,4,6], k = 3
[[1,2],[1,4],[1,6]]

nums1 = [1,1,2], nums2 = [1,2,3], k = 2
[1,1],[1,1]]

nums1 = [1,2], nums2 = [3], k = 3
[[1,3],[2,3]]

Match:

PriorityQueue since we want top K min sums
Two-pointer

Plan:
1. Keep track of current index in arr1 and arr2
2. Find min of (arr1, arr2)
3. Try pairs composed of (min, other array vals)
4. While that sum < (min + 1, next second array index) continue
5. Else, find next min 
6. Continue until we have k elements in pq
7. Add to list and return

*/

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> sums = new PriorityQueue<>((a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums1.length && i < k; i++) {
            sums.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        while(k-- > 0 && !sums.isEmpty()) {
            int[] curr = sums.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(curr[0]);
            pair.add(curr[1]);
            result.add(pair);
            if (curr[2] < nums2.length - 1) {
                sums.offer(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
            }
        }
        
        return result;
    }
}