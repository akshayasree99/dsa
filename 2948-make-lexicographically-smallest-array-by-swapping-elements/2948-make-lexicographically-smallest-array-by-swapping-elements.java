import java.util.Arrays;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // Step 1: Pair each element with its original index
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        
        // Step 2: Sort pairs primarily by value
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        
        // Step 3: Identify connected components using a two-pointer approach
        int i = 0;
        while (i < n) {
            int j = i + 1;
            // Extend the group as long as adjacent elements differ by <= limit
            while (j < n && pairs[j][0] - pairs[j - 1][0] <= limit) {
                j++;
            }
            
            // Extract the original indices for the current group
            int groupSize = j - i;
            int[] indices = new int[groupSize];
            for (int k = 0; k < groupSize; k++) {
                indices[k] = pairs[i + k][1];
            }
            
            // Sort the original indices to map the smallest values to the earliest indices
            Arrays.sort(indices);
            
            // Place the sorted values back into the sorted original indices
            for (int k = 0; k < groupSize; k++) {
                result[indices[k]] = pairs[i + k][0];
            }
            
            // Move onto the next group
            i = j;
        }
        
        return result;
    }
}