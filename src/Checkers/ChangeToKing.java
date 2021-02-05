package Checkers;

/**
 * ChangeToKing.java
 * Description: Checks to see if any of the red or black pieces need to be changed to kings
 *
 * @author Ethan Shama and Nathan Kowal
 * @version 1.0 (Last Updated: Jan 12 2019)
 **/


public class ChangeToKing {

    public static void ToKing() {
        /**
         * ToKing Description: Checks to see if any black or red pieces need to be changed to kings then changes them
         **/

        //changes red to redKing
        for (int i = 0; i < 8; i++) {
            if (DrawGameBoard.boardMap[0][i] == DrawGameBoard.RED) {
                DrawGameBoard.boardMap[0][i] = DrawGameBoard.RED_KING;
            }
        }

        //changes black to blackKing
        for (int i = 0; i < 8; i++) {
            if (DrawGameBoard.boardMap[7][i] == DrawGameBoard.BLACK) {
                DrawGameBoard.boardMap[7][i] = DrawGameBoard.BLACK_KING;
            }
        }


    }
}
