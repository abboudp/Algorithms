class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(new ArrayList<>());
                    res.get(res.size() - 1).add(nums[i]);
                    res.get(res.size() - 1).add(nums[j]);
                    res.get(res.size() - 1).add(nums[k]);
                    j++;
                    while (j < k && nums[j - 1] == nums[j]) {
                        j++;
                    }
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}