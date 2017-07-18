
package utils.thread;

import utils.thread.task.Task;

import main.master.task.ComReadTask; // TODO cleanup

import tlist.TList;

// author: Tim Guggenmos
// date: 08.07.2017
// ver: 0.1.0

/**
 * A TThread with a task to do iterably while it's running
 * use startThread() and stopThread()
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
    private TList<Task> tasks = new TList<Task>();

    /**
     * TThread creation
     */
    public TThread()
    {
        super();
    }

    public TThread(String name)
    {
        super(name);
    }

    /**
     * TThread creation with a Task
     */
    public TThread(String name, Task... task)
    {
        super(name);
        // this.task.empty();
        this.tasks.add(task);
    }

    /**
     * TThread creation with a Task
     */
    public TThread(Task... task)
    {
        super();
        // this.task.empty();
        this.tasks.add(task);
    }

    // public void setTask(Task... task)
    // {
    //     this.task.empty();
    //     addTask(task);
    // }

    public synchronized void addTask(Task... task)
    {
        this.tasks.addLast(task);
    }

    public synchronized void removeTasks()
    {
        this.tasks.empty();
    }

    /**
     * The run method gets called iterably, it calls the perform() of its task
     */
    @Override
    public void run() // loop here
    {
        try {
            while (running)
            {
                //System.out.println(getName()+": running = "+running);
                if (getName() == "ReadThread") {
                    //System.out.println("readThread");
                }
                if (!isAlive()) {
                    System.out.println("[TThread] isAlive() -> FALSE"); // TODO cleanup
                }
                for (Task task : tasks)
                {
                    //System.out.println(task);
                    // if (task instanceof ComReadTask) {
                    //     System.out.println(task.isEnabled());
                    // }
                    if (task.isEnabled())
                    {
                        task.perform();
                    }
                }
            }
        }
        catch (Throwable e) {
            e.printStackTrace();
        }

    }

    /**
     * Starts the Task -> running = true & starts iterating run()
     */
    public void startThread()
    {
        // if (tasks != null)
        // {
        running = true;
        super.start();
        // } else {
        //     System.out.println("[TTherad] Task == null when starting!");
        // }

    }

    /**
     * Stops the Task -> running = false -> run()-itaration ends
     */
    public void stopThread()
    {
        System.out.println("Stop Thread");
        running = false;
    }

    public synchronized TList<Task> getTasks()
    {
        return tasks;
    }

    /**
     * Returns running attribute
     */
    public synchronized boolean isRunning()
    {
        return running;
    }

}
