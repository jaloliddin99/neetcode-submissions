class Solution {
    List<Set<Integer>> graph = new ArrayList<>();

    public boolean validTree(int n, int[][] edges) {
        int[] remaining = new int[n];

        for(int course = 0; course < n; course++){
            graph.add(new HashSet<>());
        }

        for(int[] courses: edges){
            graph.get(courses[0]).add(courses[1]);
            graph.get(courses[1]).add(courses[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int visitedCount = 0;

        while(!queue.isEmpty()){
            int curr = queue.poll();

            visitedCount++;

            for(int next: graph.get(curr)){
                if (visited[next]) {
                    return false;
                }
                visited[next] = true;
                graph.get(next).remove(curr);
                queue.offer(next);
            }

        }

        return visitedCount == n;  
    }
}
