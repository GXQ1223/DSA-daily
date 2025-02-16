class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1]; // Result array
        boolean[] used = new boolean[n + 1]; // Track used numbers
        backtrack(result, used, 0, n); // Start backtracking
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int index, int n) {
        // If all positions are filled, return true
        if (index == result.length) 
            return true;

        // If the current position is already filled, move to the next position
        if (result[index] != 0) 
            return backtrack(result, used, index + 1, n);

        // Try placing numbers from n to 1
        for (int num = n; num >= 1; num--) {
            // Skip if the number is already used
            if (used[num]) 
                continue;

            // Handle number 1 separately (it only appears once)
            if (num == 1) {
                result[index] = 1;
                used[1] = true;
                if (backtrack(result, used, index + 1, n)) 
                    return true;
                used[1] = false;
                result[index] = 0;
            } else {
                // For numbers > 1, ensure the second occurrence is valid
                if (index + num < result.length && result[index + num] == 0) {
                    result[index] = num;
                    result[index + num] = num;
                    used[num] = true;
                    if (backtrack(result, used, index + 1, n)) 
                        return true;
                    used[num] = false;
                    result[index] = 0;
                    result[index + num] = 0;
                }
            }
        }

        // If no valid placement is found, backtrack
        return false;
    }
}