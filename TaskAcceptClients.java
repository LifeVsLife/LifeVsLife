
import java.io.IOException;

public class TaskAcceptClients extends Task {

    TServerSocket server;

    public TaskAcceptClients(TServerSocket server)
    {
        this.server = server;
    }

    public void perform() throws IOException
    {
        server.accept();
    }

}
