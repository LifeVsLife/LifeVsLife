
package main.master.task;

import tnet.communication.TServerCom;
import tnet.communication.TNetData;
import tnet.communication.TCom;

import lnet.box.InBox;
import lnet.box.OutBox;

import utils.thread.task.Task;

public class ComReadTask extends Task
{

    private TCom com;

    private OutBox recieved;

    public ComReadTask(TCom com, OutBox recieved)
    {
        this.com = com;
        this.recieved = recieved;
    }

    public void perform()
    {
        read();
    }

    @SuppressWarnings("rawtypes")
    public void read()
    {
        if (com.canCommunicate())
        {
            TNetData data = com.read();
            if (data != null) {
                System.out.println("read() -> [" + data.getClientId() + "]: " + data.getData());
                recieved.write(data);
            }
        }
    }

}
