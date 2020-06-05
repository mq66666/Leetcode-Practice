import java.util.HashMap;

public class Climbing_Stairs {
    class Solution {
        public int climbStairs(int n) {
            HashMap<Integer,Integer> map = new HashMap<>();
            if(n==0) return 0;
            if(n==1) return 1;
            if(n==2) return 2;
            int ans = 0;
            if(n>2){
                map.put(0,0);
                map.put(1,1);
                map.put(2,2);
                for(int i = 3;i<n+1;i++){
                    map.put(i,map.get(i-1)+map.get(i-2));
                }
                ans = map.get(n);
            }
            return ans;
        }
    }
}
