
package res;

import enums.PlayerColor;

import java.awt.image.BufferedImage;
import java.net.URL;

import utils.image.ImageLoader;
import utils.image.ShowImage;
import utils.image.GrayTinter;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import utils.Logger;
import java.io.IOException;

public class ImageResources {

    public static BufferedImage[] cells;

    public static BufferedImage cell_proto;

    private static final String type = "png";



    public ImageResources()
    {
        cells = ImageLoader.loadImageSet("pics/cells/", "base", type);

        BufferedImage[] colored = new BufferedImage[PlayerColor.ARRAY.length];
        for (int i = 0; i < colored.length; i++)
        {
            colored[i] = GrayTinter.tint(ImageLoader.loadImage("pics/cells/dead/dead0.png"), PlayerColor.ARRAY[i], 0.6f);
        }
        ShowImage s = new ShowImage(colored);
        //System.out.println(cells.length);
    }



}
