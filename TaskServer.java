
import java.io.IOException;

public class TaskServer extends Task {

    TServer server;

    public TaskServer(TServer server)
    {
        this.server = server;
    }

    public synchronized void perform() throws IOException
    {
        server.serverSocket.accept();
        try {
            server.read(); // not final
        } catch (ClassNotFoundException e) {
            
        }
        //server.write();
    }

}
