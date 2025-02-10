class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDays = days[days.length-1];
        int[]res = new int[maxDays + 1];
        int day = 0;

        for(int i = 1; i <= maxDays; i++){
            if(i == days[day]){
                day++;
                res[i] = Math.min(res[i-1] + costs[0],
                    Math.min(
                        (i - 7 > 0 ? res[i-7] + costs[1] : costs[1]), 
                        (i - 30 > 0 ?res[i-30] + costs[2] : costs[2]))
                );
            } else {
                res[i] = res[i-1];
            }
        }
        System.out.println("res: ");
        for(int i: res){System.out.print(";" + i);}
        return res[maxDays];
    }
}