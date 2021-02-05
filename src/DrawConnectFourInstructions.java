package ConnectFour;

/**
 * DrawConnectFourInstructions.java
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

public class DrawConnectFourInstructions extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Timer tm = new Timer(5, this);

    public DrawConnectFourInstructions() {
        /**
         * DrawConnectFourInstructions
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
        this.setBackground(Color.darkGray); //background


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
        drawString(g, "How to play connect four: \n\n\n\nTo play connect four, enter the number of the column you wish to drop your piece. The two \n\nplayers, controlling red and blue, will alternate turns. If you enter an invalid column, or a column \n\nthat is already full, the program will ask you to enter a number again. If it is valid, the piece will \n\nfall as far down as possible. Win the game by getting four pieces in a row either horizontall, \n\nvertically, or diagonally. The first player to do this wins! \n\n\n\nGood Luck!", 50, 150);

        //mouse coordinates
        Point p = MouseInfo.getPointerInfo().getLocation();

        //defining mouseX and mouseY
        double mouseX = p.getX() - RunConnectFour.instructionsC.getLocation().x;
        double mouseY = p.getY() - RunConnectFour.instructionsC.getLocation().y - 22;

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

        if (RunConnectFour.instructionsC.isVisible()) {

            RunConnectFour.instructionsC.addMouseListener(new MouseAdapter() {

                //when button is clicked
                public void mouseClicked(MouseEvent e) {

                    if (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
                        //close other windows
                        RunConnectFour.instructionsC.setVisible(false);
                        RunConnectFour.connectFour.setVisible(false);

                        //go back to start screen
                        RunConnectFour.startScreen.setVisible(true);
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
