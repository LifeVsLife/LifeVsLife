
import javax.swing.JFrame;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class TFrame extends JFrame {

    public TFrame()
    {
        super();
        init();
    }

    public TFrame(String title)
    {
        super(title);
        init();
    }

    public void init()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @SuppressWarnings("deprecation")
    public void resize(int sizeX, int sizeY)
    {
        getContentPane().setPreferredSize(new Dimension(sizeX, sizeY));
        pack();
    }

}
