class Solution {
    public int earliestAcq(int[][] logs, int n) {
        UnionFind graph = new UnionFind(n);
        Arrays.sort(logs, (int[] a, int[] b) -> a[0] - b[0]);
        for (int i = 0; i < logs.length; i++) {
            graph.union(logs[i][1], logs[i][2]);
            if (graph.components == 1) {
                return logs[i][0];
            }
        }
        
        return -1;
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
            components--;
        }
    }
}