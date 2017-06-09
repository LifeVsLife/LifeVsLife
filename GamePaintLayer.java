
import java.awt.Graphics;

public class GamePaintLayer extends PaintLayer{

    GamePaintView gameView;

    public GamePaintLayer()
    {
        init();
    }

    public void init()
    {

    }

    public void paintComponent(Graphics g)
    {
        gameView.paintComponent(g);
    }

}
