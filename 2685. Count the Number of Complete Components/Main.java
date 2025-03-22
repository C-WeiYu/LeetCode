class Solution {
    int[] parent;
    int[] count;
    int[] size;
    public int countCompleteComponents(int n, int[][] edges) {
        count = new int[n];
        parent = new int[n];
        size = new int[n];
        int res = 0; 
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i]++;
        }
        for(int i = 0; i < edges.length; i++){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            join(v1, v2);
        }
        for(int k = 0; k < n; k++){
            int s = size[k];
            int target = s * (s - 1) / 2;
            if(k == parent[k] && count[k] == target){
                res++;
            }
        }
        return res; 
    }

    private int find(int v){
        if(parent[v] != v){
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    private void join(int v1, int v2){
        int root1 = find(v1);
        int root2 = find(v2);
        if(root1 != root2){
            parent[root2] = root1;
            size[root1] += size[root2];
            count[root1] += count[root2];
        }
        count[root1]++;
        
    }

}
