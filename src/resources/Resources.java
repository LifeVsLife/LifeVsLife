
package resources;

import main.Main;

import java.io.InputStream;

import resources.image.ImageResources;
import utils.URLAppender;

public class Resources
{

    private static final String resPath = "../../res/";
    public static boolean isJar = Resources.class.getResourceAsStream(resPath) == null;

    public ImageResources images;

    public Resources()
    {
        System.out.println("[Resources] isJar = " + isJar);
        images = new ImageResources();
    }

    public static boolean checkPath(String path)
    {
        return getResourceAsStream(path) != null;
    }

    public static InputStream getResourceAsStream(String path)
    {
        String newPath = "";
        if (isJar) {
            newPath = "/" + path;
        } else {
            newPath = resPath + path;
        }
        System.out.println(newPath);
        return Resources.class.getResourceAsStream(newPath);
        //return null;
    }

}
