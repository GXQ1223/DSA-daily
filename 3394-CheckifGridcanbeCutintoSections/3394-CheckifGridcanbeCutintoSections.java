// Last updated: 3/24/2025, 9:12:00 PM
class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][]horizontal = new int[rectangles.length][2];
        for(int i=0;i<rectangles.length;i++){
            horizontal[i][0]=rectangles[i][0];
            horizontal[i][1]=rectangles[i][2];
        }
        Arrays.sort(horizontal,(a,b)->(a[0]-b[0]));
        List<Integer>cuts = new ArrayList<>();
        int cut=horizontal[0][1];
        for(int i=0;i<horizontal.length;i++){
            if(horizontal[i][0]>=cut){
                cuts.add(cut);
                if(cuts.size()>=2) return true;
            }
            cut = Math.max(cut,horizontal[i][1]);
        }
        
        int[][]vertical = new int[rectangles.length][2];
        for(int i=0;i<rectangles.length;i++){
            vertical[i][0]=rectangles[i][1];
            vertical[i][1]=rectangles[i][3];
        }
        Arrays.sort(vertical,(a,b)->(a[0]-b[0]));
        // Arrays.sort(horizontal,(a,b)->(a[1]-b[1]));
        cuts = new ArrayList<>();
        cut=vertical[0][1];
        for(int i=0;i<vertical.length;i++){
            if(vertical[i][0]>=cut){
                cuts.add(cut);
                if(cuts.size()>=2) return true;
            }
            cut = Math.max(cut,vertical[i][1]);
        }

        return false;
    }
}