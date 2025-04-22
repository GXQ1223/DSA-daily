// Last updated: 4/22/2025, 12:15:42 AM
class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int maxx = 0, maxy = 0;
        int minx = m-1, miny = n-1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(image[i][j] == '1'){
                    maxx = Math.max(maxx,i);
                    maxy = Math.max(maxy,j);
                    minx = Math.min(minx,i);
                    miny = Math.min(miny,j);
                }
            }
        }
        System.out.println("maxx: " + maxx + "; maxy: " + maxy + "; minx: " + minx + "; miny: " + miny);
        return (maxx + 1 - minx) * (maxy + 1 - miny);

    }
}