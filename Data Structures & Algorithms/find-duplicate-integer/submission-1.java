class Solution {

    // 5, 5, 3, 2, 1, 4
    public int findDuplicate(int[] nums) {
        for(int num: nums){
            int index = Math.abs(num) - 1;
            if(nums[index] < 0){
                return Math.abs(num);
            }
            nums[index] *= -1;
        }

        return -1;
    }
}
