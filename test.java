
// imports for testbutton
import javax.swing.*;
import java.awt.event.*;
// end: imports for testbutton

import java.awt.FlowLayout;

public class test
{

    public static void main(String[] args)
    {
        System.out.println("Start");
        int port = 4831;
        // button for tests
        JFrame frame = new JFrame("Test Frame");
        frame.setLayout(new FlowLayout());
        TServer server = new TServer(new TServerSocket(port));

        JButton button1 = new JButton("Start TServerSocket on Port "+port);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    server.serverSocket.open();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        frame.add(button1);

        JButton button2 = new JButton("Start task");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    server.startTask();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        frame.add(button2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        // end: button for tests
    }

}
