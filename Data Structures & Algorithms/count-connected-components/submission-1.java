class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        int counter = 0;

        for(int node = 0; node < n; node++){
            if(!visited[node]){
                dfs(graph, visited, node);
                counter++;
            }
        }
        return counter;
    }

    public void dfs(List<List<Integer>> graph, boolean[] visited, int node){
        visited[node] = true;

        for(int i : graph.get(node)){
            if(!visited[i]){
                dfs(graph, visited, i);
            }
        }
    }
}
