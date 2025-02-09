import java.util.Arrays;

class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int n = groups.length;
        int[] res = new int[n];
        
        // Find the maximum value in groups
        int max = Arrays.stream(groups).max().orElse(0);
        
        // Cache for groups, initialized with -1
        int[] cache = new int[max + 1];
        Arrays.fill(cache, -1);
        
        // Precompute the smallest index in elements that divides each group value
        for (int e = 0; e < elements.length; e++) {
            int element = elements[e];
            // Start from the element and mark all multiples
            if (element <= max && cache[element] == -1) {
                for (int i = element; i <= max; i += element) {
                    if (cache[i] == -1) {
                        cache[i] = e;
                    }
                }
            }
        }
        
        // Map results directly from cache
        for (int i = 0; i < n; i++) 
                res[i] = cache[groups[i]];
        
        return res;
    }
}