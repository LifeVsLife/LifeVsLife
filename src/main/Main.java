
package main;

import resources.Resources;

import java.net.URL;
import java.net.URLClassLoader;

public class Main {

    public static boolean isJar;

    public static Resources res;

    /**
     * CONST
     */
    public Main()
    {
        isJar = Main.class.getResourceAsStream("../../res/") == null;
        System.out.println(isJar);

        stage1();

        stage2();

        stage3();
    }

    public void stage1()
    {
        /*
        System.out.println(ClassLoader.class.getResourceAsStream("../res/"));
        //Get the System Classloader
        ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
        //Get the URLs
        URL[] urls = ((URLClassLoader)sysClassLoader).getURLs();
        for(int i=0; i< urls.length; i++)
        {
            System.out.println(urls[i].getFile());
        }*/
        System.out.println(getClass().getClassLoader().getResourceAsStream("../res/"));
        System.out.println(Main.class.getClassLoader().getResourceAsStream("../../res/"));
        System.out.println(Main.class.getResourceAsStream("../res/"));

        res = new Resources();
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
