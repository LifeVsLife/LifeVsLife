
public class TThread extends Thread {

    private boolean running = false;
    private Task task;

    public TThread(Task task)
    {
        this.task = task;
    }

    public void run() // loop this
    {
        while (running)
        {
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
