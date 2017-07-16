
package main;

import java.net.URL;
import java.net.URLClassLoader;

import main.master.Master;

import resources.Resources;

public class Main
{

    public static Resources res;

    public static Master master;

    /**
     * CONST
     */
    public Main()
    {
        init();

        stage2();

        stage3();
    }

    public void init()
    {
        res = new Resources();
        master = new Master();
    }

    public void stage2()
    {

    }

    public void stage3()
    {

    }



    public static void main(String[] args)
    {
        Main m = new Main();
    }

}
