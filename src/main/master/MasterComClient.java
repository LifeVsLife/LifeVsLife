
package main.master;

import java.io.IOException;

import main.master.task.ComTask;

import tnet.TClient;

public class MasterComClient extends MasterCom
{

    /**
     * The Client for the connection
     */
    public TClient client;

    public MasterComClient()
    {
        super();
        client = new TClient();
        comTask = new ComTask(
            (lnet.Com) client.getCom(),
            recieve.getOutBox(),
            send.getInBox()
        );
    }

    public void connect(String ip, int port)
    {
        try {
            client.connect(ip, port);
        }
        catch (IOException e) {
            System.out.println("[MasterComServer] Please try another port!");
            //TODO show this info
            //e.printStackTrace();
        }
    }

    public void disconnect()
    {
        client.disconnect();
    }

    @Override
    public void finalize()
    {
        disconnect();
    }

}
