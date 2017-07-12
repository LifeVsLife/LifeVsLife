
package lnet.box;

import java.io.ObjectInputStream;
import java.io.IOException;

public class InBox
{

    ObjectInputStream stream;

    public InBox(ObjectInputStream stream)
    {
        this.stream = stream;
    }

    @SuppressWarnings("unchecked")
    public <D> D read()
    {
        D obj = null;
        try {
            obj = (D) stream.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
