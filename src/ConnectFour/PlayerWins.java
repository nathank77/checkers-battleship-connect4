package ConnectFour;


/**
 * PlayerWins.java
 * Description: Checks to see if either the blue or red wins
 *
 * @author Ethan Shama and Nathan Kowal
 * @version 1.0 (Last Updated: Jan 12 2019)
 **/

public class PlayerWins {


    public static boolean CheckWin(int[][] board, int colour, int row, int col, int rowIncrease, int colIncrease) {

        /**
         * CheckWin Description: Checks to see if the specified colour has won
         *
         * @param board
         * the board to be checked
         *
         * @param colour
         * the colour to be checked
         *
         * @param row
         * the row of the last placed piece
         *
         * @param col
         * the column of the last placed piece
         *
         * @param rowIncrease
         * how much to increase the row by
         *
         * @param colIncrease
         * how much to increase the column by
         *
         * @return true/false
         **/

        boolean win = false;
        int inARow = 0;

        //only run 4 times (4 in a row)
        for (int count = 0; count < 4; count++) {
            win = false;

            //if the coordinates are on the board (avoids array out of bounds exception)
            if (row <= 5 && row >= 0 && col <= 6 && col >= 0) {

                //creates a variable for the current position being checked
                int test = board[row][col];

                //if it matches the desired colour, increase inARow by 1
                if (test == colour) {
                    inARow++;

                }

            }

            //after each iteration, increase row and column
            row += rowIncrease;
            col += colIncrease;

        }

        //if inARow becomes 4, set win to true
        if (inARow >= 4) {
            win = true;
        }

        //otherwise, this will be false
        return win;
    }


    public static boolean CheckWin(int[][] board, int colour, int row, int col) {


        /**
         * CheckWin Description: overloaded method that will implement the first method
         * Allows the program to only have to enter 1 line of code to check all possible win conditions.
         *
         * @param board
         * the board to be checked
         *
         * @param colour
         * the colour to be checked
         *
         * @param row
         * the row of the last placed piece
         *
         * @param col
         * the column of the last placed piece
         *
         * @return true/false
         **/

        //vertical check
        if (CheckWin(board, colour, row, col, 1, 0)) {
            return true;
        }

        //horizontal right check
        else if (CheckWin(board, colour, row, col, 0, 1)) {
            return true;
        }

        //horizontal left check
        else if (CheckWin(board, colour, row, col, 0, -1)) {
            return true;
        }

        //diagonal down right check
        else if (CheckWin(board, colour, row, col, 1, 1)) {
            return true;
        }

        //diagonal up left check
        else if (CheckWin(board, colour, row, col, -1, -1)) {
            return true;
        }

        //diagonal up right check
        else if (CheckWin(board, colour, row, col, -1, 1)) {
            return true;
        }

        //diagonal down left check
        else if (CheckWin(board, colour, row, col, 1, -1)) {
            return true;
        } else {
            return false;
        }


    }

}