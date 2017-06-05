import java.io.*;
import java.net.*;

public class TServer {

    public TServerSocket serverSocket;

    private TThread task;

    public TServer(TServerSocket serverSocket)
    {
        this.serverSocket = serverSocket;
        task = new TThread(new TaskServer(this));
    }

    public void read() throws IOException, ClassNotFoundException
    {
        SocketConnection[] sockets = (SocketConnection[]) serverSocket.clientSocketConnections.getArray();
        for (int i = 0; i < sockets.length; i++)
        {
            Object o = sockets[i].in.readObject();
            if (o != null) {
                try {
                    System.out.println((String) o);
                } catch (Exception e) {

                }
            }
        }
    }

    public void write()
    {

    }

    public synchronized void startTask()
    {
        task.startThread();
    }

    public synchronized void stopTask()
    {
        task.stopThread();
    }

}
