
package communication;

import java.io.*;
import java.net.*;

import tlist.TList;

public class TServerSocket
{
    public TList<SocketConnection> socketConnections = new TList<SocketConnection>();

    public int port;

    private ServerSocket serverSocket;

    private int timeout = 5; // in ms


    public TServerSocket()
    {

    }

    public TServerSocket(int port)
    {
        this.port = port;
    }

    public synchronized void setTimeout(int timeout)
    {
        this.timeout = timeout;
        try {
            serverSocket.setSoTimeout(timeout);
        } catch (SocketException e) {

        }

    }

    public void open() throws IOException
    {
        open(port);
    }

    public void open(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(timeout);
    }

    public synchronized void close() throws IOException
    {
        for (SocketConnection connection : socketConnections)
        {
                connection.in.close();
                connection.out.close();
        }
        serverSocket.close();
    }

    public synchronized void accept() throws IOException
    {
        try {
            Socket newClientSocket = serverSocket.accept();
            newClientSocket.setSoTimeout(timeout);
            socketConnections.add(new SocketConnection(newClientSocket));
            System.out.println("new connection");
            
            testServer.connections++; // debug
        } catch (IOException e) {

        }
    }

}
