
package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import utils.image.ImageLoader;

@SuppressWarnings("serial")
public class PaintPanel extends TPanel {

    //PaintLayer[] layer; // wenn a>b dann liegt layer[a] über layer[b]


    //upd2
    long last;
    int time;
    int x;
    int i = 0;
    int ns = 0;
    int ys = 0;
    int ms = 0;
    int lastms;

    //upd1


    private int max = 5;

    private BufferedImage[] img;
    public int s = 0;

    private long oneSec = 1000;

    public PaintPanel()
    {
        super();
        init();
    }

    public void init()
    {
        img = ImageLoader.loadImageSet("pics/ui/", "num", "png");
        //dt = System.nanoTime()/1000;
        last = System.currentTimeMillis();
        //createBufferStrategy(2);
    }

    public void upd()
    {
        //System.out.println("upd");
        long n = System.nanoTime();

        if (n - last >= 1000) {
            last += 1000;
            //time++;
            ys++;

        }

        if (ys >= 1000) {
            ys -= 1000;
            ms++;

        }

        if (ms % 10 == 0 && ms != lastms && ms != 0) {
            lastms = ms;
            x++;
            repaint();
        }

        if (ms >= 1000) {
            ms -= 1000;
            time++;
            //repaint();

            //System.out.println(x);
        }

        //System.out.println(time);
        //System.out.println(time);


        /*System.out.println("X "+x);
        System.out.println("Time (s) "+time);
        System.out.println("NS "+ns);
*/
        s = time % max;

    }

    public void paintComponent(Graphics g)
    {


        g.drawImage(img[s], x, 0, 64, 64, null);
        //System.out.println("paint");
    }

}
