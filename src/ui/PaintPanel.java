
package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import utils.image.ImageLoader;

import java.awt.image.BufferStrategy;
import java.awt.Canvas;

@SuppressWarnings("serial")
public class PaintPanel extends TPanel {

    //PaintLayer[] layer; // wenn a>b dann liegt layer[a] über layer[b]
    Canvas canvas;


    //upd2
    long last;
    int time;
    int x;
    int i = 0;
    int ns = 0;
    int ys = 0;
    int ms = 0;
    int lastms;
    int lastys;
    int it = 0;

    BufferStrategy bs;

    long m = 0;

    //upd1


    private int max = 5;

    private BufferedImage[] img;
    public int s = 0;

    public int si = 40;
    public int si2 = 40;
    public int si3 = 40;

    private long oneSec = 1000;

    public PaintPanel()
    {
        super();
        init();
    }

    private void init()
    {
        setLayout(null);

        canvas = new Canvas();
        canvas.setBounds(0,0,500,500);
        this.add(canvas);


        img = ImageLoader.loadImageSet("images/ui/", "num", "png");
        //dt = System.nanoTime()/1000;
        last = System.currentTimeMillis();


    }

    public void draw()
    {
        //canvas.setBounds(0,0,getWidth(),getHeight());
        if (canvas.getBufferStrategy() == null) {
            canvas.createBufferStrategy(3);
            return;
        }
        bs = canvas.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();

        g.clearRect(0,0,1000,1000);

        g.drawImage(img[s], x, 0, 64, 64, null);

        g.drawRect(50-(int) (si/2f),100-(int) (si/2f),si,si);
        g.drawRect(50-(int) (si2/2f)+70,100-(int) (si2/2f),si2,si2);
        g.drawRect(50-(int) (si3/2f)+140,100-(int) (si3/2f),si3,si3);

        g.dispose();
        bs.show();
    }

    public float ts(float s)
    {
        if (m == 0) {
            m = System.currentTimeMillis();
            return 0;
        } else {
            return ((System.currentTimeMillis() - m) % (s*1000))/(s*1000);
        }
    }

    public float move(float x)
    {
        return 1.5f * x - 0.25f;
    }

    public void upd()
    {
        //System.out.println("upd");
        long n = System.nanoTime();


        it++;

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
            int delta = 20;
            float duration = 1.3f;
            float ab = 0.2f;
            si = 40 + (int) (math.function.TMath.soft(move(ts(duration))) * delta);
            si2 = 40 + (int) (math.function.TMath.late(move(ts(duration))) * delta);
            si3 = 40 + (int) (ts(duration) * delta);
            System.out.println(si);
            draw();


        }

        if (ms >= 1000) {
            ms -= 1000;
            time++;
            //System.out.println(it);
            it = 0;
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
        super.paintComponent(g);

        //g.drawImage(img[s], x, 0, 64, 64, null);
        //System.out.println("paint");
    }

}
