
package lnet.box;

import java.io.PipedOutputStream;
import java.io.PipedInputStream;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.io.IOException;

public class BoxLink
{

    private PipedOutputStream o;
    private PipedInputStream i;

    protected ObjectOutputStream a;
    private ObjectInputStream b;

    private OutBox outBox;
    private InBox inBox;

    public BoxLink()
    {


        try {
            o = new PipedOutputStream();
            i = new PipedInputStream(o);

            a = new ObjectOutputStream(o);
            b = new ObjectInputStream(i);


            outBox = new OutBox(a, i, o);
            inBox = new InBox(b);
        }
        catch (IOException e) {
            System.out.println("[ERROR] While creating a BoxLink");
            e.printStackTrace();
        }
    }

    public OutBox getOutBox()
    {
        return outBox;
    }

    public InBox getInBox()
    {
        return inBox;
    }

    public void close()
    {
        try {
            o.close();
            i.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws Exception
    {
        BoxLink l = new BoxLink();

        OutBox o = l.getOutBox();
        InBox i = l.getInBox();

        System.out.println(l.b.available());

        o.write("mia mama");

        System.out.println(i.<String>read());


        Thread.sleep(100);
        // System.out.println(l.b.available());
        // Thread t = new Thread(() -> {
        //     System.out.println("Wiiii");
        //     System.out.println(i.<String>read());
        //     System.out.println("Wiiii");
        // });
        // t.start();
        // System.out.println(l.b.available());
        //while (true) {}
    }

}
