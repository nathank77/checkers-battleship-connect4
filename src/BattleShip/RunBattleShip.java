package BattleShip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunBattleShip implements ActionListener {

    //defining JFrames
    public static JFrame startScreen = new JFrame("BattleShip Menu");
    public static JFrame battleshipTarget = new JFrame("Targeting System");
    public static JFrame battleship = new JFrame("My Ships");
    public static JFrame instructions = new JFrame("My Ships");
    static
    boolean playerWin = false, compWin = false;

    public static void Run() {

        /**
         * Run
         * Description: sets up the JFrames needed for the game
         **/

        //defining and setting up the JFrames for the menu
        startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startScreen.setSize(400, 400);
        startScreen.setResizable(false);
        startScreen.add(new DrawBattleshipMenu());
        startScreen.setVisible(true);

        //setting up the JFrame for the instructions
        instructions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instructions.setSize(710, 725);
        instructions.setResizable(false);
        instructions.add(new DrawBattleshipInstructions());
        instructions.setVisible(false);

        //setting up the JFrames for game
        battleshipTarget.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        battleshipTarget.setSize(560, 590);
        battleshipTarget.setResizable(false);
        battleshipTarget.add(new DrawTargetBoard());
        battleshipTarget.setVisible(false);

        //setting up the JFrames for game
        battleship.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        battleship.setSize(560, 590);
        battleship.setResizable(false);
        battleship.add(new DrawGameBoard());
        battleship.setVisible(false);

    } //end method

    //runs the game
    public static void runGame() {

        /**
         * RunGame
         * Description: runs the game
         **/

        //gets locations for the ships of player and user
        StartingPositions.GetPLayerLoctaions();
        StartingPositions.GetCompLoctaions();


        do {

            //does player turn
            Turn.playerTurn();

            //check if player wins
            playerWin = CheckWin.playerWinCheck();

            //if not, computer turn adn check if computer wins
            if (!playerWin) {
                Turn.computerTurn();
                compWin = CheckWin.compWinCheck();
            }

        }

        //if no one has won, do it all over again
        while (!playerWin && !compWin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}