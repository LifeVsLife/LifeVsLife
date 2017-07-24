
package main.master;

import lnet.box.*;

import utils.thread.TThread;

import tnet.communication.TCom;

import main.master.task.ComReadTask;
import main.master.task.ComWriteTask;

public abstract class MasterCom
{
    /**
     * The Thread that writes and reads (when it is the server: also accepts clients)
     */
    protected TThread comThread;
    // /**
    //  * The Thread that iterates read()
    //  */
    // protected TThread readThread;
    //
    // /**
    //  * The Thread that iterates write()
    //  */
    // protected TThread writeThread;

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

        comThread = new TThread("ComThread");
        // readThread = new TThread("ReadThread");
        // writeThread = new TThread("WriteThread");

        comThread.addTask(comReadTask);
        comThread.addTask(comWriteTask);
    }

    public void start()
    {
        comThread.startThread();
        // readThread.startThread();
        // writeThread.startThread();
    }

    public void stop()
    {
        comThread.interrupt();
        // writeThread.interrupt();
        // readThread.interrupt();
        //
        try {
            comThread.join();
            // writeThread.join();
            // readThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        recieved.close();
        send.close();
    }

    /**
     * Use this InBox to read what the client recieves from the Server
     *
     * @return The InBox to read from
     */
    public InBox getInBox()
    {
        return recieved.getInBox();
    }

    /**
     * Use this OutBox to write data that shall be sent to the Server
     *
     * @return The OutBox to write to
     */
    public OutBox getOutBox()
    {
        return send.getOutBox();
    }

}
