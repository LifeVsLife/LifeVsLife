
package ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

// imports for testbutton
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
// end: imports for testbutton

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


        PaintPanel p = new PaintPanel();
        //TPanel p = new TPanel();


        // button for tests

        JButton button1 = new JButton("1");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                p.s++;
                if (p.s == 5) {
                    p.s = 0;
                }
            }
        });
        t.setVisible(true);
        t.add(p);
        t.pack();

        //t.add(button1);


        //t.add(p);
        //t.pack();

        t.resize(500,500);

        p.last = System.nanoTime();
        while (true)
        {
            //System.out.println("try repaint");
            p.upd();
        }
        //p.s=0;


        // end: button for tests

    }

}
