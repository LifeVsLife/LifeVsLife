
package main.master.task;

import utils.thread.task.Task;

import tnet.TServer;

public class AcceptTask extends Task
{

    TServer server;

    public AcceptTask(TServer server)
    {
        this.server = server;
    }

    public void perform()
    {
        //System.out.println("Accept");
        server.acceptClient();
    }

}
