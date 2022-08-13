class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> arr = new ArrayList<>();
        boolean added = false;
        for (int[] interval : intervals) {
            if (added) {
                arr.add(interval);
                continue;
            }
            if (interval[0] > newInterval[1]) {
                arr.add(newInterval);
                arr.add(interval);
                added = true;
            } else if (interval[1] < newInterval[0]) {
                arr.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            
        }
        
        if (!added) {
            arr.add(newInterval);
        }

        int[][] res = new int[arr.size()][];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }

        return res;
    }
}

