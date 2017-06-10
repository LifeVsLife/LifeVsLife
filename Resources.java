
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.net.URL;
import java.net.MalformedURLException;

public class Resources {

    public static URL resPath = new Root().getClass().getResource("res/");

    public static ImageResources images = new ImageResources();

    public Resources()
    {
        //System.out.println("RES-PATH: "+resPath);
    }


    public static boolean checkURL(URL url) {
        return new File(url.getPath()).exists();
    }

    public static URL getResourceURL(URL url)
    {
        return getResourceURL(url.toString());
    }

    public static URL getResourceURL(String url)
    {
        try {
            URL resURL = URLAppender.append(resPath, url);
            if (checkURL(resURL)) {
                return resURL;
            }

        } catch (MalformedURLException e) {

            //Logger.warning("Resources", "getResourceURL", "URL cannot be appended!"); //no 'this.'

        }
        return null;
    }

    public static void main(String[] args)
    {
        //new Resources();
        //System.out.println(new Root().getClass().getResource("res/cells/base/"));
        //System.out.println(new Root().getClass().getResource("res/cells/base/").toString());
        URL resour = getResourceURL("cells/base/base0.png");
        System.out.println(resour);
        System.out.println("check self: "+ checkURL(resour));


        System.out.println("---------");


        URL r = new Root().getClass().getResource("");
        System.out.println("r = "+r);

        File f = new File(r.getPath());
        System.out.println("f = "+f);

        boolean e = f.exists(); // f.getAbsoluteFile() ?
        System.out.println("e = "+e);



    }

}
