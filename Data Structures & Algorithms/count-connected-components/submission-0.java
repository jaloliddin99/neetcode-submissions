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
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            counter++;

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int edge = queue.poll();

                for (int newEdge : graph.get(edge)) {
                    if (!visited[newEdge]) {
                        visited[newEdge] = true;
                        queue.offer(newEdge);
                    }
                }
            }
        }

        return counter;
    }
}
