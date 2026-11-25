class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        for(int stone: stones){
            maxHeap.offer(stone);
        }

        while(!maxHeap.isEmpty()){
            int x = maxHeap.poll();
            Integer y = maxHeap.poll();
            if(y == null){
                return x;
            }

            int abs = Math.abs(x - y);

            if(abs != 0){
                maxHeap.offer(abs);
            }


        }

        return 0;


        
    }
}
