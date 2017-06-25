
package utils.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.InputStream;

import resources.ResRoot;
import resources.Resources;

public abstract class ImageLoader {

    private static final int maxTries = 20;

    public static BufferedImage loadImage(String path)
    {
        try {
            //return ImageIO.read(ImageLoader.class.getClassLoader().getResourceAsStream("pics/cells/cell_proto.png"));
            return ImageIO.read(Resources.getResourceAsStream(path)); // pics/cells/...
        } catch (IOException e) {
            return null;
        }
    }

    public static BufferedImage[] loadImageSet(String path, String file, String type)
    {
        InputStream[] stream = new InputStream[maxTries];
        int max = 0;
        //System.out.println(ResRoot.class.getResource(""));
        //System.out.println(path + file + "/" + file + "0" + "." + type);
        //System.out.println(ResRoot.class.getResourceAsStream(path + file + "/" + file + "0" + "." + type));
        for (int i = 0; i < stream.length && (stream[i] = Resources.getResourceAsStream(path + file + "/" + file + i + "." + type)) != null; i++)
        {
            max++;
            //System.out.println("i++ "+max);
        }

        BufferedImage[] img = new BufferedImage[max];
        try {
            for (int i = 0; i < max; i++)
            {
                img[i] = ImageIO.read(stream[i]);
                //System.out.println("read");
            }
        } catch (IOException e) {
            //Logger.warning("ImageResources", "loadImageSet", "loading " + path + file);
        }
        return img;
    }

}
