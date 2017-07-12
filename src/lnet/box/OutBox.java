
package lnet.box;

import java.io.ObjectOutputStream;
import java.io.IOException;

public class OutBox
{

    private ObjectOutputStream stream;

    public OutBox(ObjectOutputStream stream)
    {
        this.stream = stream;
    }

    @SuppressWarnings("unchecked")
    public <D> void write(D obj)
    {
        try {
            stream.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
