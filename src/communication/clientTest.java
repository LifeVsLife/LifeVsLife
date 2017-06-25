
package communication;

import java.io.*;
import java.net.*;

public class clientTest {

    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;

    String ip = "";
    int port = 0;

    public clientTest(String ip, int port)
    {
        this.ip = ip;
        this.port = port;
    }

    public clientTest()
    {

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
