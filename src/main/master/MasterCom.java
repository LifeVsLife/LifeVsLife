
package main.master;

import lnet.box.*;

import utils.thread.TThread;

import main.master.task.ComTask;

public abstract class MasterCom
{
    /**
     * The Thread that iterates read() and write()
     */
    private TThread serverThread;

    protected ComTask comTask;

     /**
      * The streams that you can read from what is recieved
      */
    protected BoxLink recieve;
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
        init();
    }

    public void init()
    {
        serverThread = new TThread();

        recieve = new BoxLink();
        send = new BoxLink();
        // in = recieve.getInBox();
        // out = send.getOutBox();
        serverThread.setTask(comTask);
    }

    public InBox getInBox()
    {
        return recieve.getInBox();
    }

    public OutBox getOutBox()
    {
        return recieve.getOutBox();
    }

}
