
package tnet;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * A Class to save a socket with its ObjectStreams
 */
public class SocketStreams
{
    /**
     * The socket itself
     */
    public Socket socket;

    /**
     * The ObjectInputStream
     */
    public ObjectInputStream in;

    /**
     * The ObjectOutputStream
     */
    public ObjectOutputStream out;

    /**
     * Constructor which takes a Socket and saves the ObjectStreams
     *
     * @param Socket the new Socket
     * @throws IOException is thrown when an error happens while getting and creating the streams
     */
    public SocketStreams(Socket socket) throws IOException
    {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream()); //out always before in - otherwise gets stuck while creating ObjectInputStream
        in = new ObjectInputStream(socket.getInputStream());
    }

    /**
     * Closes all streams and the socket
     */
    public void close()
    {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
