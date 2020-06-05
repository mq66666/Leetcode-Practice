import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Islands {
    public int numIslands(char[][] grid) {
        int num = 0;

        if (grid.length == 0||grid == null) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i <= grid.length - 1; i++) {
            for (int j = 0; j <= grid[0].length - 1; j++) {
                if (grid[i][j] == '1') {
                    num = num+1;
                    grid[i][j] = '0';
                    Queue<Integer> FIFO = new LinkedList<>();
                    FIFO.add(i * c + j);
                    while(!FIFO.isEmpty()){
                        int id = FIFO.poll();
                        int rn = id/c;
                        int cn = id%c;
                        if( rn-1>=0 && grid[rn-1][cn] =='1'){
                            FIFO.add((rn-1)*c+cn);
                            grid[rn-1][cn] = '0';
                        }
                        if( rn+1<=(r-1) && grid[rn+1][cn] =='1'){
                            FIFO.add((rn+1)*c+cn);
                            grid[rn+1][cn] = '0';
                        }
                        if( cn-1>=0 && grid[rn][cn-1] =='1'){
                            FIFO.add(rn*c+cn-1);
                            grid[rn][cn-1] = '0';
                        }
                        if( cn+1<=(c-1) && grid[rn][cn+1] =='1'){
                            FIFO.add(rn*c+cn+1);
                            grid[rn][cn+1] = '0';
                        }

                    }
                }
            }
        }return  num;

    }
}
