
package utils.thread.task;

import tlist.TList;

public class Ticker extends Task {

    private long last;
    private long lastSec;

    public TList<Task> tickTask;
    public TList<Task> secTask;

    public Ticker()
    {

    }

    @Override
    public void perform() {
        if (last == 0 || lastSec == 0) {
            last = System.nanoTime();
            lastSec = System.nanoTime();
            return;
        }

        long now = System.nanoTime();
        long delta = now - last;

        for (Task task : tickTask)
        {
            task.perform();
        }

        if (now - lastSec >= 1000000000) {
            lastSec += 1000000000;
            System.out.println("sec");
            for (Task task : secTask)
            {
                task.perform();
            }
        }
    }

    //private void handleNs(int )
    public static void main(String[] args)
    {
        Ticker t = new Ticker();

        while (true) {
            t.perform();
        }
    }

}
