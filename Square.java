package Checkers;

/**
 * Square.java
 * Description: The constructor class for the squares that will make the board map in the game
 *
 * @author Ethan Shama and Nathan Kowal
 * @version 1.0 (Last Updated: Jan 12 2019)
 **/

import java.awt.*;

public class Square {


    public Color colour;
    public int x, y, w;
    public boolean filled;

    public Square(int x, int y, int w, Color colour, boolean filled) {
        /**
         * Square Description: This method gets the colours and the x,y cord and width and if its filled.
         *
         * @param the x cord
         *
         * @param the y cord
         *
         * @param the width
         *
         * @param the colour
         *
         * @param if the square is filled
         *
         **/


        this.x = x;
        this.y = y;
        this.w = w;
        this.colour = colour;
        this.filled = filled;
    }

    public void display(Graphics g) {
        /**
         * display Description: This method displays the squares with the graphics (g)
         * @param graphics
         **/

        g.setColor(colour);
        g.fillRect(x, y, w, w);
    }

}

