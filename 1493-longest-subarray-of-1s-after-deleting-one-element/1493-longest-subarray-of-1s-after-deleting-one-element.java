class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int count = 0;
        int max = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                count++;
            }
            while (count > 1) {
                if (nums[start] == 0) {
                    count--;
                }
                start++;
            }
            max = Math.max(max, end - start);
            end++;
        }
        return max;
    }
}