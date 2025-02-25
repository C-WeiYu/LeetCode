class Solution {
    private int n;
    private int[] distanceFromBob ;
    private List<List<Integer>> tree;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        n = amount.length;
        distanceFromBob = new int[n];
        
        tree = new ArrayList<>();
        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        return dfs(0, 0, 0, bob, amount);
    }

    private int dfs(int sourceNode, int parentNode, int time, int bob, int[] amount){
        int maxIncome = 0 ;
        int maxChild = Integer.MIN_VALUE;
        if(sourceNode == bob){
            distanceFromBob[sourceNode] = 0 ;
        }
        else{
            distanceFromBob[sourceNode] = n ;
        }
        
        for(int adjacentNode : tree.get(sourceNode)){
            if(adjacentNode != parentNode){
                maxChild = Math.max(maxChild, dfs(adjacentNode, sourceNode, time+1, bob, amount));
                distanceFromBob[sourceNode] = Math.min(distanceFromBob[sourceNode],distanceFromBob[adjacentNode]+1);
            }
            
        }
        if(distanceFromBob[sourceNode] > time){
            maxIncome += amount[sourceNode];
        }
        else if(distanceFromBob[sourceNode] == time){
            maxIncome += amount[sourceNode] / 2 ;
        }

        return (maxChild == Integer.MIN_VALUE) ? maxIncome : maxIncome + maxChild;
    }
}
