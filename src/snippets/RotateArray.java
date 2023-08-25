package snippets;

public class RotateArray {
    private int[][] rotate(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] rotated = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - i - 1] = board[i][j];
            }
        }
        return rotated;
    }
}
