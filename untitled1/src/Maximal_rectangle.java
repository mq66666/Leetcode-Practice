import java.util.Arrays;

public class Maximal_rectangle {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if(matrix.length==0) return 0;
            int row = matrix.length;
            int column = matrix[0].length;
            int[] height = new int[column];
            int[] left = new int[column];
            int[] right = new int[column];
            int maxarea = 0;
            Arrays.fill(right,column-1);
            for(int i = 0;i<row;i++){
                int cur_left = 0;
                int cur_right = column-1;
                for(int j = 0;j<column;j++){
                    if(matrix[i][j]=='1'){
                        height[j] = height[j] + 1;
                        left[j] = Math.max(cur_left,left[j]);
                    }else{
                        height[j] = 0;
                        left[j] = 0;
                        cur_left = j+1;
                    }
                }
                for(int j = column-1; j>=0; j--){
                    if(matrix[i][j]=='1'){
                        right[j] = Math.min(right[j],cur_right);
                    }else{
                        right[j] = column-1;
                        cur_right = j-1;
                    }
                }
                for(int j = 0;j<column;j++){
                    maxarea = Math.max(maxarea,(right[j]+1-left[j])*height[j]);
                }
            }
            return maxarea;
        }
    }
}
