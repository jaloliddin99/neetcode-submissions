class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;

        int left = 0, right = heights.length - 1;

        while(left < right){
            int l = heights[left];
            int r = heights[right];

            int width = right - left;

            maxWater = Math.max(maxWater, Math.min(l, r) * width);

            if(l < r){
                left++;
            }else{
                right--;
            }
            
        }

        return maxWater;
    }
}
