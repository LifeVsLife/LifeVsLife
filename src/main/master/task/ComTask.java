
package main.master.task;

import tnet.communication.TServerCom;
import tnet.communication.TNetData;

import lnet.box.InBox;
import lnet.box.OutBox;
import lnet.Com;

import utils.thread.task.Task;

public class ComTask implements Task
{

    private Com server;

    private InBox in;
    private OutBox out;

    private boolean reading = true;
    private boolean writing = true;

    public ComTask(Com server, OutBox out, InBox in)
    {
        this.server = server;
        this.out = out;
        this.in = in;
    }

    public void perform()
    {
        if (reading)
            read();
        if (writing)
            write();
    }

    public void read()
    {
        TNetData<String> data;
        while ((data = server.read()) != null)
        {
            out.write(data);
        }
    }

    public void write()
    {
        Object data;
        while ((data = in.read()) != null)
        {
            server.write(data);
        }
    }

}
