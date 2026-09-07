class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1; // Fixed: Use nums.length instead of undefined 'n'
       
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            // Base Case: If the target is found at mid
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check if the left half is sorted
            if (nums[start] <= nums[mid]) {
                // Check if the target lies within the sorted left half
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1; // Fixed: Removed 'int' re-declaration
                } else {
                    start = mid + 1;
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                // Check if the target lies within the sorted right half
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        
        return -1; // Fixed: Return -1 if the target is not found
    }
}

 