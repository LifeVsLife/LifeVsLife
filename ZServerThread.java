public class ZServerThread extends Thread
{
    ZServerT server;

    public ZServerThread() 
    {
        start();
    }

    public void run()
    {
        //try {
            server = new ZServerT();
        //} catch (java.io.IOException e) {

        //}
    }
    
    public void send() {
        server.send();
    }
    
    public void accept() throws java.io.IOException {
        server.accept();
    }

}
