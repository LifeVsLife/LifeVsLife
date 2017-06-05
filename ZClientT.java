
import java.io.*;
import java.net.*;

public class ZClientT
{
    public final int port = 4831;
    public final String ip = "192.168.68.50";//"localhost"; //"192.168.68.97"

    ObjectInputStream inStream;

    public ZClientT(String s) throws IOException, ClassNotFoundException
    {
        //try {            
        Socket client = new Socket(ip, port);
        //client.setSoTimeout(10);
        System.out.println("client created");
        // Create the input & output streams to the server
        ObjectOutputStream outStream = new ObjectOutputStream(client.getOutputStream());
        System.out.println("outStream created");
        InputStream inp = client.getInputStream();
        System.out.println("inp recieve");
        inStream = new ObjectInputStream(inp);
        System.out.println("inStream created");
        // Read modify
        // TODO here

        /* Create The Message Object to send */
        //PDummy toSend = new PDummy("Dumm");

        /* Send the Message Object to the server */
        //outStream.writeObject(toSend);

        /* Retrive the Message Object from server */
        ZPDummy gotIn = null;
        //String s;
        //s = (String) inStream.readObject();
        outStream.writeObject(s);

        /* Print out the recived Message */
        System.out.println("recieved Dummy-Name: " + s);

        //read();
    }

    public void read() throws ClassNotFoundException, IOException {
        //while (true) {
        System.out.println(inStream.readObject());
        //}
    }
}
