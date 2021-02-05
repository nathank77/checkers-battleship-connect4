package Checkers;

/**
 * DrawGameBoard.java
 * Description: Draws the checkers board and contains the logic for what colour piece to draw in each square
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

    //integers for each type of piece
    public static final int EMPTY = 0, BLACK = 1, RED = 2, RED_KING = 3, BLACK_KING = 4;
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //the board map (pieces)
    public static int boardMap[][] = new int[8][8];
    //the board
    public Square square[][] = new Square[8][8];
    Timer tm = new Timer(5, this);

    public DrawGameBoard() {

        /**
         * DrawGameBoard
         * Description: constructor that will initialize the colours needed for each square and set the pieces
         **/

        int x = 30, y = 30, w = 80;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                //every other square is gray
                if ((i + j) % 2 == 0) {
                    square[i][j] = new Square(x, y, w, Color.gray, false);
                }

                //the other ones are light gray
                else {
                    square[i][j] = new Square(x, y, w, Color.lightGray, false);
                }


                //if it is an even square...
                if (i % 2 == j % 2) {

                    //and the row is less than 3
                    if (i < 3) {
                        boardMap[i][j] = BLACK; //set to black
                    }

                    //and the row is greater than 4
                    else if (i > 4) {
                        boardMap[i][j] = RED; //set to red
                    }

                    //else set empty
                    else {
                        boardMap[i][j] = EMPTY;
                    }
                }

                //else set empty
                else {
                    boardMap[i][j] = EMPTY;
                }

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

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                //display the array of squares
                square[i][j].display(g);

                switch (boardMap[i][j]) {

                    //if empty, do nothing
                    case EMPTY:
                        break;

                    //if black, draw a black piece
                    case BLACK:
                        g.setColor(Color.black);
                        g.fillOval(square[i][j].x + 10, square[i][j].y + 10, square[i][j].w - 20, square[i][j].w - 20);
                        break;

                    //if red, draw a red piece
                    case RED:
                        g.setColor(Color.red);
                        g.fillOval(square[i][j].x + 10, square[i][j].y + 10, square[i][j].w - 20, square[i][j].w - 20);
                        break;

                    //if black king, draw a black piece with a k
                    case BLACK_KING:

                        g.setColor(Color.black);
                        g.fillOval(square[i][j].x + 10, square[i][j].y + 10, square[i][j].w - 20, square[i][j].w - 20);

                        g.setColor(Color.red);
                        Font f1 = new Font("Comic Sans", Font.BOLD, 30);
                        g.setFont(f1);
                        g.drawString("K", square[i][j].x + 30, square[i][j].y + 50);

                        break;

                    //if red king, draw a red piece with a k
                    case RED_KING:
                        g.setColor(Color.red);
                        g.fillOval(square[i][j].x + 10, square[i][j].y + 10, square[i][j].w - 20, square[i][j].w - 20);

                        g.setColor(Color.black);
                        Font f2 = new Font("Comic Sans", Font.BOLD, 30);
                        g.setFont(f2);
                        g.drawString("K", square[i][j].x + 30, square[i][j].y + 50);

                        break;
                }

            }
        }

        //set font
        g.setColor(Color.CYAN);
        Font f3 = new Font("Stellar", Font.PLAIN, 12);
        g.setFont(f3);

        //drawing the letters and numbers that surround the board
        int x = 67;
        g.drawString("A", x, 20);
        g.drawString("B", x + 80, 20);
        g.drawString("C", x + 160, 20);
        g.drawString("D", x + 240, 20);
        g.drawString("E", x + 320, 20);
        g.drawString("F", x + 400, 20);
        g.drawString("G", x + 480, 20);
        g.drawString("H", x + 560, 20);

        g.drawString("A", x, 692);
        g.drawString("B", x + 80, 692);
        g.drawString("C", x + 160, 692);
        g.drawString("D", x + 240, 692);
        g.drawString("E", x + 320, 692);
        g.drawString("F", x + 400, 692);
        g.drawString("G", x + 480, 692);
        g.drawString("H", x + 560, 692);

        int y = 69;
        g.drawString("1", 15, y);
        g.drawString("2", 15, y + 80);
        g.drawString("3", 15, y + 160);
        g.drawString("4", 15, y + 240);
        g.drawString("5", 15, y + 320);
        g.drawString("6", 15, y + 400);
        g.drawString("7", 15, y + 480);
        g.drawString("8", 15, y + 560);

        g.drawString("1", 680, y);
        g.drawString("2", 680, y + 80);
        g.drawString("3", 680, y + 160);
        g.drawString("4", 680, y + 240);
        g.drawString("5", 680, y + 320);
        g.drawString("6", 680, y + 400);
        g.drawString("7", 680, y + 480);
        g.drawString("8", 680, y + 560);

        if (RunCheckers.redWin) {
            g.setColor(Color.CYAN);
            g.fillRect(RunCheckers.checker.getWidth() / 2 - 150, 95, 300, 120);

            g.setColor(Color.darkGray);
            g.fillRect(RunCheckers.checker.getWidth() / 2 - 145, 100, 290, 110);

            g.setColor(Color.CYAN);
            Font f4 = new Font("Stellar", Font.BOLD, 50);
            g.setFont(f4);

            g.drawString("RED WINS", RunCheckers.checker.getWidth() / 2 - 95, 148 + g.getFontMetrics().getHeight() / 2);
        }

        if (RunCheckers.blackWin) {
            g.setColor(Color.CYAN);
            g.fillRect(RunCheckers.checker.getWidth() / 2 - 150, 95, 300, 120);

            g.setColor(Color.darkGray);
            g.fillRect(RunCheckers.checker.getWidth() / 2 - 145, 100, 290, 110);

            g.setColor(Color.CYAN);
            Font f4 = new Font("Stellar", Font.BOLD, 50);
            g.setFont(f4);

            g.drawString("BLACK WINS", RunCheckers.checker.getWidth() / 2 - 120, 148 + g.getFontMetrics().getHeight() / 2);
        }

        //close button
        if (RunCheckers.blackWin || RunCheckers.redWin) {

            //mouse coordinates
            Point p = MouseInfo.getPointerInfo().getLocation();

            //defining mouseX and mouseY
            double mouseX = p.getX() - RunCheckers.checker.getLocation().x;
            double mouseY = p.getY() - RunCheckers.checker.getLocation().y - 22;

            //integers for the button
            int xButton = RunCheckers.checker.getWidth() / 2 - 50, yButton = 250, w = 100, h = 40;

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

            RunCheckers.checker.addMouseListener(new MouseAdapter() {

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
