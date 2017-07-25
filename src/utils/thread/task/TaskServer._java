
package utils.thread.task;

import java.io.IOException;
import tnet.TServer;

/**
 * The TaskServer class performs the tasks of a TServer
 */
@Deprecated
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
    @Override
    public synchronized void perform()
    {
        try {
            server.serverSocket.accept();
            server.read(); // not final
        } catch (IOException | ClassNotFoundException e) {

        }
        //server.write();
    }

}
