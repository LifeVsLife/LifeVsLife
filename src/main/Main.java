
package main;

import java.net.URL;
import java.net.URLClassLoader;

import logic.MasterLogic;

import resources.Resources;

public class Main
{

    public static Resources res;

    public MasterLogic ml;

    /**
     * CONST
     */
    public Main()
    {
        startup();

        stage2();

        stage3();
    }

    public void startup()
    {
        res = new Resources();
    }

    public void stage2()
    {
        ml = new MasterLogic();
    }

    public void stage3()
    {

    }



    public static void main(String[] args)
    {
        Main m = new Main();
    }

}
