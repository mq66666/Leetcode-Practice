import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Friend_Circles {
    static class Solution {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n;
        int[][] M;

        public int findCircleNum(int[][] M) {
            this.n = M.length;
            this.M = M;
            int nc = 0;
            if (M.length == 0) return 0;
            if (M.length == 1) return 1;
            for(int i = 0;i<n;i++){
                set.add(i);
            }
            for (int i = 0; i < M.length; i++) {
                if (this.set.contains(i)) {
                    nc++;
                    map.put(nc,new ArrayList<>());
                    FindCircle(i, nc);

                }

            }


            int ans = map.size();
            return ans;

        }

        public void FindCircle(int i, int circlenum) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1 && this.set.contains(j)) {
                    map.get(circlenum).add(j);
                    set.remove(j);
                    FindCircle(j, circlenum);
                }
            }


        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(sol.findCircleNum(M));
    }
}
