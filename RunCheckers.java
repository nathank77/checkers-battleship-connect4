package Checkers;


import javax.swing.*;


public class RunCheckers {

    //defining JFrames
    public static JFrame startScreen = new JFrame("Checkers Menu");
    public static JFrame checkerInstructions = new JFrame("Instructions");
    public static JFrame checker = new JFrame("Checker Board");
    static boolean redWin = false, blackWin = false;

    public static void Run() {

        /**
         * Run
         * Description: sets up the JFrames needed for the game
         **/

        //setting up the JFrame for the menu
        startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startScreen.setSize(400, 400);
        startScreen.setResizable(false);
        startScreen.add(new DrawCheckerMenu());
        startScreen.setVisible(true);

        //setting up the JFrame for the instructions
        checkerInstructions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkerInstructions.setSize(710, 725);
        checkerInstructions.setResizable(false);
        checkerInstructions.add(new DrawCheckerInstructions());
        checkerInstructions.setVisible(false);

        //setting up the JFrame for the board
        checker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checker.setSize(700, 725);
        checker.setResizable(false);
        checker.add(new DrawGameBoard());
        checker.setVisible(false);

    } //end method

    //runs the game
    public static void runGame() {

        /**
         * RunGame
         * Description: runs the game
         **/

        do {
            //black turn
            PlayerTurn.Turn(DrawGameBoard.BLACK, DrawGameBoard.RED);

            //check if black wins
            if (WinCheck.BlackCheck()) {
                blackWin = true;
            }

            //if not, red turn
            if (!blackWin)
                PlayerTurn.Turn(DrawGameBoard.RED, DrawGameBoard.BLACK);

            //check if red wins
            if (WinCheck.RedCheck()) {
                redWin = true;
            }
        }

        //if no one has won, do it all over again until there is a winner
        while (!redWin && !blackWin);
    }
}
