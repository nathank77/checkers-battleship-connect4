package Checkers;

/**
 * DrawCheckerInstructions.java
 * Description: Draws the UI for the instructions
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

public class DrawCheckerInstructions extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Timer tm = new Timer(5, this);

    public DrawCheckerInstructions() {
        /**
         * DrawCheckerInstructions 
         * Description: empty constructor
         **/
    }

    public void paintComponent(Graphics g) {

        /**
         * paintComponent 
         * Description: The method to actually draw everything initialized above
         *
         * @param the graphics component
         **/

        super.paintComponent(g);
        this.setBackground(Color.darkGray);

        //set font
        Font f1 = new Font("Stellar", Font.PLAIN, 50);
        g.setFont(f1);

        //set colour
        g.setColor(Color.CYAN);
        g.drawString("Instructions", 200, 100); //title

        //set font
        Font f2 = new Font("Stellar", Font.PLAIN, 15);
        g.setFont(f2);

        //instructions
        drawString(g, "How to play checkers: \n\n\n\nThis checkers game is a player vs player game. One player controls red and one controls black. \n\nTo choose the piece you wish to move, enter a coordinate in the format A1. If the coordinates \n\nentered are invalid, or that piece is unable to be moved, the program will ask for the coordinate \n\nagain. Once a valid piece is selected, the program will ask for the square of which you wish to \n\nmove to. If the move is invalid, there will be an invalid move exception, and it will show a pop-up \n\nmessage to the user. If the square is occupied by another piece, there will be a square occupied \n\nexception, and it will show a pop-up message. To win the game, capture all of your opponent's \n\npieces by jumping over them. Once they are all captured, you win the game! \n\n\n\n Good Luck!", 50, 150);

        //mouse coordinates
        Point p = MouseInfo.getPointerInfo().getLocation();

        //defining mouseX and mouseY
        double mouseX = p.getX() - RunCheckers.checkerInstructions.getLocation().x;
        double mouseY = p.getY() - RunCheckers.checkerInstructions.getLocation().y - 22;

        //integers for the button
        int x = 50, y = 625, w = 100, h = 40;

        //set font
        Font f3 = new Font("Stellar", Font.BOLD, 25);
        g.setFont(f3);

        //draw button
        g.drawRect(x, y, w, h);
        g.drawString("Back", x + 25, y + g.getFontMetrics().getHeight());

        //set font
        Font f4 = new Font("Stellar", Font.BOLD, 25);

        //mouse-over button (redraw in blue)
        if (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
            g.setFont(f4);
            g.fillRect(x, y, w, h);
            g.setColor(Color.darkGray);
            g.drawString("Back", x + 25, y + g.getFontMetrics().getHeight());
        }


        if (RunCheckers.checkerInstructions.isVisible()) {


            RunCheckers.checkerInstructions.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {

                    //when button is clicked
                    if (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
                        //close other windows
                        RunCheckers.checkerInstructions.setVisible(false);
                        RunCheckers.checker.setVisible(false);

                        //go back to start screen
                        RunCheckers.startScreen.setVisible(true);
                    }
                }
            });
        }
        tm.start();
    }

    void drawString(Graphics g, String text, int x, int y) {
        /**
         * drawString 
         * Description: Method that splits strings in a drawString at \n (new line character)
         *
         * @param the graphics component
         *
         * @param the string to be drawn
         *
         * @param the x cord
         *
         * @param the y cord
         **/

        //for loop to split the string
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
    }
}
