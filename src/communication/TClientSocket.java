
package communication;

import java.io.*;
import java.net.*;

public class TClientSocket {

    private SocketConnection serverSocketConnection;

    public String ip;
    public int port;

    private Socket clientSocket;

    private SocketConnection socketConnection;

    private int timeout = 5; // in ms

    public TClientSocket()
    {

    }

    public TClientSocket(String ip, int port)
    {
        this.ip = ip;
        this.port = port;
    }

    public synchronized void setTimeout(int timeout)
    {
        this.timeout = timeout;
        try {
            clientSocket.setSoTimeout(timeout);
        } catch (SocketException e) {

        }

    }

    public void connect() throws IOException
    {
        connect(ip, port);
    }

    public void connect(String ip, int port) throws IOException
    {
        this.ip = ip;
        this.port = port;

        Socket clientSocket = new Socket(ip, port);
        clientSocket.setSoTimeout(timeout);
        socketConnection = new SocketConnection(clientSocket);
    }

    public synchronized void close() throws IOException
    {
        socketConnection.close();
    }

}
