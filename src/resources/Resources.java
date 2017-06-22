
package resources;

import java.io.InputStream;
import utils.URLAppender;

public class Resources {

    private static final String resPath = "../../res/";

    public ImageResources images;

    public Resources()
    {
        System.out.println("RES-PATH: "+resPath);
        images = new ImageResources();
    }

    public static boolean checkPath(String path) {
        return false;//Main.class.getResourceAsStream(path) != null;
    }

    public static InputStream getResourceAsStream(String path) {
        return Resources.class.getResourceAsStream(resPath + path);
        //return null;
    }

}
