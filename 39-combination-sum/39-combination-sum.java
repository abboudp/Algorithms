class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void dfs(int i, int[] candidates, int target, int sum, List<Integer> combination, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(combination));
            return;
        }
        
        if (sum > target || i >= candidates.length) {
            return;
        }
        
        combination.add(candidates[i]);
        dfs(i, candidates, target, sum + candidates[i], combination, result);
        combination.remove(combination.size() - 1);
        dfs(i + 1, candidates, target, sum, combination, result);
        return;
    }
}