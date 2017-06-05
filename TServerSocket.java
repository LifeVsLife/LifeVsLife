
import java.io.*;
import java.net.*;

public class TServerSocket
{
    TList<Socket> clientSockets = new TList<Socket>();

    private TThread accepter;

    public final int port;
    private ServerSocket serverSocket;

    private int timeout = 5; // in ms

    public TServerSocket(int port)
    {
        this.port = port;
        accepter = new TThread(new TaskAcceptClients(this));
    }

    public void open() throws IOException
    {
        serverSocket = new ServerSocket(port);
    }

    public synchronized void close() throws IOException
    {
        Socket[] clientSocketArray = clientSockets.takeArray();
        for (int i = 0; i < clientSocketArray.length; i++)
        {
            clientSocketArray[i].getOutputStream().close();
            clientSocketArray[i].getInputStream().close();
        }
        serverSocket.close();
    }

    public synchronized void accept() throws IOException
    {
        Socket newClientSocket = serverSocket.accept();
        clientSockets.add(newClientSocket);
    }

    public synchronized void startAccepting()
    {
        accepter.startThread();
    }

    public synchronized void stopAccepting()
    {
        accepter.stopThread();
    }

}
