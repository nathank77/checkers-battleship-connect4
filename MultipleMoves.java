package Checkers;

import javax.swing.*;

public class MultipleMoves {


    public static Object[] options = {"Yes", "NO"};
    public static Object doubleJump;
    public static Object tripleJump;


    public static void DownRR(int MovePositionX, int MovePositionY) {
        /**
         * DownRR Description: Checks to see if a double jump to the down and Right is possible after right and down first jump
         *
         * @param the move X cord
         *
         * @param the move Y cord
         **/


        //Checks to see if one down and one right has an enemy and if two down and two right is empty
        if (MovePositionY < 6 && MovePositionX < 6 && DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX + 2] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX + 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX + 1] == PlayerTurn.enemyKing))) {

            //asks if you want to double jump
            doubleJump = JOptionPane.showOptionDialog(null, "Would You like to Double Jump?", "Double Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            //if yes double jumps
            if ((int) doubleJump == 0) {

                //sets two down and right to the players colour and changes there current position and the enemies position to empty
                DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX + 2] = DrawGameBoard.boardMap[MovePositionY][MovePositionX];
                DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX + 1] = DrawGameBoard.EMPTY;
                DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.EMPTY;

                //check if any pieces can be switched to kings
                ChangeToKing.ToKing();

                //Checks to see if one down and one right has an enemy and if two down and two right is empty
                if (MovePositionY < 6 && MovePositionX < 6 && DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX + 4] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 3] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 3] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two down and right to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX + 4] = DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX + 2];
                        DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 3] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX + 2] = DrawGameBoard.EMPTY;

                        //check if any pieces can be switched to kings
                        ChangeToKing.ToKing();
                    }
                }

                //Checks to see if one down and one left has an enemy and if two down and two left is empty
                else if (MovePositionY < 6 && MovePositionX > 1 && DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 1] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two down and left to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX] = DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX + 2];
                        DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 1] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX + 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();

                    }
                }
            }
        }
    }

    public static void DownRL(int MovePositionX, int MovePositionY) {
        /**
         * DownRL Description: Checks to see if a double jump to the down and left is possible after right and down first jump
         *
         * @param the move X cord
         *
         * @param the move Y cord
         **/

        //Checks to see if one down and one left has an enemy and if two down and two left is empty
        if (MovePositionY < 6 && MovePositionX > 1 && DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX - 2] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX - 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX - 1] == PlayerTurn.enemyKing))) {

            //asks if you want to double jump
            doubleJump = JOptionPane.showOptionDialog(null, "Would You like to Double Jump?", "Double Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            //if yes double jumps
            if ((int) doubleJump == 0) {

                //sets two down and left to the players colour and changes there current position and the enemies position to empty
                DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX - 2] = DrawGameBoard.boardMap[MovePositionY][MovePositionX];
                DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX - 1] = DrawGameBoard.EMPTY;
                DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.EMPTY;
                ChangeToKing.ToKing();

                //Checks to see if one down and one right has an enemy and if two down and two right is empty
                if (MovePositionY < 6 && MovePositionX < 6 && DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX - 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX - 1] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two down and right to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX] = DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX - 2];
                        DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX - 1] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX - 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }

                //Checks to see if one down and one left has an enemy and if two down and two left is empty
                else if (MovePositionY < 6 && MovePositionX > 1 && DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX - 4] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX - 3] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX - 3] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two down and left to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX - 4] = DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX - 2];
                        DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX - 3] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX - 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }
            }
        }
    }

    public static void DownLR(int MovePositionX, int MovePositionY) {
        /**
         * DownLR Description: Checks to see if a double jump to the down and right is possible after left and down first jump
         *
         * @param the move X cord
         *
         * @param the move Y cord
         **/


        //Checks to see if one down and one right has an enemy and if two down and two right is empty
        if (MovePositionY < 6 && MovePositionX < 6 && DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX + 2] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX + 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX + 1] == PlayerTurn.enemyKing))) {

            //asks if you want to double jump
            doubleJump = JOptionPane.showOptionDialog(null, "Would You like to Double Jump?", "Double Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            //if yes double jumps
            if ((int) doubleJump == 0) {

                //sets two down and right to the players colour and changes there current position and the enemies position to empty
                DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX + 2] = DrawGameBoard.boardMap[MovePositionY][MovePositionX];
                DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX + 1] = DrawGameBoard.EMPTY;
                DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.EMPTY;
                ChangeToKing.ToKing();

                //Checks to see if one down and one right has an enemy and if two down and two right is empty
                if (MovePositionY < 6 && (MovePositionX + 2) < 6 && DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX + 4] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 3] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 3] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two down and right to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX + 4] = DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX + 2];
                        DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 3] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX + 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }
                //third jump to the left
                else if (MovePositionY < 6 && (MovePositionX + 2) > 1 && DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 1] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two down and left to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX] = DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX + 2];
                        DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 1] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX + 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }
            }
        }
    }

    public static void DownLL(int MovePositionX, int MovePositionY) {
        /**
         * DownLL Description: Checks to see if a double jump to the down and left is possible after left and down first jump
         *
         * @param the move X cord
         *
         * @param the move Y cord
         **/

        //Checks to see if one down and one left has an enemy and if two down and two left is empty
        if (MovePositionY < 6 && MovePositionX > 1 && DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX - 2] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX - 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX - 1] == PlayerTurn.enemyKing))) {

            //asks if you want to double jump
            doubleJump = JOptionPane.showOptionDialog(null, "Would You like to Double Jump?", "Double Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            //if yes double jumps
            if ((int) doubleJump == 0) {

                //sets two down and left to the players colour and changes there current position and the enemies position to empty
                DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX - 2] = DrawGameBoard.boardMap[MovePositionY][MovePositionX];
                DrawGameBoard.boardMap[MovePositionY + 1][MovePositionX - 1] = DrawGameBoard.EMPTY;
                DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.EMPTY;
                ChangeToKing.ToKing();

                //Checks to see if one down and one right has an enemy and if two down and two right is empty
                if (MovePositionY < 6 && MovePositionX < 6 && DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX - 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX - 1] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two down and right to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX] = DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX - 2];
                        DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX - 1] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX - 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }
                //Checks to see if one down and one left has an enemy and if two down and two left is empty
                else if (MovePositionY < 6 && (MovePositionX - 2) > 1 && DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX - 4] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX - 3] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 1] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two down and left to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY + 4][MovePositionX - 4] = DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX - 2];
                        DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX - 3] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX - 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }
            }
        }
    }

    public static void UpLR(int MovePositionX, int MovePositionY) {
        /**
         * UpLR Description: Checks to see if a double jump to the up and right is possible after left and up first jump
         *
         * @param the move X cord
         *
         * @param the move Y cord
         **/


        //Checks to see if one up and one right has an enemy and if two up and two right is empty
        if (MovePositionY > 1 && MovePositionX < 6 && DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX + 2] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX + 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX + 1] == PlayerTurn.enemyKing))) {

            //asks if you want to double jump
            doubleJump = JOptionPane.showOptionDialog(null, "Would You like to Double Jump?", "Double Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            //if yes double jumps
            if ((int) doubleJump == 0) {

                //sets two up and right to the players colour and changes there current position and the enemies position to empty
                DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX + 2] = DrawGameBoard.boardMap[MovePositionY][MovePositionX];
                DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX + 1] = DrawGameBoard.EMPTY;
                DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.EMPTY;
                ChangeToKing.ToKing();

                //Checks to see if one up and one right has an enemy and if two up and two right is empty
                if (MovePositionY > 1 && (MovePositionX + 2) < 6 && DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX + 4] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX + 3] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX + 3] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two up and right to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX + 4] = DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX + 2];
                        DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX + 3] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX + 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }
                //third jump to the left
                else if (MovePositionY > 1 && MovePositionX > 1 && DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX + 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX + 1] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two up and left to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX] = DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX + 2];
                        DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX + 1] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX + 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }
            }
        }
    }

    public static void UpLL(int MovePositionX, int MovePositionY) {
        /**
         * UpLL Description: Checks to see if a double jump to the up and left is possible after left and up first jump
         *
         * @param the move X cord
         *
         * @param the move Y cord
         **/


        //Checks to see if one up and one left has an enemy and if two up and two left is empty
        if (MovePositionY > 1 && MovePositionX > 1 && DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX - 2] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX - 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX - 1] == PlayerTurn.enemyKing))) {

            //asks if you want to double jump
            doubleJump = JOptionPane.showOptionDialog(null, "Would You like to Double Jump?", "Double Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            //if yes double jumps
            if ((int) doubleJump == 0) {

                //sets two up and left to the players colour and changes there current position and the enemies position to empty
                DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX - 2] = DrawGameBoard.boardMap[MovePositionY][MovePositionX];
                DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX - 1] = DrawGameBoard.EMPTY;
                DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.EMPTY;
                ChangeToKing.ToKing();

                //Checks to see if one up and one right has an enemy and if two up and two right is empty
                if (MovePositionY > 1 && MovePositionX < 6 && DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX - 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX - 1] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two up and right to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX] = DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX - 2];
                        DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX - 1] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX - 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }
                //third jump to the left
                else if (MovePositionY > 1 && MovePositionX > 1 && DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX - 4] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX - 3] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX - 3] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two up and left to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX - 4] = DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX - 2];
                        DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX - 3] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX - 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }
            }
        }
    }

    public static void UpRR(int MovePositionX, int MovePositionY) {
        /**
         * UpRR Description: Checks to see if a double jump to the up and Right is possible after right and up first jump
         *
         * @param the move X cord
         *
         * @param the move Y cord
         **/


        //Checks to see if up down and one right has an enemy and if two up and two right is empty
        if (MovePositionY > 1 && MovePositionX < 6 && DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX + 2] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX + 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX + 1] == PlayerTurn.enemyKing))) {

            //asks if you want to double jump
            doubleJump = JOptionPane.showOptionDialog(null, "Would You like to Double Jump?", "Double Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            //if yes double jumps
            if ((int) doubleJump == 0) {

                //sets two up and right to the players colour and changes there current position and the enemies position to empty
                DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX + 2] = DrawGameBoard.boardMap[MovePositionY][MovePositionX];
                DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX + 1] = DrawGameBoard.EMPTY;
                DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.EMPTY;
                ChangeToKing.ToKing();

                //Checks to see if one up and one right has an enemy and if two up and two right is empty
                if (MovePositionY > 1 && (MovePositionX + 2) < 6 && DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX + 4] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX + 3] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX + 3] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two up and right to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX + 4] = DrawGameBoard.boardMap[MovePositionY + 2][MovePositionX + 2];
                        DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX + 3] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX + 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }
                //third jump in the left
                else if (MovePositionY > 1 && (MovePositionX + 2) > 1 && DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX + 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX + 1] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two up and left to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX] = DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX + 2];
                        DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX + 1] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX + 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }
            }
        }
    }

    public static void UpRL(int MovePositionX, int MovePositionY) {
        /**
         * UpRL Description: Checks to see if a double jump to the down and left is possible after right and up first jump
         *
         * @param the move X cord
         *
         * @param the move Y cord
         **/

        //Checks to see if one up and one left has an enemy and if two up and two left is empty
        if (MovePositionY > 1 && MovePositionX > 1 && DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX - 2] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX - 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX - 1] == PlayerTurn.enemyKing))) {

            //asks if you want to double jump
            doubleJump = JOptionPane.showOptionDialog(null, "Would You like to Double Jump?", "Double Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            //if yes double jumps
            if ((int) doubleJump == 0) {

                //sets two up and left to the players colour and changes there current position and the enemies position to empty
                DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX - 2] = DrawGameBoard.boardMap[MovePositionY][MovePositionX];
                DrawGameBoard.boardMap[MovePositionY - 1][MovePositionX - 1] = DrawGameBoard.EMPTY;
                DrawGameBoard.boardMap[MovePositionY][MovePositionX] = DrawGameBoard.EMPTY;
                ChangeToKing.ToKing();

                //Checks to see if one up and one right has an enemy and if two up and two right is empty
                if (MovePositionY > 1 && MovePositionX < 6 && DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX - 1] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX - 1] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two up and right to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX] = DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX - 2];
                        DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX - 1] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX - 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }
                //third jump to the left
                else if (MovePositionY > 1 && (MovePositionX - 2) > 1 && DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX - 4] == DrawGameBoard.EMPTY && (DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX - 3] == PlayerTurn.enemy || (DrawGameBoard.boardMap[MovePositionY + 3][MovePositionX + 1] == PlayerTurn.enemyKing))) {

                    // asks if you want to triple jump
                    tripleJump = JOptionPane.showOptionDialog(null, "Would You like to Triple Jump?", "Triple Jump", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    //if yes triple jumps
                    if ((int) tripleJump == 0) {

                        //sets two up and left to the players colour and changes there current position and the enemies position to empty
                        DrawGameBoard.boardMap[MovePositionY - 4][MovePositionX - 4] = DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX - 2];
                        DrawGameBoard.boardMap[MovePositionY - 3][MovePositionX - 3] = DrawGameBoard.EMPTY;
                        DrawGameBoard.boardMap[MovePositionY - 2][MovePositionX - 2] = DrawGameBoard.EMPTY;
                        ChangeToKing.ToKing();
                    }
                }
            }
        }
    }
}