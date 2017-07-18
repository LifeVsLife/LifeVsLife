
package lnet.box;

import java.io.ObjectInputStream;
import java.io.IOException;

import java.io.InterruptedIOException;

public class InBox
{

    private final ObjectInputStream stream;

    private int timeout = 1;

    InBox(ObjectInputStream stream)
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

        // -------

        // try {
        //     System.out.println(stream.available());
        // }
        // catch (IOException e) {
        //     e.printStackTrace();
        // }
        //
        // return null;

        // -------
        // synchronized (stream) {
        //     InBoxReadThread read = new InBoxReadThread(stream);
        //     Thread thread = new Thread(read);
        //     thread.start();
        //
        //     try {
        //         Thread.sleep(5);
        //     }
        //     catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        //     synchronized (read) {
        //         thread.interrupt();
        //         try {
        //             thread.join();
        //         }
        //         catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //     }
        //     return (D) read.getRead();
        // }
    }

}
