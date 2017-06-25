
package tnet;

import utils.thread.TThread;
import utils.thread.task.TaskServer;

import java.io.*;
import java.net.*;

public class TServer {

    public TServerSocket serverSocket;

    private TThread serverTask;

    public TServer(TServerSocket serverSocket)
    {
        this.serverSocket = serverSocket;
        serverTask = new TThread(new TaskServer(this));
    }

    public synchronized void read() throws IOException, ClassNotFoundException
    {
        int length = serverSocket.socketConnections.length();
        //System.out.println(length);
        for (int i = 0; i < length; i++)
        {
            Object o = serverSocket.socketConnections.get(i).in.readObject();
            System.out.println((String) o);
        }
    }

    public void write()
    {

    }

    public synchronized void startTask()
    {
        serverTask.startThread();
    }

    public synchronized void stopTask()
    {
        serverTask.stopThread();
    }

}
