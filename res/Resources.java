
package res;

import utils.URLAppender;

public class Resources {

    public ImageResources images;

    public Resources()
    {
        //System.out.println("RES-PATH: "+resPath);
        images = new ImageResources();
    }

    public static boolean checkPath(String path) {
        return ResRoot.class.getResourceAsStream(path) != null;
    }

}
