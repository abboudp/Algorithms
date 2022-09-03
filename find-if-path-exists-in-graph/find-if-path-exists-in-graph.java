class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        UnionFind graph = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            graph.union(edges[i][0], edges[i][1]);
            if (graph.validPath(source, destination)) {
                return true;
            }
        }
        return false;
    }
}

class UnionFind {
    int[] root = null;
    int[] rank = null;
    int components;
    
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
    
    public boolean validPath(int x, int y) {
        return find(x) == find(y);
    }
}