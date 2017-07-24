
package lnet.box;

import java.io.ObjectInputStream;
import java.io.IOException;

import java.io.InterruptedIOException;

public class InBox
{

    private final ObjectInputStream stream;

    private int timeout = 1;

    int elements = 0;

    InBox(ObjectInputStream stream)
    {
        this.stream = stream;
    }

    @SuppressWarnings("unchecked")
    public <D> D read()
    {
        D obj = null;
        synchronized (this) {
            if (elements > 0) {
                try {
                    obj = (D) stream.readObject();
                    elements--;
                }
                catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return obj;
        }
    }

    @SuppressWarnings("unchecked")
    public <D> D waitRead()
    {
        D obj = null;
        try {
            obj = (D) stream.readObject();
            synchronized (this) {
                elements--;
            }
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
