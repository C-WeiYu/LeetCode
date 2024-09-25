class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int pre = prerequisite[1];
            adjList.get(pre).add(course);
            inDegree[course]++;
        }
 
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0 ;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            for(int course:adjList.get(curr)){
                inDegree[course]--;
                if(inDegree[course] == 0){
                    queue.offer(course);
                }
            }
        }
        return count == numCourses;
    }
}
