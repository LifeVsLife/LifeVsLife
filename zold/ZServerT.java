
import java.io.*;
import java.net.*;

public class ZServerT
{
    public final int port = 4445;

    ServerSocket server;
    ObjectOutputStream outStream;
    ObjectOutputStream outStream2;

    public ZServerT() //throws IOException
    {
        try {
            // Create the socket
            server = new ServerSocket(port);
            System.out.println("server created");

            Socket serverClient = server.accept(); //connected client
            Socket serverNew = new Socket("localhost", port);
            //System.out.println("client created");

            // Create the input & output streams to the server
            outStream = new ObjectOutputStream(serverNew.getOutputStream());
            outStream2 = new ObjectOutputStream(serverClient.getOutputStream());
            System.out.println("outStream created");

            /*InputStream inp = client.getInputStream();
            System.out.println("inp recieve");

            client.close();
            server.close();
             */

            send();
        } catch (Exception e) {
            System.err.println("Client Error: " + e.getMessage());
            System.err.println("Localized: " + e.getLocalizedMessage());
            System.err.println("Stack Trace: " + e.getStackTrace());
        }
    }

    public void accept() throws IOException {
        Socket serverClient = server.accept();
        outStream2 = new ObjectOutputStream(serverClient.getOutputStream());
    }

    public void send()
    {
        // while (true) {
        try {
            //outStream.writeObject(new PDummy("Timo"));
            //outStream2.writeObject(new PDummy("Timo2"));
            outStream.writeObject("Timo");
            outStream2.writeObject("Timo2");
        } catch (IOException e) {

        }
        //}
    }
}
