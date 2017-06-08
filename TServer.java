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

    public synchronized void read() throws IOException, ClassNotFoundException
    {
        int length = serverSocket.clientSocketConnections.length();
        //System.out.println(length);
        for (int i = 0; i < length; i++)
        {
            Object o = serverSocket.clientSocketConnections.get(i).in.readObject();
            System.out.println((String) o);
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
