class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];



        for(int num: map.keySet()){
            int count = map.get(num);

            if(buckets[count] == null){
                buckets[count] = new ArrayList<>();
            }

            buckets[count].add(num);
        }

        int[] results = new int[k];
        int counter = 0;

        for(int i = buckets.length - 1; i >= 0; i--){

            if(buckets[i] != null){
                for(int num: buckets[i]){
                    results[counter++] = num;

                    if(counter == k){
                        return results;
                    }
                }
            }
        }

        return results;

        
    }
}
