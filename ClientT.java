import java.io.*;
import java.net.*;

public class ClientT
{
    public final int port = 4445;
    public ClientT() throws IOException, ClassNotFoundException
    {
        //try {            
            Socket client = new Socket("localhost", port);
            System.out.println("client created");
            // Create the input & output streams to the server
            ObjectOutputStream outStream = new ObjectOutputStream(client.getOutputStream());
            System.out.println("outStream created");
            InputStream inp = client.getInputStream();
            System.out.println("inp recieve");
            ObjectInputStream inStream = new ObjectInputStream(inp);
            System.out.println("inStream created");
            // Read modify
            // TODO here

            /* Create The Message Object to send */
            //PDummy toSend = new PDummy("Dumm");

            /* Send the Message Object to the server */
            //outStream.writeObject(toSend);            

            /* Retrive the Message Object from server */
            PDummy gotIn = null;
            gotIn = (PDummy) inStream.readObject();


            /* Print out the recived Message */
            System.out.println("recieved Dummy-Name: " + gotIn.name);



    }
}
