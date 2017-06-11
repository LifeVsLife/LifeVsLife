

public class YThreadExample extends Thread
{
    String s;

    public YThreadExample(String s) {
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

    public static void main(String[] args) {
        YThreadExample s = new YThreadExample("tim");
    }
}
