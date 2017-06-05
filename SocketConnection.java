
import java.io.*;
import java.net.*;

public class SocketConnection {

    public Socket socket;
    public ObjectInputStream in;
    public ObjectOutputStream out;

    public SocketConnection(Socket socket) throws IOException
    {
        this.socket = socket;
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
    }

}
