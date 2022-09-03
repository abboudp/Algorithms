class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind graph = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            if (!graph.union(edges[i][0], edges[i][1])) {
                return false;
            }
        }
        if (graph.components > 1) {
            return false;
        }
        return true;
    }
}

class UnionFind {
    int[] root = null;
    int[] rank = null;
    int components;
    
    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        components = size;
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
    
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        }
        
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
            components--;
        }
        
        return true;
    }
    
}