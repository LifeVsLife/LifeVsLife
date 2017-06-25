
package tnet;

import java.io.*;
import java.net.*;

import tlist.TListKeyObject;

/**
 * A TSocket is able to connect to a ServerSocket and exchange data
 */
public class TSocket<T> implements TListKeyObject<String>
{
    /**
     * The socket of this client
     */
    private Socket socket;

    /**
     * The client and its streams saved in a SocketConnection
     */
    public SocketConnection clientConnection;

    private String ip = "192.168.68.50";
    private int port = 4831;

    /**
     * A new TSocket with a preexisting Socket
     *
     * @param Socket socket The socket
     */
    public TSocket(Socket socket)
    {
        this.socket = socket;
    }

    /**
     * Saves the ip and port
     *
     * @param String ip The IP the {@link #socket} is going to connect to when {@link #open()} is called
     * @param int port The port the {@link #socket} is going to connect to when {@link #open()} is called
     */
    public TSocket(String ip, int port)
    {
        this.ip = ip;
        this.port = port;
    }

    /**
     * Saves the ip and port
     *
     * @param String address The IP and port from String-Format "192.165.78.34:23422"
     */
    public TSocket(String address)
    {
        int colon = address.indexOf(":");
        this.ip = address.substring(0, colon);
        this.port = Integer.parseInt(address.substring(colon+1));
    }

    /**
     * @return The IP {@link #socket} is connecting to
     */
    public String getServerIp()
    {
        return socket.getInetAddress().getHostAddress();
    }

    /**
     * @return The Ip of this machine
     */
    public String getLocalIp()
    {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return The port {@link #socket} is connecting to
     */
    public int getPort()
    {
        return socket.getLocalPort();
    }

    /**
     * Sets the timeout of the socket
     *
     * @param int timeout The new timeout in ms
     */
    public void setSoTimeout(int timeout)
    {
        try {
            socket.setSoTimeout(timeout);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the {@link #serverSocket} with the IP and port
     *
     * @throws IOException if e.g. the port is already used
     */
    public void open() throws IOException
    {
        if (socket == null) {
            socket = new Socket(ip, port);
            clientConnection = new SocketConnection(socket);
        } else {
            System.out.println("[TClientSocket] open(): Socket was already open. Did nothing.");
        }
    }

    /**
     * Closes all streams and socket
     *
     * @throws IOException If an error occurs
     */
    public void close() throws IOException
    {
        clientConnection.close();
    }

    /**
     * Send an object of type T with {@link SocketConnection#out}
     *
     * @param T obj The object to be sent
     */
    public void send(T obj)
    {
        try {
            System.out.println("Trying to send: '"+obj+"'...");
            clientConnection.out.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads an incoming Object, returns null when no object is able to be read
     *
     * @return The object, null if no object
     * @throws IOException If error while reading object
     */
    @SuppressWarnings("unchecked")
    public T read() throws IOException
    {
        T obj = null;
        try {
            System.out.println("Trying to read...");
            obj = (T) clientConnection.in.readObject();
            System.out.println("Read: '"+obj+"'");
        } catch (SocketTimeoutException e) {
            // no date recieved - return null
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public String key()
    {
        return getLocalIp();
    }

}
