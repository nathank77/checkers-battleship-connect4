package ConnectFour;

import javax.swing.*;

public class RunConnectFour {

    //defines the JFrames needed
    public static JFrame startScreen = new JFrame("Connect Four Menu");
    public static JFrame connectFour = new JFrame("Connect Four");
    public static JFrame instructionsC = new JFrame("Instructions");
    static boolean BlueWins = false, RedWins = false;

    public static void Run() {

        /**
         * Run
         * Description: sets up the JFrames needed for the game
         **/

        //setting up the JFrame for the menu
        startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startScreen.setSize(400, 400);
        startScreen.setResizable(false);
        startScreen.add(new DrawConnectFourMenu());
        startScreen.setVisible(true);

        //setting up the JFrame for the instructions
        instructionsC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instructionsC.setSize(710, 725);
        instructionsC.setResizable(false);
        instructionsC.add(new DrawConnectFourInstructions());
        instructionsC.setVisible(false);

        //setting up the JFrame for game
        connectFour.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        connectFour.setSize(620, 600);
        connectFour.setResizable(false);
        connectFour.add(new DrawGameBoard());

    } //end method

    public static void runGame() {

        /**
         * RunGame
         * Description: runs the game
         **/

        do {

            //red turn
            PlayerTurn.RedTurn();

            //check if red wins
            if (PlayerWins.CheckWin(DrawGameBoard.boardMap, 1, PlayerTurn.RedRow, PlayerTurn.RedCol)) {
                RedWins = true;
            }

            //if not, blue turn
            if (!RedWins)
                PlayerTurn.BlueTurn();


            //check if blue wins
            if (PlayerWins.CheckWin(DrawGameBoard.boardMap, 2, PlayerTurn.BlueRow, PlayerTurn.BlueCol)) {
                BlueWins = true;
            }

        }

        //if no one has won, do it all over again until there is a winner
        while (!RedWins && !BlueWins);
    }
}