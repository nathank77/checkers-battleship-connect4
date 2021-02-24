package BattleShip;


/**
 * DrawBattleshipInstructions.java
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

public class DrawBattleshipInstructions extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Timer tm = new Timer(5, this);

    public DrawBattleshipInstructions() {
        /**
         * DrawBattleshipInstructions 
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
        drawString(g, "How to play battleship: \n\n\n \nTo choose where you want to place your ships, first choose the orientation (horizontal or \n\nvertical). Then, input the coordinate of the first square of the ship in the format A1. Any \n\nsquare that is invalid for ship placement will cause the program to ask you re-input the \n\ncoordinates. Once all 10 ships are placed, the program will ask for the coordinates of where \n\nyou would like to fire (format A1). Then, the computer will show a red X for a hit on the target \n\nboard, and a grey line if there is a miss. When you sink a ship, the program will display a pop-up \n\nmessage telling you which ship you sunk. In total, there are 20 hits needed per player to win \n\nthe game. The player who wins will be the one who hits all the ships before their opponent. \n\nTry to beat the computer! \n\n\n\nGood Luck!", 50, 150);

        //mouse coordinates
        Point p = MouseInfo.getPointerInfo().getLocation();

        //defining mouseX and mouseY
        double mouseX = p.getX() - RunBattleShip.instructions.getLocation().x;
        double mouseY = p.getY() - RunBattleShip.instructions.getLocation().y - 22;

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

        if (RunBattleShip.instructions.isVisible()) {
            RunBattleShip.instructions.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {

                    //when button is clicked
                    if (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {

                        //close other screens
                        RunBattleShip.instructions.setVisible(false);
                        RunBattleShip.battleship.setVisible(false);
                        RunBattleShip.battleshipTarget.setVisible(false);

                        //go back to start screen
                        RunBattleShip.startScreen.setVisible(true);
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
