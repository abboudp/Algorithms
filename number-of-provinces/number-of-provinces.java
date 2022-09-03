class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionFind cityConnections = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                     cityConnections.union(i, j);
                }
             }
        }
        
        int provinces = 0;
        for (int i = 0; i < cityConnections.root.length; i++) {
            if (i == cityConnections.root[i]) {
                provinces++;
            }
        }
        return provinces;
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