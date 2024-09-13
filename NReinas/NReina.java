
public class NReina {
    private int size;
    private int[] queens; // Array where index is row and value is column

    public NReina(int size) {
        this.size = size;
        queens = new int[size];
    }

    public boolean solve() {
        return placeQueen(0);
    }

    private boolean placeQueen(int row) {
        if (row == size) {
            printSolution();
            return true; // Return true to indicate a solution was found
        }
        return placeQueenInColumn(row, 0);
    }

    private boolean placeQueenInColumn(int row, int col) {
        if (col == size) {
            return false; // Return false if no column is valid
        }

        if (isSafe(row, col)) {
            queens[row] = col;
            if (placeQueen(row + 1)) {
                return true; // Return true if we found a solution
            }
            // If no solution was found, backtrack by trying the next column
        }
        return placeQueenInColumn(row, col + 1);
    }

    private boolean isSafe(int row, int col) {
        return checkPreviousRows(row, col, 0);
    }

    private boolean checkPreviousRows(int row, int col, int i) {
        if (i >= row) {
            return true;
        }
        if (queens[i] == col || queens[i] - i == col - row || queens[i] + i == col + row) {
            return false;
        }
        return checkPreviousRows(row, col, i + 1);
    }

    private void printSolution() {
        printRow(0);
        System.out.println();
    }

    private void printRow(int i) {
        if (i >= size) {
            return;
        }
        printColumns(i, 0);
        System.out.println();
        printRow(i + 1);
    }

    private void printColumns(int i, int j) {
        if (j >= size) {
            return;
        }
        if (queens[i] == j) {
            System.out.print("Q ");
        } else {
            System.out.print(". ");
        }
        printColumns(i, j + 1);
    }

    public static void main(String[] args) {
        int n = 20; // Example size of the board
        NReina nQueens = new NReina(n);
        if (!nQueens.solve()) {
            System.out.println("No solutions found.");
        }
    }
}