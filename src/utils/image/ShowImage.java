
package utils.image;

import ui.*;

import java.io.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.image.*;
import java.net.URL;

public class ShowImage {

    public ShowImage(String... path)
    {
        BufferedImage[] img = new BufferedImage[path.length];
        for (int i = 0; i < path.length; i++)
        {
            img[i] = ImageLoader.loadImage(path[i]);
        }
        init(img);
    }

    public ShowImage(BufferedImage... img)
    {
        init(img);
    }

    private void init(final BufferedImage[] img)
    {
        TFrame frame = new TFrame("show image");

        final int f = 6;

        int width = 0;
        int height = 0;

        for (BufferedImage i : img)
        {
            width += i.getWidth() * f;
            int nHeight = i.getHeight();
            if (nHeight * f > height) {
                height = nHeight * f;
            }
        }

        @SuppressWarnings("serial")
        TPanel panel = new TPanel() {

            public void paintComponent(Graphics g)
            {
                int x = 0;
                //super.paintComponent(g);
                //g.drawRect(0,0,128,128);

                for (BufferedImage i : img)
                {
                    g.drawImage(i, x, 0, (i.getWidth() * f), (i.getHeight() * f), null);
                    x += i.getWidth() * f;
                }



                //System.out.println("PATH: "+this.getClassLoader().getResource("res/cells/cell.png"));
            }

        };
        frame.setContentPane(panel);
        panel.setPreferredSize(new Dimension(width, height));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception
    {
        new ShowImage("cells/cell_proto.png");
    }

}
