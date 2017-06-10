import java.io.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.image.*;
import java.net.URL;

public class ShowImage {

    public ShowImage(String path)
    {
        URL i = this.getClass().getResource("res/"+path);
        BufferedImage img = null;
        try {
            img = ImageIO.read(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        init(new BufferedImage[]{img});

    }

    public ShowImage(BufferedImage img)
    {
        init(new BufferedImage[]{img});
    }

    public ShowImage(BufferedImage[] img)
    {
        init(img);
    }

    public void init(BufferedImage[] img)
    {
        TFrame frame = new TFrame("show image");

        int f = 6;

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
        PaintPanel panel = new PaintPanel() {

            public void paintComponent(Graphics g)
            {
                int x = 0;
                super.paintComponent(g);
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
