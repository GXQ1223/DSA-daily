// Last updated: 4/3/2025, 4:30:48 PM
class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int n = s.length();
        // int[]res = new int[queries.length];
        int[][]res = new int[n][26];
        res[0][s.charAt(0) - 'a'] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 26; j++)res[i][j] = res[i-1][j];
            res[i][s.charAt(i) - 'a']++;
        }

        // for(int i = 0; i < res.length; i++){
        //     for(int j = 0; j < res[0].length; j++){
        //         System.out.print(";" + res[i][j]);
        //     }System.out.println();
        // }

        // for(int i = 0; i < queries.length; i++){
        //     int[]query = queries[i];
        //     int[]freq = new int[26];
        //     int a = 0;
        //     for(int j = query[0]; j <= query[1]; j++)
        //         freq[s.charAt(j) - 'a']++;
        //     // for(int k: freq){System.out.print("; " + k);} System.out.println();
        //     for(int l: freq){
        //         a += l + l * (l-1)/2;
        //     }
        //     res[i] = a;
        // }   
        int[]result = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int[]query = queries[i];
            int[]freq = new int[26];
            int sum = 0;
            if(query[0]>0 && query[1]>0){
                for(int j = 0; j < 26; j++)
                    freq[j] = res[query[1]][j] - res[query[0]-1][j];
            } else {
                for(int j = 0; j < 26; j++)
                    freq[j] = res[query[1]][j];
            }
            for(int j = 0; j < 26; j++){
                sum += freq[j];
                sum += freq[j] * (freq[j] - 1) / 2;
            }
            result[i] = sum;
        }

        return result;
    }
}