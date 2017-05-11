

public class SimpleTestThread extends Thread
{
    String s;

    public SimpleTestThread(String s) {
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
