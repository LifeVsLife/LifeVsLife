
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.net.URL;

public class Resources {

    public URL resPath = this.getClass().getResource("res/");

    public ImageResources images;

    public Resources()
    {
        images = new ImageResources();
    }

    public static boolean checkURL(URL url) {
        return new File(url.toString()).exists();
    }

    public URL getResourceURL(URL url)
    {
        return getResourceURL(url.toString());
    }

    public URL getResourceURL(String url)
    {
        URL resURL = URLAppender.append(resPath, url);
        if (checkURL(resURL)) {
            return resURL;
        } else {
            return null;
        }
    }


    public static void main(String[] args) throws Exception
    {
        File file = new File("/res/");
        System.out.println(file.getPath());
        //BufferedImage image = ImageIO.read(file);

        Resources r = new Resources();
        System.out.println(r.resPath);
        System.out.println(r.getResourceURL("cells/cell.png"));
        //System.out.println(new File(r.getResourceURL("cells/cell3.png").toString()).exists());

    }

}
