class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length ;
        int[] inDegree = new int[n];

        // Calculate how many nodes point to "the node"(current employee)
        for(int i = 0 ; i < n ; i++){
            inDegree[favorite[i]]++ ;
        }

        // Toplological sorting to remove non-cycle nodes
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        // Depth of each node
        int[] depth = new int[n];
        Arrays.fill(depth,1);

        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            int nextNode = favorite[currentNode];
            depth[nextNode] = Math.max(depth[nextNode], depth[currentNode]+1);
            inDegree[nextNode] -= 1 ; 
            if(inDegree[nextNode] == 0 ){
                queue.offer(nextNode);;
            }
        }

        int longestCycle = 0 ;
        int twoCycleInvitations = 0 ;

        // Detect cycles;
        for(int i = 0 ; i < n ; i++){
            if(inDegree[i] == 0){
                continue ;
            }
            int cycleLength = 0 ;
            int current = i ;

            //  Cycle starts at where inDegree[Node] != 0
            while(inDegree[current] != 0){ 
                inDegree[current] = 0 ;
                cycleLength += 1 ;
                current = favorite[current];
            } 
            if(cycleLength ==2){
                twoCycleInvitations += depth[i] + depth[favorite[i]];
            }
            else{
                longestCycle = Math.max(longestCycle, cycleLength);
            }
        }
        return Math.max(longestCycle, twoCycleInvitations);
    }
}
