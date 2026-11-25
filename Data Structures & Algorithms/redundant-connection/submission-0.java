class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= edges.length; i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int src = edge[0];
            int dest = edge[1];

            if(hasPath(list, src, dest)){
                return edge;
            }

            list.get(src).add(dest);
            list.get(dest).add(src);
        }

        return new int[0];
    }

    public boolean hasPath(List<List<Integer>> list, int src, int dest){
        boolean[] visited = new boolean[list.size()];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(src);
        visited[src] = true;

        while(!queue.isEmpty()){
            int source = queue.poll();

            if(source == dest){
                return true;
            }

            for(int neighbor: list.get(source)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            } 
        }

        return false;
    }
}
