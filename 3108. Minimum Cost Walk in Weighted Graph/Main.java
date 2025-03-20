class Solution {
    int[] parent;
    int[] minPathCost;
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        minPathCost = new int[n];
        int[] res = new int[query.length];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            minPathCost[i] = -1;
        }
        for(int[] edge : edges){
            int v1 = edge[0];
            int v2 = edge[1];
            int weight = edge[2];
            join(v1, v2, weight);
        }
        for(int i = 0; i < query.length; i++){
            int v1 = query[i][0];
            int v2 = query[i][1];
            if(v1 == v2){
                res[i] = 0;
            }
            else if(find(v1) != find(v2)){
                res[i] = -1;
            }
            else{
                res[i] = minPathCost[find(v1)];
            }
        }
        return res ; 
    }
    
    private int find(int v){
        if(parent[v] != v){
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    private void join(int v1, int v2, int weight){
        int v1Root = find(v1);
        int v2Root = find(v2);
        if(minPathCost[v1Root] == -1){
            minPathCost[v1Root] = weight;
        }
        else{
            minPathCost[v1Root] &= weight;
        }
        
        if(minPathCost[v2Root] == -1){
            minPathCost[v2Root] = weight;
        }
        else{
            minPathCost[v2Root] &= weight;
        }
        if (v1Root != v2Root) {
            parent[v1Root] = v2Root;
            minPathCost[v2Root] &= minPathCost[v1Root];
        }
    }

}
