
package ui;

import javax.swing.JPanel;

import java.awt.Graphics;

import java.awt.Color;

@SuppressWarnings("serial")
public class TPanel extends JPanel {

    public TPanel()
    {
        super();
    }

    @Override
    public void repaint()
    {
        super.repaint();
        //System.out.println("repaint");
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //System.out.println("paintComponent");
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        //System.out.println(getHeight());
        //System.out.println("paint");
    }

}
