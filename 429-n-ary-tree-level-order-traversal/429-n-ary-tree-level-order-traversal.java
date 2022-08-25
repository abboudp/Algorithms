/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> allLevels = new ArrayList<>();
        List<Integer> newLevel = new ArrayList<>();
        if (root == null) {
            return allLevels;
        }
        newLevel.add(root.val);
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            allLevels.add(newLevel);
            newLevel = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node node = q.poll();
                for (Node neighbor : node.children) {
                    if (neighbor != null) {
                        newLevel.add(neighbor.val);
                        q.offer(neighbor);
                    }
                }
            }
        }
        return allLevels;
    }
}