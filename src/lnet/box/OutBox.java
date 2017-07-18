
package lnet.box;

import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.IOException;

public class OutBox
{

    private final ObjectOutputStream stream;
    private final PipedInputStream in;
    private final PipedOutputStream master;

    OutBox(ObjectOutputStream stream, PipedInputStream in, PipedOutputStream master)
    {
        this.stream = stream;
        this.in = in;
        this.master = master;
    }

    @SuppressWarnings("unchecked")
    public <D> void write(D obj)
    {
            try {
                stream.writeObject(obj);
                stream.flush();
            }
            catch (IOException e) {
                System.out.println("[ERROR] in catch OutBox.write()");
                e.printStackTrace();
            }
    }

}
