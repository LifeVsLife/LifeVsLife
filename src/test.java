
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

    private void pr(String... s)
    {
        for (String st : s)
        {
            System.out.print(st+", ");
        }
        System.out.println();
    }



    public static void main(String[] args)
    {
        A a = new B();
        System.out.println(a instanceof C);
    }
}

class A {

}

class B extends A {

}

class C extends A {

}
