
package main.master;

import tnet.TServer;

import main.master.task.ComTask;

import java.io.IOException;

public class MasterComServer extends MasterCom
{

    /**
     * The Server for the connection
     */
    public TServer server;

    public MasterComServer()
    {
        super();
        server = new TServer();
        comTask = new ComTask(
            (lnet.Com) server.getCom(),
            recieve.getOutBox(),
            send.getInBox()
        );
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

    public void close()
    {
        server.close();
    }

    @Override
    public void finalize()
    {
        close();
    }

}
