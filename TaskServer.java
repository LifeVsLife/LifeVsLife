
import java.io.IOException;

/**
 * The TaskServer class performs the tasks of a TServer
 */
public class TaskServer implements Task {

    /**
     * The TServer which has tasks
     */
    private TServer server;

    /**
     * TaskServer creation with a TServer
     */
    public TaskServer(TServer server)
    {
        this.server = server;
    }

    /**
     * The tasks themselves
     */
    public synchronized void perform() throws IOException
    {
        server.serverSocket.accept();
        try {
            server.read(); // not final
        } catch (IOException | ClassNotFoundException e) {

        }
        //server.write();
    }

}
