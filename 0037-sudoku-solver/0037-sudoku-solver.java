class Solution {

    public void solveSudoku(char[][] board) {
        
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // Initialize tracking arrays
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1';
                    int boxIndex = (r / 3) * 3 + (c / 3);
                    rows[r][num] = true;
                    cols[c][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }

        backtrack(board, rows, cols, boxes);
    }

    private boolean backtrack(char[][] board, boolean[][] rows,
                              boolean[][] cols, boolean[][] boxes) {
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                
                if (board[r][c] == '.') {
                    
                    for (int d = 0; d < 9; d++) {
                        int boxIndex = (r / 3) * 3 + (c / 3);

                        if (!rows[r][d] && !cols[c][d] && !boxes[boxIndex][d]) {

                            board[r][c] = (char) (d + '1');
                            rows[r][d] = cols[c][d] = boxes[boxIndex][d] = true;

                            if (backtrack(board, rows, cols, boxes)) {
                                return true;
                            }

                            // Undo (backtrack)
                            board[r][c] = '.';
                            rows[r][d] = cols[c][d] = boxes[boxIndex][d] = false;
                        }
                    }
                    return false; // no valid digit found
                }
            }
        }

        return true; // solved
    }
}
