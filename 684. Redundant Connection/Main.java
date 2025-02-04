class Solution {
    int[] res = new int[2];
    int[] root;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        root = new int[n+1];
        rank = new int[n+1];
        for(int i = 0 ; i < n ; i++){
            root[i] = i ;
        }
        for(int[] edge : edges){
            int i = edge[0];
            int j = edge[1];
            join(i,j);
        }
        return res ;
    }

    private int find(int i){
        if(root[i] != i){
            root[i] = find(root[i]);
        }
        return root[i] ;
    }

    private void join(int i, int j){
        int root1 = find(i);
        int root2 = find(j);
        if(root1 != root2){
            if(rank[root1] > rank[root2]){
                root[root2] = root1;
            }
            else if(rank[root1] < rank[root2]){
                root[root1] = root2;
            }
            else{
                root[root2] = root1;
                rank[root1]++;
            }
        }
        else{
            res[0] = i;
            res[1] = j;
        }
    }
}
