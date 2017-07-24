
package logic.game.event;

import java.awt.Color;

@SuppressWarnings("serial")
public class PlayerChangeRepresentation extends GameEvent
{

    private String name = null;
    private Color color = null;

    public PlayerChangeRepresentation(int playerId)
    {
        super(playerId);
    }

    public PlayerChangeRepresentation setName(String name)
    {
        this.name = name;

        return this;
    }

    public PlayerChangeRepresentation setColor(Color color)
    {
        this.color = color;
        
        return this;
    }

}
