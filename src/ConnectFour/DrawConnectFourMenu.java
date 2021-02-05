package ConnectFour;

/**
 * DrawConnectFourMenu.java
 * Description: Draws the UI for the menu
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

public class DrawConnectFourMenu extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static boolean alreadyExecuted = false;
    Timer tm = new Timer(5, this);

    public DrawConnectFourMenu() {
        /**
         * DrawConnectFourMenu
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

        tm.start();

        super.paintComponent(g);
        this.setBackground(Color.darkGray); //background

        //set font
        Font f1 = new Font("Stellar", Font.PLAIN, 50);
        g.setFont(f1);

        //set colour
        g.setColor(Color.CYAN);
        g.drawString("Starting Menu", 50, 100); //title

        //mouse coordinates
        Point p = MouseInfo.getPointerInfo().getLocation();

        //defining mouseX and mouseY
        double mouseX = p.getX() - RunConnectFour.startScreen.getLocation().x;
        double mouseY = p.getY() - RunConnectFour.startScreen.getLocation().y - 22;

        //integers for the buttons
        int x = 120, y = 150, w = 150, h = 40;
        int x2 = 108, y2 = 225, w2 = 175, h2 = 40;
        int x3 = 145, y3 = 300, w3 = 100, h3 = 40;

        //set font
        Font f3 = new Font("Stellar", Font.BOLD, 25);
        g.setFont(f3);

        //draw button 1
        g.drawRect(x, y, w, h);
        g.drawString("Start Game", x + 20, y + g.getFontMetrics().getHeight());

        //draw button 2
        g.drawRect(x2, y2, w2, h2);
        g.drawString("Instructions", x2 + 25, y2 + g.getFontMetrics().getHeight());

        //draw button 3
        g.drawRect(x3, y3, w3, h3);
        g.drawString("Close", x3 + 20, y3 + g.getFontMetrics().getHeight());

        //set font
        Font f4 = new Font("Stellar", Font.BOLD, 25);

        //mouse-over button 1 (redraw in blue)
        if (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
            g.setFont(f4);
            g.fillRect(x, y, w, h);
            g.setColor(Color.darkGray);
            g.drawString("Start Game", x + 20, y + g.getFontMetrics().getHeight());
        }

        //mouse-over button 2 (redraw in blue)
        if (mouseX >= x2 && mouseX <= x2 + w2 && mouseY >= y2 && mouseY <= y2 + h2) {
            g.setFont(f4);
            g.fillRect(x2, y2, w2, h2);
            g.setColor(Color.darkGray);
            g.drawString("Instructions", x2 + 25, y2 + g.getFontMetrics().getHeight());
        }

        //mouse-over button 3 (redraw in blue)
        if (mouseX >= x3 && mouseX <= x3 + w3 && mouseY >= y3 && mouseY <= y3 + h3) {
            g.setFont(f4);
            g.fillRect(x3, y3, w3, h3);
            g.setColor(Color.darkGray);
            g.drawString("Close", x3 + 20, y3 + g.getFontMetrics().getHeight());
        }

        if (RunConnectFour.startScreen.isVisible()) {

            RunConnectFour.startScreen.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {

                    //when button 1 is clicked
                    if (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
                        //opens game screen
                        RunConnectFour.connectFour.setVisible(true);

                        //closes everything else
                        RunConnectFour.startScreen.setVisible(false);
                        RunConnectFour.instructionsC.setVisible(false);

                        //makes sure game only runs once
                        if (!alreadyExecuted) {
                            RunConnectFour.runGame();
                            alreadyExecuted = true;
                        }
                    } else if (mouseX >= x2 && mouseX <= x2 + w2 && mouseY >= y2 && mouseY <= y2 + h2) {
                        //opens instructions
                        RunConnectFour.instructionsC.setVisible(true);

                        //closes all else
                        RunConnectFour.connectFour.setVisible(false);
                        RunConnectFour.startScreen.setVisible(false);

                    } else if (mouseX >= x3 && mouseX <= x3 + w3 && mouseY >= y3 && mouseY <= y3 + h3) {
                        System.exit(0);
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
