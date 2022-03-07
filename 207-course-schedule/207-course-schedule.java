class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean vis[] = new boolean[numCourses];
        boolean dfsVis[] = new boolean[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(i,new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
           adj.get(prerequisites[i][1]).add(prerequisites[i][0]);   
        }
        for(int i=0;i<numCourses;i++){
            if(vis[i]==false)
                if(checkCycle(i,adj,vis,dfsVis))
                    return false;
        }
        return true;
    }
    
    private boolean checkCycle(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] dfsVis){
        vis[i]=true;
        dfsVis[i]=true;
        for(Integer it : adj.get(i)){
            if(vis[it]==false){
                if(checkCycle(it,adj,vis,dfsVis))
                    return true;
            }
            else if(dfsVis[it]==true)
                return true;
        }
        dfsVis[i]=false;
        return false;
    }
}