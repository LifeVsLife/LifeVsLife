
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;

public abstract class ImageLoader {

    public static BufferedImage load(String path)
    {
        return load(Resources.getResourceURL(path));
    }

    public static BufferedImage load(URL url)
    {
        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            return null;
        }
    }

}
