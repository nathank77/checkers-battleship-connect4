package Checkers;

/**
 * GetInput.java
 * Description: Contains the classes for getting the piece position, and move location
 * and the translation from user into to
 * Coordinates that the computer can use.
 *
 * @author Ethan Shama and Nathan Kowal
 * @version 1.0 (Last Updated: Jan 12 2019)
 **/

import javax.swing.*;

public class GetInput {


    public static String GetPositions(String player) {

        /**
         * GetPositions Description: Gets the user to input the coordinate of what piece they want to move
         *
         * @param player
         * the Colour to show whose turn
         *
         * @return the coordinate as a String
         **/


        JFrame frame = new JFrame("Position");
        String checkersPosition = "";

        do {
            checkersPosition = JOptionPane.showInputDialog(frame, player + " turn: Please enter the piece (format: A1): ");
        }
        while (checkersPosition.length() < 1);

        return checkersPosition;

    }

    public static String MovePositions(String player) {

        /**
         * MovePositions Description: Gets the user to input the coordinate of where they want to move the piece
         *
         * @param player
         * the Colour to show whose turn
         *
         * @return the coordinate as a String
         **/

        JFrame frame = new JFrame("Move Location");
        String MovePosition = "";

        do {
            MovePosition = JOptionPane.showInputDialog(frame, player + " turn: Please enter the square you want to move to (format: A1): ");
        }
        while (MovePosition.length() < 1);

        return MovePosition;

    }


    public static int CheckersPositionX(String checkers) {

        /**
         * CheckersPositionX Description: Translates the string into the X-cord for the comp to use
         *
         * @param checkers
         *  the string 
         *
         * @return the x-cord between 0-7 or -1 if its not vaild 
         **/

        switch (checkers.substring(0, 1)) {

            case "A":
            case "a":
                return 0;

            case "B":
            case "b":
                return 1;

            case "C":
            case "c":
                return 2;

            case "D":
            case "d":
                return 3;

            case "E":
            case "e":
                return 4;

            case "F":
            case "f":
                return 5;

            case "G":
            case "g":
                return 6;

            case "H":
            case "h":
                return 7;

        }
        ;
        return -1;


    }

    public static int CheckersPositionY(String checkers) {

        /**
         * BoatPositionY Description: Translates the string into the Y-cord for the comp to use
         *
         * @param the string  
         *
         * @return the y-cord between 0-7 or -1 if its not vaild 
         **/

        switch (checkers.substring(1)) {

            case "1":
                return 0;

            case "2":
                return 1;

            case "3":
                return 2;

            case "4":
                return 3;

            case "5":
                return 4;

            case "6":
                return 5;

            case "7":
                return 6;

            case "8":
                return 7;

        }
        ;
        return -1;


    }

}
