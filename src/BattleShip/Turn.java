package BattleShip;

import javax.swing.*;

/**
 * Turn.java
 * Description: Contains all the logic for the player and computer turns
 *
 * @author Ethan Shama and Nathan Kowal
 * @version 1.0 (Last Updated: Jan 12 2019)
 **/


public class Turn {


    public static void playerTurn() {
        /**
         * playerTurn Description: Gets the player to choose a location to shoot and changes the enemyIsHit loaction to 1 
         * 						   to rep a shoot at that location. 
         **/

        //starting variables 
        String shootLocation;
        int shootLocationX, shootLocationY;
        boolean goodLocation = false;
        @SuppressWarnings("unused")
        Object invalid;
        Object[] okay = {"Okay"};


        //does this while its not a good location 
        do {

            //gets user to input a cord then translates it to int for comp to use
            shootLocation = GetInput.GetShotLocation();
            shootLocationX = GetInput.BoatPositionX(shootLocation);
            shootLocationY = GetInput.BoatPositionY(shootLocation);

            // checks to make sure x is between 0-9
            if (0 <= shootLocationX && shootLocationX < 10) {

                // checks to make sure y is between 0-9
                if (0 <= shootLocationY && shootLocationY < 10) {

                    //makes sure you haven't already chosen that position 
                    if (DrawTargetBoard.enemyIsHit[shootLocationY][shootLocationX] == 0) {

                        //stops loop and changes cord to 1, then checks if they sunk any ship
                        DrawTargetBoard.enemyIsHit[shootLocationY][shootLocationX] = 1;
                        CheckCompShipSunk.Check();
                        goodLocation = true;

                    }
                    //if you have chosen that position 
                    else if (DrawTargetBoard.enemyIsHit[shootLocationY][shootLocationX] == 1) {

                        //tells you have chosen that position 
                        invalid = JOptionPane.showOptionDialog(null, "You already shot here", "Invalid Move", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);

                    }
                }
            }
        }
        while (!goodLocation);


    }

    public static void computerTurn() {
        /**
         * computerTurn Description: Gets the random to choose a location to shoot and changes the IsHit loaction to 1 
         * 						   to rep a shoot at that location.
         **/

        //starting variables 
        int shootLocationX, shootLocationY;
        boolean goodLocation = false;

        //does this while its not a good location 
        do {

            //gets random numbers to for cord of comp shot
            shootLocationX = (int) (Math.random() * 10);
            shootLocationY = (int) (Math.random() * 10);

            // checks to make sure x is between 0-9
            if (0 <= shootLocationX && shootLocationX <= 10) {

                // checks to make sure y is between 0-9
                if (0 <= shootLocationY && shootLocationY <= 10) {

                    //makes sure comp hasen't already chosen that position 
                    if (DrawGameBoard.IsHit[shootLocationY][shootLocationX] == 0) {

                        //stops loop and changes cord to 1
                        goodLocation = true;
                        DrawGameBoard.IsHit[shootLocationY][shootLocationX] = 1;

                    }
                }
            }
        }
        while (!goodLocation);
    }
}
