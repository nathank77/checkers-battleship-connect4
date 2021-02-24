package BattleShip;

/**
 * GetInput.java
 * Description: Contains the classes for getting the boats position,
 * the orientation, getting the shot location, and the translation from user into to
 * Coordinates that the computer can use.
 *
 * @author Ethan Shama and Nathan Kowal
 * @version 1.0 (Last Updated: Jan 12 2019)
 **/


import javax.swing.*;

public class GetInput {


    public static String GetPositions(String boatName) {
        /**
         * GetPositions Description: Gets the user to input the coordinate of where they want there boat to go
         *
         * @param the name of the ship
         *
         * @return the coordinate as a String
         **/


        JFrame frame = new JFrame("Boat Position");
        String boatPosition = "";
        do {
            boatPosition = JOptionPane.showInputDialog(frame, "Please enter the location you wish to put your " + boatName + "(format: A1): ");
        }
        while (boatPosition.length() < 1);
        return boatPosition;
    }

    public static int GetOrientation(String boatName) {
        /**
         * GetOrientation Description: Gets the user to choose either vertical or horizontal for the boats orientation
         *
         * @param the name of the ship
         *
         * @return the orientation as either 0 or 1 as a int
         **/


        Object[] options = {"Horizontal", "Vertical"};
        JFrame frame = new JFrame("Boat Position");

        int boatOrientation = JOptionPane.showOptionDialog(frame, "How would you like your " + boatName + " to be oriented", "Boat Orientation", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        return boatOrientation;

    }

    public static String GetShotLocation() {
        /**
         * GetShotLocation Description: Gets the user to input the coordinate of where they want to shoot
         *
         * @return the coordinate as a String
         **/


        JFrame frame = new JFrame("Shot Location");
        String shotPosition = "";

        do {
            shotPosition = JOptionPane.showInputDialog(frame, "Please enter the location you wish fire(format: A1): ");
        }
        while (shotPosition.length() < 1);
        return shotPosition;

    }

    public static int BoatPositionX(String boat) {
        /**
         * BoatPositionX Description: Translates the string into the X-cord for the comp to use
         *
         * @param the string coordinate 
         *
         * @return the x-cord between 0-9 or -1 if its not vaild 
         **/


        //gets just the first char of the string 
        switch (boat.substring(0, 1)) {

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

            case "I":
            case "i":
                return 8;

            case "J":
            case "j":
                return 9;

        }
        ;
        return -1;
    }

    public static int BoatPositionY(String boat) {
        /**
         * BoatPositionY Description: Translates the string into the Y-cord for the comp to use
         *
         * @param the string coordinate 
         *
         * @return the y-cord between 0-9 or -1 if its not vaild 
         **/


        //gets just the chars after the first one
        switch (boat.substring(1)) {

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

            case "9":
                return 8;

            case "10":
                return 9;

        }
        ;
        return -1;
    }
}
