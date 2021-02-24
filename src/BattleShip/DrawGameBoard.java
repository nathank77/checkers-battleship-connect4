package BattleShip;

/**
 * DrawGameBoard.java
 * Description: Draws the battleship board and contains the logic for what to draw in each square
 *
 * @author Ethan Shama and Nathan Kowal
 * @version 1.0 (Last Updated: Jan 12 2019)
 **/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawGameBoard extends JPanel implements ActionListener {

    //integers for each possible state
    public static final int EMPTY = 0, SHIP = 1, SHOT = 1;
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //the board map (ships)
    public static int boardMap[][] = new int[10][10];

    //the board map (shots)
    public static int IsHit[][] = new int[10][10];
    //the board
    public Square square[][] = new Square[10][10];
    Timer tm = new Timer(5, this);

    public DrawGameBoard() {

        /**
         * DrawGameBoard 
         * Description: constructor that will initialize the board and set the colour
         **/

        int x = 30, y = 30, w = 50;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                //all squares are cyan
                square[i][j] = new Square(x, y, w, Color.CYAN, Color.black, false);

                //increase x by width of square
                x += w;
            }

            //reset x at the end of the row, and increase y by width of square
            x = 30;
            y += w;
        }
    }

    public void paintComponent(Graphics g) {

        /**
         * paintComponent 
         * Description: The method to actually draw everything initialized above
         *
         * @param the graphics component
         **/

        super.paintComponent(g);
        this.setBackground(Color.darkGray); //background colour

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                //display the array of squares
                square[i][j].display(g);

                switch (boardMap[i][j]) {

                    //if empty and shot, draw a gray line
                    case EMPTY:
                        if (boardMap[i][j] == EMPTY && IsHit[i][j] == SHOT) {
                            g.setColor(Color.LIGHT_GRAY);
                            Font f1 = new Font("Comic Sans", Font.BOLD, 60);
                            g.setFont(f1);
                            g.drawString("/", square[i][j].x + 5, square[i][j].y + 47);
                        }
                        break;

                    //if it is a ship, draw the ship
                    case SHIP:
                        g.setColor(Color.darkGray);
                        g.fillRect(square[i][j].x + 5, square[i][j].y + 5, 40, 40);

                        //if it is hit, draw the red dot in the middle
                        if (IsHit[i][j] == SHOT) {
                            g.setColor(Color.red);
                        } else {
                            g.setColor(Color.WHITE);
                        }
                        g.fillOval(square[i][j].x + 17, square[i][j].y + 17, 15, 15);
                        break;
                }
            }
        }

        //set colour and font
        g.setColor(Color.CYAN);
        Font f3 = new Font("Stellar", Font.PLAIN, 12);
        g.setFont(f3);

        //drawing the letters and numbers that surround the board
        int x = 52;
        g.drawString("A", x, 20);
        g.drawString("B", x + 52, 20);
        g.drawString("C", x + 102, 20);
        g.drawString("D", x + 152, 20);
        g.drawString("E", x + 202, 20);
        g.drawString("F", x + 252, 20);
        g.drawString("G", x + 302, 20);
        g.drawString("H", x + 352, 20);
        g.drawString("I", x + 402, 20);
        g.drawString("J", x + 453, 20);

        g.drawString("A", x, 552);
        g.drawString("B", x + 52, 552);
        g.drawString("C", x + 102, 552);
        g.drawString("D", x + 152, 552);
        g.drawString("E", x + 202, 552);
        g.drawString("F", x + 252, 552);
        g.drawString("G", x + 302, 552);
        g.drawString("H", x + 352, 552);
        g.drawString("I", x + 402, 552);
        g.drawString("J", x + 453, 552);

        int y = 60;
        g.drawString("1", 15, y);
        g.drawString("2", 15, y + 50);
        g.drawString("3", 15, y + 100);
        g.drawString("4", 15, y + 150);
        g.drawString("5", 15, y + 200);
        g.drawString("6", 15, y + 250);
        g.drawString("7", 15, y + 300);
        g.drawString("8", 15, y + 350);
        g.drawString("9", 15, y + 400);
        g.drawString("10", 8, y + 450);

        g.drawString("1", 540, y);
        g.drawString("2", 540, y + 50);
        g.drawString("3", 540, y + 100);
        g.drawString("4", 540, y + 150);
        g.drawString("5", 540, y + 200);
        g.drawString("6", 540, y + 250);
        g.drawString("7", 540, y + 300);
        g.drawString("8", 540, y + 350);
        g.drawString("9", 540, y + 400);
        g.drawString("10", 540, y + 450);

        if (StartingPositions.playerDone) {
            g.setColor(Color.BLUE);

            //battleship rect
            switch (StartingPositions.BattleShipOrientation) {

                case -1:
                    break;

                case 1:
                    //battleship vrt
                    g.drawRect(square[StartingPositions.BattleShipPositionY][StartingPositions.BattleShipPositionX].x + 5, square[StartingPositions.BattleShipPositionY][StartingPositions.BattleShipPositionX].y + 5, 40, 190);
                    break;

                case 0:
                    //battleship hor
                    g.drawRect(square[StartingPositions.BattleShipPositionY][StartingPositions.BattleShipPositionX].x + 5, square[StartingPositions.BattleShipPositionY][StartingPositions.BattleShipPositionX].y + 5, 190, 40);
                    break;

            }

            //Cruiser 1 rect
            switch (StartingPositions.CruiserOrientation[0]) {

                case -1:
                    break;

                case 1:
                    //Cruiser 1 vrt
                    g.drawRect(square[StartingPositions.CruiserPositionY[0]][StartingPositions.CruiserPositionX[0]].x + 5, square[StartingPositions.CruiserPositionY[0]][StartingPositions.CruiserPositionX[0]].y + 5, 40, 140);
                    break;

                case 0:
                    //Cruiser 1 hor
                    g.drawRect(square[StartingPositions.CruiserPositionY[0]][StartingPositions.CruiserPositionX[0]].x + 5, square[StartingPositions.CruiserPositionY[0]][StartingPositions.CruiserPositionX[0]].y + 5, 140, 40);
                    break;

            }

            //Cruiser 2 rect
            switch (StartingPositions.CruiserOrientation[1]) {

                case -1:
                    break;

                case 1:
                    //Cruiser 2 vrt
                    g.drawRect(square[StartingPositions.CruiserPositionY[1]][StartingPositions.CruiserPositionX[1]].x + 5, square[StartingPositions.CruiserPositionY[1]][StartingPositions.CruiserPositionX[1]].y + 5, 40, 140);
                    break;

                case 0:
                    //Cruiser 2 hor
                    g.drawRect(square[StartingPositions.CruiserPositionY[1]][StartingPositions.CruiserPositionX[1]].x + 5, square[StartingPositions.CruiserPositionY[1]][StartingPositions.CruiserPositionX[1]].y + 5, 140, 40);
                    break;
            }

            //Destroyer 1 rect
            switch (StartingPositions.DestroyerOrientation[0]) {

                case -1:
                    break;

                case 1:
                    //Destroyer 1 vrt
                    g.drawRect(square[StartingPositions.DestroyerPositionY[0]][StartingPositions.DestroyerPositionX[0]].x + 5, square[StartingPositions.DestroyerPositionY[0]][StartingPositions.DestroyerPositionX[0]].y + 5, 40, 90);
                    break;

                case 0:
                    //Destroyer 1 hor
                    g.drawRect(square[StartingPositions.DestroyerPositionY[0]][StartingPositions.DestroyerPositionX[0]].x + 5, square[StartingPositions.DestroyerPositionY[0]][StartingPositions.DestroyerPositionX[0]].y + 5, 90, 40);
                    break;
            }

            //Destroyer 2 rect
            switch (StartingPositions.DestroyerOrientation[1]) {

                case -1:
                    break;

                case 1:
                    //Destroyer 2 vrt
                    g.drawRect(square[StartingPositions.DestroyerPositionY[1]][StartingPositions.DestroyerPositionX[1]].x + 5, square[StartingPositions.DestroyerPositionY[1]][StartingPositions.DestroyerPositionX[1]].y + 5, 40, 90);
                    break;

                case 0:
                    //Destroyer 2 hor
                    g.drawRect(square[StartingPositions.DestroyerPositionY[1]][StartingPositions.DestroyerPositionX[1]].x + 5, square[StartingPositions.DestroyerPositionY[1]][StartingPositions.DestroyerPositionX[1]].y + 5, 90, 40);
                    break;
            }

            //Destroyer 3 rect
            switch (StartingPositions.DestroyerOrientation[2]) {

                case -1:
                    break;

                case 1:
                    //Destroyer 3 vrt
                    g.drawRect(square[StartingPositions.DestroyerPositionY[2]][StartingPositions.DestroyerPositionX[2]].x + 5, square[StartingPositions.DestroyerPositionY[2]][StartingPositions.DestroyerPositionX[2]].y + 5, 40, 90);
                    break;

                case 0:
                    //Destroyer 3 hor
                    g.drawRect(square[StartingPositions.DestroyerPositionY[2]][StartingPositions.DestroyerPositionX[2]].x + 5, square[StartingPositions.DestroyerPositionY[2]][StartingPositions.DestroyerPositionX[2]].y + 5, 90, 40);
                    break;
            }

            //Submarine 1 rect
            switch (StartingPositions.SubmarineOrientation) {

                case -1:
                    break;

                case 1:
                    //Submarine 1 vrt
                    g.drawRect(square[StartingPositions.SubmarinePositionY[0]][StartingPositions.SubmarinePositionX[0]].x + 5, square[StartingPositions.SubmarinePositionY[0]][StartingPositions.SubmarinePositionX[0]].y + 5, 40, 40);
                    break;

                case 0:
                    //Submarine 1 hor
                    g.drawRect(square[StartingPositions.SubmarinePositionY[0]][StartingPositions.SubmarinePositionX[0]].x + 5, square[StartingPositions.SubmarinePositionY[0]][StartingPositions.SubmarinePositionX[0]].y + 5, 40, 40);
                    break;
            }

            //Submarine 2 rect
            switch (StartingPositions.SubmarineOrientation) {

                case -1:
                    break;

                case 1:
                    //Submarine 2 vrt
                    g.drawRect(square[StartingPositions.SubmarinePositionY[1]][StartingPositions.SubmarinePositionX[1]].x + 5, square[StartingPositions.SubmarinePositionY[1]][StartingPositions.SubmarinePositionX[1]].y + 5, 40, 40);
                    break;

                case 0:
                    //Submarine 2 hor
                    g.drawRect(square[StartingPositions.SubmarinePositionY[1]][StartingPositions.SubmarinePositionX[1]].x + 5, square[StartingPositions.SubmarinePositionY[1]][StartingPositions.SubmarinePositionX[1]].y + 5, 40, 40);
                    break;
            }

            //Submarine 3 rect
            switch (StartingPositions.SubmarineOrientation) {

                case -1:
                    break;

                case 1:
                    //Submarine 3 vrt
                    g.drawRect(square[StartingPositions.SubmarinePositionY[2]][StartingPositions.SubmarinePositionX[2]].x + 5, square[StartingPositions.SubmarinePositionY[2]][StartingPositions.SubmarinePositionX[2]].y + 5, 40, 40);
                    break;

                case 0:
                    //Submarine 3 hor
                    g.drawRect(square[StartingPositions.SubmarinePositionY[2]][StartingPositions.SubmarinePositionX[2]].x + 5, square[StartingPositions.SubmarinePositionY[2]][StartingPositions.SubmarinePositionX[2]].y + 5, 40, 40);
                    break;
            }

            //Submarine 4 rect
            switch (StartingPositions.SubmarineOrientation) {

                case -1:
                    break;

                case 1:
                    //Submarine 4 vrt
                    g.drawRect(square[StartingPositions.SubmarinePositionY[3]][StartingPositions.SubmarinePositionX[3]].x + 5, square[StartingPositions.SubmarinePositionY[3]][StartingPositions.SubmarinePositionX[3]].y + 5, 40, 40);
                    break;

                case 0:
                    //Submarine 4 hor
                    g.drawRect(square[StartingPositions.SubmarinePositionY[3]][StartingPositions.SubmarinePositionX[3]].x + 5, square[StartingPositions.SubmarinePositionY[3]][StartingPositions.SubmarinePositionX[3]].y + 5, 40, 40);
                    break;
            }
        }

        //player wins
        if (RunBattleShip.playerWin) {
            g.setColor(Color.darkGray);
            g.fillRect(RunBattleShip.battleship.getWidth() / 2 - 145, 100, 290, 110);

            g.setColor(Color.CYAN);
            Font f4 = new Font("Stellar", Font.BOLD, 50);
            g.setFont(f4);

            g.drawString("PLAYER WINS", RunBattleShip.battleship.getWidth() / 2 - 130, 148 + g.getFontMetrics().getHeight() / 2);
        }

        //computer wins
        if (RunBattleShip.compWin) {
            g.setColor(Color.darkGray);
            g.fillRect(RunBattleShip.battleship.getWidth() / 2 - 175, 100, 350, 110);

            g.setColor(Color.CYAN);
            Font f5 = new Font("Stellar", Font.BOLD, 50);
            g.setFont(f5);

            g.drawString("COMPUTER WINS", RunBattleShip.battleship.getWidth() / 2 - 165, 148 + g.getFontMetrics().getHeight() / 2);
        }

        //close button
        if (RunBattleShip.playerWin || RunBattleShip.compWin) {

            //mouse coordinates
            Point p = MouseInfo.getPointerInfo().getLocation();

            //defining mouseX and mouseY
            double mouseX = p.getX() - RunBattleShip.battleship.getLocation().x;
            double mouseY = p.getY() - RunBattleShip.battleship.getLocation().y - 22;

            //integers for the button
            int xButton = RunBattleShip.battleship.getWidth() / 2 - 50, yButton = 250, w = 100, h = 40;

            //set font
            Font f6 = new Font("Stellar", Font.BOLD, 25);
            g.setFont(f6);

            //draw button
            g.setColor(Color.darkGray);
            g.fillRect(xButton, yButton, w, h);

            g.setColor(Color.CYAN);
            g.drawString("Close", xButton + 20, yButton + g.getFontMetrics().getHeight());

            //mouse-over button (redraw with shadow)
            if (mouseX >= xButton && mouseX <= xButton + w && mouseY >= yButton && mouseY <= yButton + h) {

                g.setColor(Color.CYAN);
                g.drawRect(xButton + 2, yButton + 2, w - 4, h - 4);
            }

            RunBattleShip.battleship.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {

                    //when button is clicked
                    if (mouseX >= xButton && mouseX <= xButton + w && mouseY >= yButton && mouseY <= yButton + h) {
                        System.exit(0);
                    }
                }
            });
        }
        tm.start();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
    }

}
