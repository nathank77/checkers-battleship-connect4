package BattleShip;

/**
 * CheckWin.java
 * Description: Checks to see if either the comp or the player wins
 *
 * @author Ethan Shama and Nathan Kowal
 * @version 1.0 (Last Updated: Jan 12 2019)
 **/


public class CheckWin {


    public static boolean playerWinCheck() {
        /**
         * playerWinCheck Description: Checks to see if the player sunk all the enemy ships
         *
         * @return true/false
         **/


        int numberOfEnemiesLeft = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                //if there is a enemy at any position and isn't hit adds to numberOfEmenyLeft
                if (DrawTargetBoard.enemyboardMap[i][j] == 1 && DrawTargetBoard.enemyIsHit[i][j] == 0) {

                    numberOfEnemiesLeft++;

                }
            }
        }

        //if no enemy is left returns true 
        if (numberOfEnemiesLeft == 0) {
            return true;
        }
        //else returns false
        else {
            return false;
        }
    }

    public static boolean compWinCheck() {
        /**
         * compWinCheck Description: Checks to see if the Comp sunk all the player ships
         *
         * @return true/false
         **/

        int numberOfEnemiesLeft = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                //if there is a player at any position and isn't hit adds to numberOfEmenyLeft
                if (DrawGameBoard.boardMap[i][j] == 1 && DrawGameBoard.IsHit[i][j] == 0) {

                    numberOfEnemiesLeft++;

                }
            }
        }
        //if no enemy is left returns true 
        if (numberOfEnemiesLeft == 0) {
            return true;
        }
        //else returns false
        else {
            return false;
        }
    }

}
