
package tnet;

import java.io.*;
import java.net.*;

/**
 * A Class to save a socket with its ObjectStreams
 */
public class SocketConnection
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
    public SocketConnection(Socket socket) throws IOException
    {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream()); // out always before in - otherwise: stuck
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
