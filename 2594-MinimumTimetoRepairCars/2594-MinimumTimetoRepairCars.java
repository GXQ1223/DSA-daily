class Solution {
    public long repairCars(int[] ranks, int cars) {
        long res = 0;
        Arrays.sort(ranks);
        long l = 1, r = 1L * cars * cars * ranks[0];
        System.out.println("l: " + l + "; r: " + r);

        while(l <= r){
            long m = l + (r - l) / 2;
            if(work(m, ranks, cars))
                r = m-1; // last cnt that doesn't work
            else 
                l = m+1; // first cnt that works
        }
        return l;
    }

    public boolean work(long m, int[]ranks, int cars){
        long res = 0;
        for(int i: ranks){
            res += Math.sqrt(m / (long)i);
            if(res >= cars) return true;
        }
        return false;
    }
}