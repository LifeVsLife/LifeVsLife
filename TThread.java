
public class TThread extends Thread
{
    public boolean running = false; //private
    private Task task;

    public TThread(Task task)
    {
        this.task = task;
    }

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

    public synchronized void startThread()
    {
        running = true;
        super.start();
    }

    public synchronized void stopThread()
    {
        running = false;
    }

}
