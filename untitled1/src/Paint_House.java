import java.util.HashMap;

public class Paint_House {
    static class Solution {
        public int minCost(int[][] costs) {
            if(costs.length == 0) return 0;
            if(costs.length == 1) return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
            int cost = 0;
            int[][] min = new int[costs.length][3];
            min[0][0]= costs[0][0];
            min[0][1] = costs[0][1];
            min[0][2] = costs[0][2];
            for (int i = 1; i < costs.length; i++) {
                min[i][0] = costs[i][0]+Math.min(min[i-1][1],min[i-1][2]);
                min[i][1] = costs[i][1]+Math.min(min[i-1][0],min[i-1][2]);
                min[i][2] = costs[i][2]+Math.min(min[i-1][0],min[i-1][1]);
            }
            cost = Math.min(min[costs.length-1][0],Math.min(min[costs.length-1][1],min[costs.length-1][2]));
            return cost;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][]c = {{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
        System.out.println(sol.minCost(c));
    }
}
