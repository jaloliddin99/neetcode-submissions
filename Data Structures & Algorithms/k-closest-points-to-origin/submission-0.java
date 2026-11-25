class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] closest = new int[k][2];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[2])
        );


        for(int[] point: points){
            minHeap.offer(new int[]{point[0], point[1], point[0] * point[0] + point[1] * point[1]});
        }


        for(int i =0; i < k; i++){
            int[] min = minHeap.poll();
            closest[i][0] = min[0];
            closest[i][1] = min[1];
        }

        return closest;

    }
}
