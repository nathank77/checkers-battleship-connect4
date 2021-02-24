package gameEngine;

import BattleShip.RunBattleShip;
import Checkers.RunCheckers;
import ConnectFour.RunConnectFour;

import javax.swing.*;

public class StartingScreen {

    static JFrame frame = new JFrame("Choose a game");

    public static void main(String[] args) {
        chooseGame();
    }

    public static void chooseGame() {
        int n = 0;

        do {

            try {
                String gameNum = JOptionPane.showInputDialog(frame, "Please enter 1 for checkers, 2 for battleship, 3 for connect four, or 4 to close this window");

                n = Integer.parseInt(gameNum);
            } catch (Exception e) {
            }
        }
        while (n < 1 || n > 4);

        if (n == 1) {
            RunCheckers.startScreen.setVisible(true);
            RunCheckers.Run();
        }

        if (n == 2) {
            RunBattleShip.startScreen.setVisible(true);
            RunBattleShip.Run();
        }

        if (n == 3) {
            RunConnectFour.startScreen.setVisible(true);
            RunConnectFour.Run();
        }

        if (n == 4) {
            System.exit(0);
        }
    }

}
