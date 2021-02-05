package Checkers;

/**
 * WinCheck.java
 * Description: Checks to see if either the black or red wins
 *
 * @author Ethan Shama and Nathan Kowal
 * @version 1.0 (Last Updated: Jan 12 2019)
 **/


public class WinCheck {

    public static boolean BlackCheck() {
        /**
         * BlackCheck Description: Checks to see if the black has won
         *
         * @return true/false
         **/

        int redPieces = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                //checks to see if any red pieces still on the board
                if (DrawGameBoard.boardMap[i][j] == DrawGameBoard.RED || DrawGameBoard.boardMap[i][j] == DrawGameBoard.RED_KING) {

                    // if so adds to redPieces
                    redPieces++;
                }
            }
        }

        //if redPiece is more then 0 returns false
        if (redPieces > 0) {

            return false;

        }
        //else returns true
        else {

            return true;

        }
    }

    public static boolean RedCheck() {
        /**
         * BlackCheck Description: Checks to see if the black has won
         *
         * @return true/false
         **/

        int blackPieces = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                //checks to see if any Black pieces still on the board
                if (DrawGameBoard.boardMap[i][j] == DrawGameBoard.BLACK || DrawGameBoard.boardMap[i][j] == DrawGameBoard.BLACK_KING) {

                    // if so adds to blackPieces
                    blackPieces++;
                }
            }
        }

        //if blackPieces is more then 0 returns false
        if (blackPieces > 0) {

            return false;

        }
        //else returns true
        else {

            return true;

        }
    }
}
