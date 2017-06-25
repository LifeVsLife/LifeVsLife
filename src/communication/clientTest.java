
package communication;

import java.io.*;
import java.net.*;

public class clientTest {

    Socket socket;

    String ip = "";
    int port = 0;

    public clientTest(String ip, int port)
    {
        this.ip = ip;
        this.port = port;
    }

    public void open() {
        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
