package ConnectFour;

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


    public static String GetPositions(String Player) {

        /**
         * GetPositions Description: Gets the user to input the coordinate of where they want to put the piece
         *
         * @param player
         *  the Colour to show whose turn
         *
         * @return the coordinate as a String
         **/

        JFrame frame = new JFrame(Player);
        String colmNum = "";
        do {
            colmNum = JOptionPane.showInputDialog(frame, Player + ": Please enter the column you wish to put your tile in (Between 1-7): ");
        }
        while (colmNum.length() < 1);
        return colmNum;

    }


    public static int ColumnPosition(String colm) {

        /**
         * ColumnPosition Description: Translates the string into the X-cord for the comp to use
         *
         * @param colm
         *  the string
         *
         * @return the x-cord between 0-6 or -1 if its not vaild
         **/

        switch (colm) {

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

        }
        ;
        return -1;


    }

}
