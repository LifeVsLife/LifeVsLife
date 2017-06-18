
package ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

@SuppressWarnings("serial")
public class TFrame extends JFrame {

    public TFrame()
    {
        super();
        init();
    }

    public TFrame(String title)
    {
        super(title);
        init();
    }

    public void init()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @SuppressWarnings("deprecation")
    public void resize(int sizeX, int sizeY)
    {
        getContentPane().setPreferredSize(new Dimension(sizeX, sizeY));
        pack();
    }

    public static void main(String[] args)
    {
        TFrame t = new TFrame();
        //t.createBufferStrategy(2);
        t.resize(500,500);
        t.pack();
        t.setVisible(true);
        PaintPanel p = new PaintPanel();
        //TPanel p = new TPanel();
        t.add(p);
        //t.add(p);
        t.pack();
        p.last = System.nanoTime();
        while (true)
        {
            //System.out.println("try repaint");
            p.upd();
        }

    }

}
