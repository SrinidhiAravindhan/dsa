public class Solution {
    
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        // Try to find an empty cell
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {  // If the cell is empty
                    // Try each number from '1' to '9'
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;  // Place the number
                            if (solve(board)) {
                                return true;  // If the board is solvable, return true
                            }
                            board[i][j] = '.';  // Backtrack
                        }
                    }
                    return false;  // If no number is valid, return false
                }
            }
        }
        return true;  // If all cells are filled, the puzzle is solved
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;  // If no conflicts were found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        char[][] board1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        
        solution.solveSudoku(board1);
        for (char[] row : board1) {
            System.out.println(row);
        }
    }
}
