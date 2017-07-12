
// lambda expression test

// imports for testbutton
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
// end: imports for testbutton

import java.util.Arrays;

public class test
{
    public int x = 0;

    public test()
    {

    }

    private void factor(int f)
    {
        x *= f;
    }

    /*public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,14};
        //System.out.println(
            Arrays.stream(arr)
                .filter(x -> x % 2 == 0)
                //.map(x -> x * 2)
                .filter(x -> x > 4)

                .forEach(System.out::println);
            //.map(x -> x * 2);
        //);
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] % 2 == 0 && arr[i] > 4)
            {
                System.out.println(arr[i]);
            }
        }
    }

    public static void main2(String[] args)
    {
        test t = new test();

        Lol code = () -> t.x++;

        code.lol();
        System.out.println(t.x);

        // button for tests
        JFrame frame = new JFrame("Test");
        frame.setLayout(new FlowLayout());

        JButton button1 = new JButton("1");
        button1.addActionListener(System.out::println);
        //button1.addActionListener(e -> System.out.println(e));
        frame.add(button1);

        JButton button2 = new JButton("2");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                Exception a = new Exception("lolol");
                a.printStackTrace();
                System.out.println(Thread.currentThread().getName());
            }
        });
        frame.add(button2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        System.out.println(Thread.currentThread().getName());
        // end: button for tests
    }*/

}

interface Lol {

    public void lol();
    //public void dkasd(String s);

}
