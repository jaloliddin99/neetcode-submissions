class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }
        int max = 0;

        for(int num: set){

            if(!set.contains(num-1)){
                int count = 0;
                int value = num;
                while(set.contains(value)){
                    count++;
                    value++;
                }
                max = Math.max(max, count);

            }
        }

        return max;

    }
}
