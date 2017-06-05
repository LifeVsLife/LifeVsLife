
import java.io.*;
import java.net.*;

public class TServerSocket
{
    TList<Socket> sockets = new TList<Socket>();

    private TThread accepter;

    public final int port;
    private ServerSocket socket;

    private int timeout = 5; // in ms

    public TServerSocket(int port)
    {
        this.port = port;
        accepter = new TThread(new TaskAcceptClients(this));
    }

    public void open() throws IOException
    {
        socket = new ServerSocket(port);
    }

    public synchronized void close() throws IOException
    {

    }

    public synchronized void accept() throws IOException
    {
        Socket newConnection = socket.accept();
        sockets.add(newConnection);
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
