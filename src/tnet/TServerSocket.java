
package tnet;

import java.io.*;
import java.net.*;

import tlist.TList;

/**
 * Has a ServerSocket and manages the connections
 */
public class TServerSocket
{
    /**
     * A {@link tlist.TList} for managing all connections
     */
    public TList<SocketConnection> socketConnections = new TList<SocketConnection>();

    /**
     * The port the serverSocket is going to connect to when {@link #open()} is run
     */
    private int port;

    /**
     * The ServerSocket it uses
     */
    private ServerSocket serverSocket;

    private int selfTimeout = 5; // in ms
    private int conTimeout = 5; // in ms

    public TServerSocket(int port)
    {
        this.port = port;
    }

    public String getServerIp()
    {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns the port the {@link #serverSocket} uses
     *
     * @return The port
     */
    public int getPort()
    {
        return serverSocket.getLocalPort();
    }
    /**
     * Sets the timeout for the {@link #serverSocket} and all streams in {@link #socketConnections}
     *
     * @param int timeout The new Timeout
     */
    public void setSoTimeout(int timeout)
    {
        setSocketSoTimeout(timeout);
        setConnectionsSoTimeout(timeout);
    }

    /**
     * Sets the timeout for the {@link #serverSocket}
     *
     * @param int timeout The new Timeout
     */
    public void setSocketSoTimeout(int timeout)
    {
        this.selfTimeout = timeout;

        if (serverSocket != null) {
            try {
                serverSocket.setSoTimeout(timeout);
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Sets the timeout for all streams in {@link #socketConnections}
     *
     * @param int timeout The new Timeout
     */
    public void setConnectionsSoTimeout(int timeout)
    {
        this.conTimeout = timeout;

        for (SocketConnection c : socketConnections)
        {
            try {
                c.socket.setSoTimeout(timeout);
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Creates the {@link #serverSocket} with the IP and port
     *
     * @throws IOException if e.g. the port is already used
     */
    public void open() throws IOException
    {
        if (serverSocket == null) {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(selfTimeout);
        } else {
            System.out.println("[TServerSocket] open(): Socket was already open. Did nothing.");
        }
    }

    /**
     * Accepts 1 new socket connection, gets the streams, sets timeout and adds it to {@link #socketConnections}
     *
     * @throws IOException
     */
    public void accept() throws IOException
    {
        //System.out.println("Trying to accept...");
        Socket newClientSocket = serverSocket.accept();
        //System.out.println("Creating SocketConnection");
        SocketConnection connection = new SocketConnection(newClientSocket);
        //System.out.println("Setting timeout");
        newClientSocket.setSoTimeout(conTimeout);
        //System.out.println("Adding to TList");
        socketConnections.add(connection);

        System.out.println("[TServerSocket] accept(): new connection");
    }

    /**
     * Accepts all Socket Requests
     *
     * @throws IOException When an error occurs while accepting
     */
    public void acceptAll() throws IOException
    {
        try {
            while (true)
            {
                accept();
            }
        } catch (SocketTimeoutException e) {
            // no connection wants to connect anymore
            //e.printStackTrace();
        }
    }

    /**
     * Closes all Streams and Sockets
     *
     * @throws IOException If error occurs
     */
    public void close() throws IOException
    {
        for (SocketConnection connection : socketConnections)
        {
                connection.close();
        }
        serverSocket.close();
    }

    public static void main(String[] args) throws Exception
    {
        TServerSocket t = new TServerSocket(57273);
        t.open();
        Thread.sleep(1000);
        System.out.println(t.serverSocket.getInetAddress().getHostAddress());
    }

}
