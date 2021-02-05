package ConnectFour;


/**
 * DrawGameBoard.java
 * Description: Draws the game board
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
    public static final int EMPTY = 0, RED = 1, BLUE = 2;
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //the board map (pieces)
    public static int boardMap[][] = new int[6][7];
    //the board
    public Square square[][] = new Square[6][7];
    Timer tm = new Timer(5, this);

    public DrawGameBoard() {

        /**
         * DrawGameBoard
         * Description: constructor that will initialize the colours needed for each square and set the pieces
         **/

        int x = 30, y = 30, w = 80;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {

                //every square is gray
                square[i][j] = new Square(x, y, w, Color.LIGHT_GRAY, false);

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

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {

                //display the array of squares
                square[i][j].display(g);

                switch (boardMap[i][j]) {

                    //if empty, draw a white circle
                    case EMPTY:
                        g.setColor(Color.white);
                        g.fillOval(square[i][j].x + 10, square[i][j].y + 10, square[i][j].w - 20, square[i][j].w - 20);
                        break;

                    //if red, draw a red piece
                    case RED:
                        g.setColor(Color.red);
                        g.fillOval(square[i][j].x + 10, square[i][j].y + 10, square[i][j].w - 20, square[i][j].w - 20);
                        break;

                    //if blue, draw a blue piece
                    case BLUE:
                        g.setColor(Color.blue);
                        g.fillOval(square[i][j].x + 10, square[i][j].y + 10, square[i][j].w - 20, square[i][j].w - 20);
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
        g.drawString("1", x, 20);
        g.drawString("2", x + 80, 20);
        g.drawString("3", x + 160, 20);
        g.drawString("4", x + 240, 20);
        g.drawString("5", x + 320, 20);
        g.drawString("6", x + 400, 20);
        g.drawString("7", x + 480, 20);

        g.drawString("1", x, 530);
        g.drawString("2", x + 80, 530);
        g.drawString("3", x + 160, 530);
        g.drawString("4", x + 240, 530);
        g.drawString("5", x + 320, 530);
        g.drawString("6", x + 400, 530);
        g.drawString("7", x + 480, 530);


        //if red wins
        if (RunConnectFour.RedWins) {
            g.setColor(Color.CYAN);
            g.fillRect(RunConnectFour.connectFour.getWidth() / 2 - 130, 95, 260, 120);

            g.setColor(Color.darkGray);
            g.fillRect(RunConnectFour.connectFour.getWidth() / 2 - 125, 100, 250, 110);

            g.setColor(Color.CYAN);
            Font f4 = new Font("Stellar", Font.BOLD, 50);
            g.setFont(f4);

            g.drawString("RED WINS", RunConnectFour.connectFour.getWidth() / 2 - 95, 148 + g.getFontMetrics().getHeight() / 2);
        }

        //if blue wins
        if (RunConnectFour.BlueWins) {
            g.setColor(Color.CYAN);
            g.fillRect(RunConnectFour.connectFour.getWidth() / 2 - 130, 95, 260, 120);

            g.setColor(Color.darkGray);
            g.fillRect(RunConnectFour.connectFour.getWidth() / 2 - 125, 100, 250, 110);

            g.setColor(Color.CYAN);
            Font f4 = new Font("Stellar", Font.BOLD, 50);
            g.setFont(f4);

            g.drawString("BLUE WINS", RunConnectFour.connectFour.getWidth() / 2 - 105, 148 + g.getFontMetrics().getHeight() / 2);
        }

        //close button
        if (RunConnectFour.BlueWins || RunConnectFour.RedWins) {

            //mouse coordinates
            Point p = MouseInfo.getPointerInfo().getLocation();

            //defining mouseX and mouseY
            double mouseX = p.getX() - RunConnectFour.connectFour.getLocation().x;
            double mouseY = p.getY() - RunConnectFour.connectFour.getLocation().y - 22;

            //integers for the button
            int xButton = RunConnectFour.connectFour.getWidth() / 2 - 50, yButton = 250, w = 100, h = 40;

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

            RunConnectFour.connectFour.addMouseListener(new MouseAdapter() {

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
