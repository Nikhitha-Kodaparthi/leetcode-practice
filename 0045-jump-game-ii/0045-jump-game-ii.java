class Solution {
    public int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // No need to process the last index
        for (int i = 0; i < nums.length - 1; i++) {

            // Find the farthest position reachable
            farthest = Math.max(farthest, i + nums[i]);

            // Reached the boundary of the current jump
            if (i == currentEnd) {

                jumps++;

                // Next jump can reach up to farthest
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}