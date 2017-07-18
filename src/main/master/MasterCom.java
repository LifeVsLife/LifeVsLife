
package main.master;

import lnet.box.*;

import utils.thread.TThread;

import tnet.communication.TCom;

import main.master.task.ComReadTask;
import main.master.task.ComWriteTask;

public abstract class MasterCom
{
    /**
     * The Thread that iterates read()
     */
    protected TThread readThread;

    /**
     * The Thread that iterates write()
     */
    protected TThread writeThread;

    protected ComReadTask comReadTask;

    protected ComWriteTask comWriteTask;

     /**
      * The streams that you can read from what is recieved
      */
    protected BoxLink recieved;
    /**
     * The streams that you write to to send
     */
    protected BoxLink send;

    // /**
    //  * The stream with the objects recieved from the clients
    //  */
    // public InBox in;
    // /**
    //  * The stream to write objects to that shall be send
    //  */
    // public OutBox out;

    public MasterCom()
    {

    }

    public void init(TCom com)
    {
        recieved = new BoxLink();
        send = new BoxLink();

        comReadTask = new ComReadTask(
            com,
            recieved.getOutBox()
        );

        comWriteTask = new ComWriteTask(
            com,
            send.getInBox()
        );

        readThread = new TThread("ReadThread");
        writeThread = new TThread("WriteThread");

        readThread.addTask(comReadTask);
        writeThread.addTask(comWriteTask);

    }

    public void start()
    {
        readThread.startThread();
        writeThread.startThread();
    }

    public void stop()
    {
        writeThread.interrupt();
        readThread.interrupt();
        try {
            writeThread.join();
            readThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        recieved.close();
        send.close();
    }

    public InBox getInBox()
    {
        return recieved.getInBox();
    }

    public OutBox getOutBox()
    {
        return send.getOutBox();
    }

}
