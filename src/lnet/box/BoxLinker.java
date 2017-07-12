
package lnet.box;

import java.io.PipedOutputStream;
import java.io.PipedInputStream;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.io.IOException;

public class BoxLinker
{

    private PipedOutputStream o;
    private PipedInputStream i;

    private ObjectOutputStream a;
    private ObjectInputStream b;


    public BoxLinker()
    {
        try {
            o = new PipedOutputStream();
            i = new PipedInputStream(o);

            a = new ObjectOutputStream(o);
            b = new ObjectInputStream(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OutBox getOutBox()
    {
        return new OutBox(a);
    }

    public InBox getInBox()
    {
        return new InBox(b);
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





    public static void main(String[] args)
    {
        BoxLinker l = new BoxLinker();

        OutBox o = l.getOutBox();
        InBox i = l.getInBox();

        o.write("laMiaMama");
        System.out.println(i.<String>read());
    }

}
