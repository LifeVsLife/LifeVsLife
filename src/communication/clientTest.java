
package communication;

import java.io.*;
import java.net.*;

public class clientTest
{

    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;

    String ip = "192.168.68.50";
    int port = 4831;

    public clientTest(String ip, int port)
    {
        this.ip = ip;
        this.port = port;
    }

<<<<<<< HEAD
    public clientTest(String address)
    {
        int colon = address.indexOf(":");
        this.ip = address.substring(0, colon);
        this.port = Integer.parseInt(address.substring(colon+1));
        System.out.println();
    }

    public String getServerIp()
    {
        return socket.getLocalAddress().getHostAddress();
=======
    public clientTest()
    {

>>>>>>> ca4fb6382f53b6675928e6daebbd6e4a6be47ac3
    }

    public void send(String s)
    {
        try {
            System.out.println("Trying to send: '"+s+"'...");
            out.writeObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read()
    {
        try {
            System.out.println("Trying to read...");
            String s = (String) in.readObject();
            System.out.println("Read: '"+s+"'");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void open()
    {
        try {
            System.out.println("Creating socket...");
            socket = new Socket(ip, port);
            System.out.println("Creating in...");
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Creating out...");
            out = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Done: open()");
<<<<<<< HEAD
            System.out.println("IP: "+ getServerIp());
=======
>>>>>>> ca4fb6382f53b6675928e6daebbd6e4a6be47ac3
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
