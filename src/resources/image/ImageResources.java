
package resources.image;

import enums.PlayerColor;

import java.awt.image.BufferedImage;

import utils.image.GrayTinter;
import utils.image.ImageLoader;
import utils.image.ShowImage;

public class ImageResources
{

    public static BufferedImage[] cells;

    public static BufferedImage cell_proto;

    private static final String type = "png";



    public ImageResources()
    {
        //cells = ImageLoader.loadImageSet("images/cells/", "base", type);

        BufferedImage[] colored = new BufferedImage[PlayerColor.ARRAY.length];
        for (int i = 0; i < colored.length; i++)
        {
            colored[i] = GrayTinter.tint(ImageLoader.loadImage("images/cells/cell_proto.png"), PlayerColor.ARRAY[i], 0.8f);
        }
        ShowImage s = new ShowImage(colored);
        //System.out.println(cells.length);
    }



}
