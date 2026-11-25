class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;

        int[] arr1 = new int[l];
        int[] arr2 = new int[l];

        arr1[0] = 1;
        arr2[l - 1] = 1;
        int prod = 1;
        for(int i = 1; i < l; i++){
            prod *= nums[i-1];
            arr1[i] = prod;
        }
        prod = 1;
        for(int i = l - 2; i >= 0; i--){
            prod *= nums[i + 1];
            arr2[i] = prod;
        }

        for(int i = 0; i < l; i++){
            nums[i] = arr1[i]*arr2[i];
        }
        return nums;
        
    }
}  
