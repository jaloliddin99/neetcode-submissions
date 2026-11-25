class Solution {

    List<List<Integer>> graph = new ArrayList<>();
    
    public boolean validTree(int n, int[][] edges) {

        for(int course = 0; course < n; course++){
            graph.add(new ArrayList<>());
        }

        for(int[] courses: edges){
            graph.get(courses[0]).add(courses[1]);
            graph.get(courses[1]).add(courses[0]);
        }

        boolean[] visited = new boolean[n];

        if(hasCycleDfs(0, -1, graph, visited)){
            return false;
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycleDfs(int curr, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[curr] = true;

        for (int next : adj.get(curr)) {
            if (next == parent) {
                continue;
            }
            if (visited[next]) {
                return true;
            }
            if (hasCycleDfs(next, curr, adj, visited)) {
                return true;
            }
        }
        return false;
    }

}
