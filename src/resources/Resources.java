
package resources;

import main.Main;

import java.io.InputStream;
import utils.URLAppender;

public class Resources {

    private static final String resPath = "../../res/";

    public ImageResources images;

    public Resources()
    {
        //System.out.println("RES-PATH: "+resPath);
        images = new ImageResources();
    }

    public static boolean checkPath(String path) {
        return getResourceAsStream(path) != null;
    }

    public static InputStream getResourceAsStream(String path) {
        String newPath;
        if (Main.isJar) {
            newPath = "/" + path;
        } else {
            newPath = resPath + path;
        }
        return Resources.class.getResourceAsStream(newPath);
        //return null;
    }

}
