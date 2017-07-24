
package lnet.box;

import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.IOException;

public class OutBox
{

    private final ObjectOutputStream stream;
    private final InBox in;

    OutBox(ObjectOutputStream stream, InBox in)
    {
        this.stream = stream;
        this.in = in;
    }

    @SuppressWarnings("unchecked")
    public <D> void write(D obj)
    {
        try {
            stream.writeObject(obj);
            stream.flush();
            synchronized (in) {
                in.elements++;
            }
        }
        catch (IOException e) {
            System.out.println("[ERROR] In catch OutBox.write()");
            e.printStackTrace();
        }
    }

}
