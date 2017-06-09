
import java.awt.Graphics;

@SuppressWarnings("serial")
public class PaintPanel extends TPanel {

    PaintLayer[] layer; // wenn a>b dann liegt layer[a] über layer[b]

    public PaintPanel()
    {
        super();
        init();
    }

    public void init()
    {

    }

    public void paintComponent(Graphics g)
    {
        if (layer != null) {
            for (PaintLayer l : layer)
            {
                if (l != null) {
                    l.paintComponent(g);
                }
            }
        }
    }

}
