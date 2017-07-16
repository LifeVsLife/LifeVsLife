
package main.master;

import ui.TFrame;

public class MasterView
{

    public TFrame frame;

    public MasterView()
    {
        init();
    }

    public void init()
    {
        frame = new TFrame("LifeVsLife");
        frame.pack();
        frame.setVisible(true);
    }

}
