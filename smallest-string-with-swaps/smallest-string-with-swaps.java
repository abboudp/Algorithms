class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind graph = new UnionFind(s.length());
        for (List<Integer> pair : pairs) {
            graph.union(pair.get(0), pair.get(1));
        }
        
        for (List<Integer> pair : pairs) {
            graph.union(pair.get(0), pair.get(1));
        }
        
        Map<Integer, List<Character>> components = new HashMap<>();        
        for (int i = 0; i < graph.root.length; i++) {
            if (!components.containsKey(graph.root[i])) {
                components.put(graph.root[i], new ArrayList<>());
            }
            components.get(graph.root[i]).add(s.charAt(i));
        }
        
        for (Map.Entry<Integer, List<Character>> entry : components.entrySet()) {
            Collections.sort(entry.getValue(), (Character a, Character b) -> b - a);
        }
        
        char[] st = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            List<Character> component = components.get(graph.root[i]);
            st[i] = component.get(component.size() - 1);
            component.remove(component.size() - 1);
        }
        
        return new String(st);
    }
}

class UnionFind {
    int[] root = null;
    int[] rank = null;
    
    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }
    
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}