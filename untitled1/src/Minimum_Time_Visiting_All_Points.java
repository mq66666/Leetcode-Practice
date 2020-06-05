public class Minimum_Time_Visiting_All_Points {
    class Solution {
        int[][] point;
        public int minTimeToVisitAllPoints(int[][] points) {
            this.point = points;
            int time = 0;
            for(int i = 1;i<=point.length-1;i++){
                time = time + calculatetime(i-1,i);
            }
            return time;
        }
        public int calculatetime(int p, int c){
            int time = 0;
            int pl = point[p][0];
            int pr = point[p][1];
            int cl = point[c][0];
            int cr = point[c][1];
            if(Math.abs(pl-cl)>=Math.abs(pr-cr)){
                time = time + Math.abs(pl-cl);
            }else if (Math.abs(pl-cl)<Math.abs(pr-cr)){
                time = time + Math.abs(pr-cr);
            }
            return time;
        }
    }

}
