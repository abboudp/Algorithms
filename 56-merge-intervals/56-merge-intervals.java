class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> arr = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        arr.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] lastInterval = arr.get(arr.size() - 1);
            
            if (lastInterval[1] < interval[0]) {
                arr.add(interval);
                continue;
            }
            
            if (lastInterval[1] >= interval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
                arr.remove(arr.size() - 1);
                arr.add(lastInterval);
            }
            
        }
        
        int[][] result = new int[arr.size()][];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
                    
        return result;
    }
}