
import java.awt.image.BufferedImage;
import java.net.URL;

public class ImageResources {

    public static BufferedImage[] cells;

    public static BufferedImage cell_proto;

    private static final String type = "png";

    private static final int maxTries = 20;

    public ImageResources()
    {
        //System.out.println("Res from Img: "+Main.res);
        loadImages(cells, "cells/", "base");
        cell_proto = ImageLoader.load("cells/cell_proto.png");
        System.out.println(cell_proto);
        BufferedImage img = cell_proto;
        BufferedImage[] tintedImg = new BufferedImage[PlayerColor.ARRAY.length];
        for (int i = 0; i < tintedImg.length; i++)
        {
            tintedImg[i] = GrayTinter.tint(img, PlayerColor.ARRAY[i], 0.7f);
        }
        ShowImage i = new ShowImage(tintedImg);
    }

    public static void loadImages(BufferedImage[] img, String path, String fileName)
    {
        URL[] url = new URL[maxTries];
        int max = 0;
        for (int i = 0; i < url.length && Resources.getResourceURL(path + fileName + i + "." + type) != null; i++)
        {
            url[i] = Resources.getResourceURL(path + fileName + i + "." + type);
            max = i;
        }

        img = new BufferedImage[max];
        for (int i = 0; i < max; i++)
        {
            img[i] = ImageLoader.load(url[i]);
        }
    }
}
