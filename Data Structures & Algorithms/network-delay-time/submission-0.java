class Solution {

    public class Edge{
        int to, weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    record State(int node, int distance) {}

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: times){
            graph.get(edge[0]).add(new Edge(edge[1], edge[2]));
        }

        int[] distance = new int[n+1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[k] = 0;

        PriorityQueue<State> queue = new PriorityQueue(
            Comparator.comparingInt(State::distance)
        );

        queue.offer(new State(k, 0));

        while(!queue.isEmpty()){
            State s = queue.poll();
            int node = s.node;
            int currentDistance = s.distance;

            if(currentDistance > distance[node]){
                continue;
            }

            for(Edge edge: graph.get(node)){
                int newDistance = currentDistance + edge.weight;

                if(newDistance < distance[edge.to]){
                    distance[edge.to] = newDistance;
                    queue.offer(new State(edge.to, newDistance));

                }
            }
        }

        int maxValue = 0;

        for (int node = 1; node <= n; node++) {
            if (distance[node] == Integer.MAX_VALUE) {
                return -1;
            }

            maxValue = Math.max(maxValue, distance[node]);
        }

        return maxValue;




    }
}
