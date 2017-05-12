public class ServerThread extends Thread
{
    ServerT server;

    public ServerThread() 
    {
        start();
    }

    public void run()
    {
        //try {
            server = new ServerT();
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
