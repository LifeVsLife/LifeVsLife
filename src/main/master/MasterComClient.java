
package main.master;

import java.io.IOException;

import main.master.task.ComReadTask;
import main.master.task.ComWriteTask;

import tnet.TClient;

/**
 * use:
 * MasterComClient c = new MasterComClient();
 * c.connect(IP, PORT);
 * c.start();
 * c.getOutBox().write(OBJECT);
 */
public class MasterComClient extends MasterCom
{

    /**
     * The Client for the connection
     */
    protected TClient client;

    public MasterComClient()
    {
        client = new TClient();
        init(client.getCom());
    }

    public void connect(String ip, int port)
    {
        try {
            client.connect(ip, port);
        }
        catch (IOException e) {
            System.out.println("[MasterComClient] Please try another ip or port!");
            //TODO show this info
            //e.printStackTrace();
        }
    }

    public void disconnect()
    {
        super.stop();
        client.disconnect();
    }

    @Override
    public void finalize()
    {
        disconnect();
    }

    private void sleep(int ms)
    {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) //throws Exception
    {
        MasterComClient c = new MasterComClient();
        c.connect("localhost", 8345);
        c.start();

        System.out.println("gonnawrite");
        c.getOutBox().write("Hey, i am new to your server");
        c.getOutBox().write("2nd mess");

        c.sleep(10);

        System.out.println("2 done");

        c.getOutBox().write("3rd MESSAGE");

        c.sleep(10);

        c.getOutBox().write("4th MESSAGE");
        int i = 0;
        while (true) {
            //c.getOutBox().write(i++ + "th MESSAGE");
            c.sleep(10);
        }
    }

}
