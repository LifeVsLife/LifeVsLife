
package tnet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import tlist.TListKey;

/**
 * Has a ServerSocket and manages the connections
 */
public class TServerSocket
{
    /**
     * The ServerSocket of this TServerSocket
     */
    private ServerSocket serverSocket;

    /**
     * The list which stores all the TSockets that connect to this TServerSocket
     */
    public TListKey<TSocketCom, String> clientConnections = new TListKey<TSocketCom, String>();

    /**
     * The port the ServerSocket is going to {@link #open()} to
     */
    private int port = 4831;

    private int timeout = 5; // in ms

    /**
     * Saves the port and runs {@link #open()}
     *
     * @param int port The port the {@link #socket} is going to connect to when {@link #open()} is called
     * @throws IOException if e.g. port is already used
     */
    public TServerSocket(int port) throws IOException
    {
        this.port = port;
        open();
    }

    /**
     * @return The port {@link #socket} is connecting to
     */
    public int getPort()
    {
        return serverSocket.getLocalPort();
    }

    /**
     * Sets the timeout of the socket
     *
     * @param int timeout The new timeout in ms
     */
    public void setSoTimeout(int timeout)
    {
        try {
            serverSocket.setSoTimeout(timeout);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the {@link #serverSocket} with the port
     *
     * @throws IOException if e.g. the port is already used
     */
    private void open() throws IOException
    {
        if (serverSocket == null) {
            serverSocket = new ServerSocket(port);
            setSoTimeout(timeout);
        } else {
            System.out.println("[TClientSocket] open(): Socket was already open. Did nothing.");
        }
    }

    /**
     * Accepts one socket's connection request and adds it to {@link #clientConnections}
     *
     * @throws IOException if an I/O error occurs
     */
    public boolean accept() throws IOException
    {
        try {
            TSocketCom newClient = new TSocketCom(serverSocket.accept());
            clientConnections.add(newClient);
            return true;
        } catch (SocketTimeoutException e) {
            return false;
        }
    }

    /**
     * Accepts all socket's connection requests and adds them all to {@link #clientConnections}
     *
     * @throws IOException if an I/O error occurs
     */
    public void acceptAll() throws IOException
    {
        while (accept()) {
            //
        }
    }

    /**
     * Closes the socket
     *
     * @throws IOException If an error occurs
     */
    public void close() throws IOException
    {
        serverSocket.close(); //also closes socket
    }

    /**
     * Removes a SocketStream with a certain IP
     *
     * @param String ip Closes the socket and streams of this specific IP
     * @throws IOException if an I/O error occurs
     */
    public void close(String ip) throws IOException
    {
        TSocket socket = clientConnections.takeKey(ip);
        if (socket != null)
        {
            socket.close();
        }
    }

    public static void main(String[] args)
    {
        try {
            TServerSocket s = new TServerSocket(4831);
            while (!s.accept()) {

            }
            s.clientConnections.get(0).write("abc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
