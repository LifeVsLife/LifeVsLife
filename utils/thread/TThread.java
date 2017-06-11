
package utils.thread;

import utils.thread.task.Task;

// author: Tim Guggenmos
// date: 08.07.2017
// ver: 0.1.0

/**
 * A TThread with a task to do iterably while it's running
 */

public class TThread extends Thread
{
    /**
     * should it do it's task?
     */
    private boolean running = false;

    /**
     * A Task with a perform() method -> what is does
     */
    private Task task;

    /**
     * TThread creation with a Task
     */
    public TThread(Task task)
    {
        this.task = task;
    }

    /**
     * The run method gets called iterably, it calls the perform() of its task
     */
    public void run() // loop here
    {
        while (running)
        {
            //System.out.println("Running: " + running);
            try {
                task.perform();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Starts the Task -> running = true & starts iterating run()
     */
    public synchronized void startThread()
    {
        running = true;
        super.start();
    }

    /**
     * Stops the Task -> running = false -> run()-itaration ends
     */
    public synchronized void stopThread()
    {
        running = false;
    }

    /**
     * Returns running attribute
     */
    public synchronized boolean isRunning()
    {
        return running;
    }

}
