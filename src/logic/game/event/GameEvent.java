
package logic.game.event;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class GameEvent implements Serializable
{
    private int playerId = -1;

    public GameEvent(int playerId)
    {
        this.playerId = playerId;
    }

    public int getPlayerId()
    {
        return playerId;
    }

}
