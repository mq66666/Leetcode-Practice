public class Minesweeper {
    class Solution {
        char[][] board1;
        int r;
        int c;

        public char[][] updateBoard(char[][] board, int[] click) {
            if (board == null || board.length == 0) {
                return board;
            }
            this.board1 = board;
            this.r = board.length-1;
            this.c = board[0].length-1;
            int i = click[0];
            int j = click[1];
            if (board1[i][j] == 'M') {
                board1[i][j] = 'X';
            } else {
                nearmine(i, j);

            }
            return board1;

        }


        public void nearmine(int i, int j) {
            board1[i][j] = 'B';
            int count = 0;
            if (i - 1 >= 0) {
                if (board1[i - 1][j] == 'M' || board1[i - 1][j] == 'X') {
                    count = count + 1;
                }
                if (j - 1 >= 0 ) {
                    if(board1[i - 1][j - 1] == 'M' || board1[i - 1][j - 1] == 'X') count = count + 1;

                }
                if (j + 1 <= c ) {
                    if(board1[i - 1][j + 1] == 'M' || board1[i - 1][j + 1] == 'X') count = count + 1;
                }
            }

            if (j - 1 >= 0) {
                if (board1[i][j - 1] == 'M' || board1[i][j - 1] == 'X') {
                    count = count + 1;
                }
            }
            if (i + 1 <= r) {
                if (board1[i + 1][j] == 'M' || board1[i + 1][j] == 'X') {
                    count = count + 1;
                }
                if (j - 1 >= 0 ) {
                    if( board1[i + 1][j - 1] == 'M' || board1[i + 1][j - 1] == 'X')  count = count + 1;
                }
                if (j + 1 <= c ) {
                    if( board1[i + 1][j + 1] == 'M' || board1[i + 1][j + 1] == 'X')  count = count + 1;
                }
            }
            if (j + 1 <= c) {
                if (board1[i][j + 1] == 'M' || board1[i][j + 1] == 'X') {
                    count = count + 1;
                }
            }
            if (count == 0) {
                if (i - 1 >= 0) {
                    if (board1[i - 1][j] == 'E') {
                        nearmine(i-1,j);
                    }
                    if (j - 1 >= 0 ) {
                        if(board1[i - 1][j - 1] == 'E' ) nearmine(i-1,j-1);

                    }
                    if (j + 1 <= c ) {
                        if(board1[i - 1][j + 1] == 'E' ) nearmine(i-1,j+1);
                    }
                }

                if (j - 1 >= 0) {
                    if (board1[i][j - 1] == 'E' ) {
                        nearmine(i,j-1);
                    }
                }
                if (i + 1 <= r) {
                    if (board1[i + 1][j] == 'E' ) {
                        nearmine(i+1,j);
                    }
                    if (j - 1 >= 0 ) {
                        if( board1[i + 1][j - 1] == 'E' )  nearmine(i+1,j-1);;
                    }
                    if (j + 1 <= c ) {
                        if( board1[i + 1][j + 1] == 'E' )  nearmine(i+1,j+1);;
                    }
                }
                if (j + 1 <= c) {
                    if (board1[i][j + 1] == 'E' ) {
                        nearmine(i,j+1);
                    }
                }
            } else {
                board1[i][j] = (char) (count + '0');
            }
        }
    }
}