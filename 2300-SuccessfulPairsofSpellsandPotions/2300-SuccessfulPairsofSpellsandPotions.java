class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] res = new int[n];
        int index = 0;
        for(int spell: spells){
            int left = 0, right = m;
            //finding the last potion so that spell * potion < success
            while(left < right){
                // System.out.println("left: " + left + "; right: " + right);
                int mid = left + (right - left) / 2;
                int potion = potions[mid];
                if((long)spell * (long)potion >= success){ // right pivot doesn't move when mid is valid
                    right = mid;
                } else {
                    left = mid + 1; //left will move if mid is invalid
                }
            }
            // System.out.println("left: " + left + "; right: " + right);
            res[index] = m - right;
            index++;
        }
        return res;
    }
}