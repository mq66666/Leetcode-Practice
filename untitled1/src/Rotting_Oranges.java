import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {
    class Solution {
        public int orangesRotting(int[][] grid) {
            HashMap<Integer, Integer> map = new HashMap<>();
            Queue<Integer> queue = new LinkedList();
            int minute = 0;
            int R = grid.length;
            int C = grid[0].length;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        map.put(i*C+j, 1);
                    }
                    if (grid[i][j] == 2) {
                        int[] a = {i, j};
                        map.put(i*C+j, 2);
                        queue.offer(i*C+j);
                    }
                }
            }
            if (map.isEmpty()&&queue.isEmpty()) return 0;
            if(!map.isEmpty()&&queue.isEmpty()) return -1;
            if(!map.containsValue(1)) return 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    size--;
                    int cur = queue.poll();
                    if (cur/C - 1 >= 0 && grid[cur/C - 1][cur % C] == 1) {
                        if(!queue.contains((cur/C - 1)*C+cur % C )) queue.offer((cur/C - 1)*C+cur % C );
                    }
                    if (cur % C - 1 >= 0 && grid[cur/C][cur % C - 1] == 1) {
                        if(!queue.contains(cur/C*C+cur % C - 1)) queue.offer(cur/C*C+cur % C - 1);
                    }
                    if (cur/C + 1 < R && grid[cur/C + 1][cur % C]==1) {
                        if(!queue.contains((cur/C + 1)*C+cur % C)) queue.offer((cur/C + 1)*C+cur % C);
                    }
                    if (cur % C + 1 < C && grid[cur/C][cur % C + 1] == 1) {
                        if(!queue.contains(cur/C*C+cur % C + 1)) queue.offer(cur/C*C+cur % C + 1);
                    }
                    grid[cur/C][cur%C] = 2;
                    map.remove(cur);

                    if (size == 0) {
                        minute++;
                        break;
                    }
                }
            }
            if(map.isEmpty())return  minute-1;
            return -1;


        }
    }}

