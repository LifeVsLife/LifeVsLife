
import java.io.*;
import java.net.*;

public class TServerSocket
{
    public TList<SocketConnection> clientSocketConnections = new TList<SocketConnection>();

    public final int port;
    private ServerSocket serverSocket;

    private int timeout = 5; // in ms

    public TServerSocket(int port)
    {
        this.port = port;
    }

    public void open() throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(timeout);
    }

    public synchronized void close() throws IOException
    {
        SocketConnection[] clientSocketArray = clientSocketConnections.takeArray();
        for (int i = 0; i < clientSocketArray.length; i++)
        {
            clientSocketArray[i].in.close();
            clientSocketArray[i].out.close();
        }
        serverSocket.close();
    }

    public synchronized void accept() throws IOException
    {
        Socket newClientSocket;
        try {
            newClientSocket = serverSocket.accept();
        } catch (Exception e) {
            return;
        }
        clientSocketConnections.add(new SocketConnection(newClientSocket));
        System.out.println("new connection");
    }

}
