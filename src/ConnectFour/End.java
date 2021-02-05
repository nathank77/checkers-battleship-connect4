package ConnectFour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class End extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    Timer tm = new Timer(5, this);

    String player;

    public End(String player) {
        this.player = player;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.darkGray);

        g.setColor(Color.CYAN);
        Font f3 = new Font("Stellar", Font.BOLD, 50);
        g.setFont(f3);

        g.drawString(player.toUpperCase() + " WINS", 200, 200);

        tm.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
        repaint();
    }

}