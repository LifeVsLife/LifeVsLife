
package main.master.task;

import tnet.communication.TServerCom;
import tnet.communication.TNetData;
import tnet.communication.TCom;

import lnet.box.InBox;
import lnet.box.OutBox;

import utils.thread.task.Task;

public class ComWriteTask extends Task
{

    private TCom com;

    private InBox toSend;

    public ComWriteTask(TCom com, InBox toSend)
    {
        this.com = com;
        this.toSend = toSend;
    }

    public void perform()
    {
        write();
    }

    public void write()
    {
        if (com.canCommunicate())
        {
            Object data = toSend.read();
            //System.out.println("Write");
            if (data != null) {
                System.out.println("write( " + data + " )");
                com.write(data);
            }
        }
    }

}
