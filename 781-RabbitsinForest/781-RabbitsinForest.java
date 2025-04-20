// Last updated: 4/19/2025, 9:52:18 PM
class Solution {
    public int numRabbits(int[] answers) {
        //if answer[i] == 1, 1 needs another 1 to match with it. so total 2 rabbits, each has 1 same color rabbit
        //if answer[i] == 2, 2 needs another two 2's to match with it. so total 3 rabbits, each has 2 same color rabbit
        int[]freq = new int[1000];
        for(int i = 0; i < answers.length; i++)
            freq[answers[i]]++;
        
        // for(int i: freq) System.out.println(i);
        int res = 0;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] == 0) continue;
            while(freq[i] > 0){
                res += (i+1);
                freq[i] -= (i+1);
            }
        }
        return res;
    }
}