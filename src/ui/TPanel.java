
package ui;

import javax.swing.JPanel;

import java.awt.Graphics;

@SuppressWarnings("serial")
public class TPanel extends JPanel {

    @Override
    public void repaint()
    {
        super.repaint();
        System.out.println("repaint");
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        System.out.println("paintComponent");
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        System.out.println("paint");
    }

}
