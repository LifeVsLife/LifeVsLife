
package main.master;

import java.io.IOException;

import main.master.task.ComReadTask;
import main.master.task.ComWriteTask;
import main.master.task.AcceptTask;

import utils.thread.TThread;

import tnet.communication.TNetData;

import tnet.TServer;

public class MasterComServer extends MasterCom
{

    /**
     * The Server for the connection
     */
    protected TServer server;

    // protected TThread acceptThread;

    protected AcceptTask acceptTask;


    public MasterComServer()
    {
        server = new TServer();
        init(server.getCom());

        acceptTask = new AcceptTask(server);

        // acceptThread = new TThread("AcceptThread");

        comThread.addTask(acceptTask);
    }

    public void open(int port)
    {
        try {
            server.open(port);
        }
        catch (IOException e) {
            System.out.println("[MasterComServer] Please try another port!");
            //TODO show this info
            //e.printStackTrace();
        }
    }

    public void start()
    {
        super.start();
        // acceptThread.startThread();
    }

    public void close()
    {
        super.stop();
        server.close();
    }

    @Override
    public void finalize()
    {
        close();
    }

    public static void main(String[] args) //throws Exception
    {
        MasterComServer s = new MasterComServer();
        s.open(8345);
        s.start();
        s.server.setWriteReadObjectsToAll(true);

        //System.out.println("gonna send");
        s.getOutBox().write("My name is Tim");
        //System.out.println("read == " + s.recieve.getInBox().<String>read());
        //System.out.println("send");


        // try {
        //     Thread.sleep(500);
        // }
        // catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        // System.out.println("lol");
        // //System.out.println(s.thread.getTasks().length());
        //
        // int i = 0;
        // while (i < 999999) {
        //     i++;
        // }
        // System.out.println("end");
        while (true) {
            //System.out.println(s.readThread.isAlive());
            // TNetData<String> data = s.getInBox().<TNetData<String>>read();
            // if (data != null)
            //     System.out.println(data.getData());
            System.out.println(s.getInBox().<TNetData<String>>waitRead().getData());
        }
        //s.thread.stopThread();
    }

}
