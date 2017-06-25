
package communication;

import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

import communication.TServerSocket;

public class test {

    public test()
    {

    }

    public static void main(String[] args)
    {
        System.out.println("Start");
        int port = 4831;
        // button for tests
        JFrame frame = new JFrame("Test Frame");
        frame.setLayout(new FlowLayout());
        TServerSocket serverSocket = new TServerSocket(port);

        JButton button1 = new JButton("Start on Port "+port);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    serverSocket.open();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        frame.add(button1);

        /*JButton button2 = new JButton("Start task");
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
        frame.add(button2);*/

        JButton button3 = new JButton("print");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("print-");
            }
        });
        frame.add(button3);

        JButton button4 = new JButton("myIP");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(serverSocket.serverSocket.getInetAddress());
            }
        });
        frame.add(button4);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        // end: button for tests
    }

}
