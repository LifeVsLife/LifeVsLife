
public class ThreadT extends Thread
{
    String s;

    public ThreadT(String s) {
        this.s = s;
        start();
    }

    public void run() {
        while (true) {
            System.out.println(s);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
    }
}
