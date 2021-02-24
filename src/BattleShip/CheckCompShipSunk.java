package BattleShip;

import javax.swing.*;

public class CheckCompShipSunk {

    public static Object[] okay = {"Okay"};

    public static boolean BattleShip = false, Cruiser1 = false, Cruiser2 = false, Destroyer1 = false, Destroyer2 = false, Destroyer3 = false, Submarine1 = false, Submarine2 = false, Submarine3 = false, Submarine4 = false;

    // Class that checks if sunk 
    @SuppressWarnings("unused")
    public static void Check() {
        /**
         * Check Description: Checks to see if the you sunk any of the enemy ship
         **/

        //Checks if battleship is sunk or not (Orientation = 0 means ship is Horizontal, Orientation = 1 means ship is Vertical), if sunk gives user a message telling them
        if (!BattleShip && StartingPositions.CompBattleShipOrientation == 0 && DrawTargetBoard.enemyIsHit[StartingPositions.CompBattleShipPositionY][StartingPositions.CompBattleShipPositionX] == 1 &&
                DrawTargetBoard.enemyIsHit[(StartingPositions.CompBattleShipPositionY)][(StartingPositions.CompBattleShipPositionX + 1)] == 1 && DrawTargetBoard.enemyIsHit[(StartingPositions.CompBattleShipPositionY)][(StartingPositions.CompBattleShipPositionX + 2)] == 1
                && DrawTargetBoard.enemyIsHit[(StartingPositions.CompBattleShipPositionY)][(StartingPositions.CompBattleShipPositionX + 3)] == 1) {
            BattleShip = true;
            int Battleship = JOptionPane.showOptionDialog(null, "You sunk your enemies BattleShip!", "You sunk your enemies BattleShip!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);

        } else if (!BattleShip && StartingPositions.CompBattleShipOrientation == 1 && DrawTargetBoard.enemyIsHit[StartingPositions.CompBattleShipPositionY][StartingPositions.CompBattleShipPositionX] == 1 &&
                DrawTargetBoard.enemyIsHit[(StartingPositions.CompBattleShipPositionY + 1)][(StartingPositions.CompBattleShipPositionX)] == 1 && DrawTargetBoard.enemyIsHit[(StartingPositions.CompBattleShipPositionY + 2)][(StartingPositions.CompBattleShipPositionX)] == 1
                && DrawTargetBoard.enemyIsHit[(StartingPositions.CompBattleShipPositionY + 3)][(StartingPositions.CompBattleShipPositionX)] == 1) {
            BattleShip = true;
            int Battleship = JOptionPane.showOptionDialog(null, "You sunk your enemies BattleShip!", "You sunk your enemies BattleShip!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);

        }

        //Checks if Cruiser1 is sunk or not (Orientation = 0 means ship is Horizontal, Orientation = 1 means ship is Vertical), if sunk gives user a message telling them
        if (!Cruiser1 && StartingPositions.CompCruiserOrientation[0] == 0 && DrawTargetBoard.enemyIsHit[StartingPositions.CompCruiserPositionY[0]][StartingPositions.CompCruiserPositionX[0]] == 1 &&
                DrawTargetBoard.enemyIsHit[(StartingPositions.CompCruiserPositionY[0])][(StartingPositions.CompCruiserPositionX[0] + 1)] == 1 && DrawTargetBoard.enemyIsHit[(StartingPositions.CompCruiserPositionY[0])][(StartingPositions.CompCruiserPositionX[0] + 2)] == 1) {
            int Crusier1 = JOptionPane.showOptionDialog(null, "You sunk your enemies Crusier1!", "You sunk your enemies Crusier1!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Cruiser1 = true;
        } else if (!Cruiser1 && StartingPositions.CompCruiserOrientation[0] == 1 && DrawTargetBoard.enemyIsHit[StartingPositions.CompCruiserPositionY[0]][StartingPositions.CompCruiserPositionX[0]] == 1 &&
                DrawTargetBoard.enemyIsHit[(StartingPositions.CompCruiserPositionY[0] + 1)][(StartingPositions.CompCruiserPositionX[0])] == 1 && DrawTargetBoard.enemyIsHit[(StartingPositions.CompCruiserPositionY[0] + 2)][(StartingPositions.CompCruiserPositionX[0])] == 1) {
            int Crusier1 = JOptionPane.showOptionDialog(null, "You sunk your enemies Crusier1!", "You sunk your enemies Crusier1!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Cruiser1 = true;
        }

        //Checks if Cruiser2 is sunk or not (Orientation = 0 means ship is Horizontal, Orientation = 1 means ship is Vertical), if sunk gives user a message telling them
        if (!Cruiser2 && StartingPositions.CompCruiserOrientation[1] == 0 && DrawTargetBoard.enemyIsHit[StartingPositions.CompCruiserPositionY[1]][StartingPositions.CompCruiserPositionX[1]] == 1 &&
                DrawTargetBoard.enemyIsHit[(StartingPositions.CompCruiserPositionY[1])][(StartingPositions.CompCruiserPositionX[1] + 1)] == 1 && DrawTargetBoard.enemyIsHit[(StartingPositions.CompCruiserPositionY[1])][(StartingPositions.CompCruiserPositionX[1] + 2)] == 1) {
            int Crusier2 = JOptionPane.showOptionDialog(null, "You sunk your enemies Crusier2", "You sunk your enemies Crusier2!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Cruiser2 = true;
        } else if (!Cruiser2 && StartingPositions.CompCruiserOrientation[1] == 1 && DrawTargetBoard.enemyIsHit[StartingPositions.CompCruiserPositionY[1]][StartingPositions.CompCruiserPositionX[1]] == 1 &&
                DrawTargetBoard.enemyIsHit[(StartingPositions.CompCruiserPositionY[1] + 1)][(StartingPositions.CompCruiserPositionX[1])] == 1 && DrawTargetBoard.enemyIsHit[(StartingPositions.CompCruiserPositionY[1] + 2)][(StartingPositions.CompCruiserPositionX[1])] == 1) {
            int Crusier2 = JOptionPane.showOptionDialog(null, "You sunk your enemies Crusier2", "You sunk your enemies Crusier2!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Cruiser2 = true;
        }

        //Checks if Destroyer1 is sunk or not (Orientation = 0 means ship is Horizontal, Orientation = 1 means ship is Vertical), if sunk gives user a message telling them
        if (!Destroyer1 && StartingPositions.CompDestroyerOrientation[0] == 0 && DrawTargetBoard.enemyIsHit[StartingPositions.CompDestroyerPositionY[0]][StartingPositions.CompDestroyerPositionX[0]] == 1 &&
                DrawTargetBoard.enemyIsHit[(StartingPositions.CompDestroyerPositionY[0])][(StartingPositions.CompDestroyerPositionX[0] + 1)] == 1) {
            int DestroyerSunk1 = JOptionPane.showOptionDialog(null, "You sunk your enemies Destroyer1", "You sunk your enemies Destroyer1!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Destroyer1 = true;
        } else if (!Destroyer1 && StartingPositions.CompDestroyerOrientation[0] == 1 && DrawTargetBoard.enemyIsHit[StartingPositions.CompDestroyerPositionY[0]][StartingPositions.CompDestroyerPositionX[0]] == 1 &&
                DrawTargetBoard.enemyIsHit[(StartingPositions.CompDestroyerPositionY[0] + 1)][(StartingPositions.CompDestroyerPositionX[0])] == 1) {
            int DestroyerSunk1 = JOptionPane.showOptionDialog(null, "You sunk your enemies Destroyer1", "You sunk your enemies Destroyer1!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Destroyer1 = true;
        }

        //Checks if Destroyer2 is sunk or not (Orientation = 0 means ship is Horizontal, Orientation = 1 means ship is Vertical), if sunk gives user a message telling them
        if (!Destroyer2 && StartingPositions.CompDestroyerOrientation[1] == 0 && DrawTargetBoard.enemyIsHit[StartingPositions.CompDestroyerPositionY[1]][StartingPositions.CompDestroyerPositionX[1]] == 1 &&
                DrawTargetBoard.enemyIsHit[(StartingPositions.CompDestroyerPositionY[1])][(StartingPositions.CompDestroyerPositionX[1] + 1)] == 1) {
            int DestroyerSunk2 = JOptionPane.showOptionDialog(null, "You sunk your enemies Destroyer2", "You sunk your enemies Destroyer2!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Destroyer2 = true;
        } else if (!Destroyer2 && StartingPositions.CompDestroyerOrientation[1] == 1 && DrawTargetBoard.enemyIsHit[StartingPositions.CompDestroyerPositionY[1]][StartingPositions.CompDestroyerPositionX[1]] == 1 &&
                DrawTargetBoard.enemyIsHit[(StartingPositions.CompDestroyerPositionY[1] + 1)][(StartingPositions.CompDestroyerPositionX[1])] == 1) {
            int DestroyerSunk2 = JOptionPane.showOptionDialog(null, "You sunk your enemies Destroyer2", "You sunk your enemies Destroyer2!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Destroyer2 = true;
        }

        //Checks if Destroyer3 is sunk or not (Orientation = 0 means ship is Horizontal, Orientation = 1 means ship is Vertical), if sunk gives user a message telling them
        if (!Destroyer3 && StartingPositions.CompDestroyerOrientation[2] == 0 && DrawTargetBoard.enemyIsHit[StartingPositions.CompDestroyerPositionY[2]][StartingPositions.CompDestroyerPositionX[2]] == 1 &&
                DrawTargetBoard.enemyIsHit[(StartingPositions.CompDestroyerPositionY[2])][(StartingPositions.CompDestroyerPositionX[2] + 1)] == 1) {
            int DestroyerSunk3 = JOptionPane.showOptionDialog(null, "You sunk your enemies Destroyer3", "You sunk your enemies Destroyer3!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Destroyer3 = true;
        } else if (!Destroyer3 && StartingPositions.CompDestroyerOrientation[2] == 1 && DrawTargetBoard.enemyIsHit[StartingPositions.CompDestroyerPositionY[2]][StartingPositions.CompDestroyerPositionX[2]] == 1 &&
                DrawTargetBoard.enemyIsHit[(StartingPositions.CompDestroyerPositionY[2] + 1)][(StartingPositions.CompDestroyerPositionX[2])] == 1) {
            int DestroyerSunk3 = JOptionPane.showOptionDialog(null, "You sunk your enemies Destroyer3", "You sunk your enemies Destroyer3!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Destroyer3 = true;
        }

        //Checks if Submarine1 is sunk or not, if sunk gives user a message telling them
        if (!Submarine1 && DrawTargetBoard.enemyIsHit[StartingPositions.CompSubmarinePositionY[0]][StartingPositions.CompSubmarinePositionX[0]] == 1) {
            int SubmarineSunk1 = JOptionPane.showOptionDialog(null, "You sunk your enemies Submarine1", "You sunk your enemies Submarine1!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Submarine1 = true;
        }

        //Checks if Submarine2 is sunk or not, if sunk gives user a message telling them
        if (!Submarine2 && DrawTargetBoard.enemyIsHit[StartingPositions.CompSubmarinePositionY[1]][StartingPositions.CompSubmarinePositionX[1]] == 1) {
            int SubmarineSunk2 = JOptionPane.showOptionDialog(null, "You sunk your enemies Submarine2", "You sunk your enemies Submarine2!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Submarine2 = true;
        }

        //Checks if Submarine3 is sunk or not, if sunk gives user a message telling them
        if (!Submarine3 && DrawTargetBoard.enemyIsHit[StartingPositions.CompSubmarinePositionY[2]][StartingPositions.CompSubmarinePositionX[2]] == 1) {
            int SubmarineSunk3 = JOptionPane.showOptionDialog(null, "You sunk your enemies Submarine3", "You sunk your enemies Submarine3!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Submarine3 = true;
        }

        //Checks if Submarine4 is sunk or not, if sunk gives user a message telling them
        if (!Submarine4 && DrawTargetBoard.enemyIsHit[StartingPositions.CompSubmarinePositionY[3]][StartingPositions.CompSubmarinePositionX[3]] == 1) {
            int SubmarineSunk4 = JOptionPane.showOptionDialog(null, "You sunk your enemies Submarine4", "You sunk your enemies Submarine4!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, okay, okay[0]);
            Submarine4 = true;
        }
    }
}
