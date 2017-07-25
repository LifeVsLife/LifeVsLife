
package logic.game.event;

import logic.game.map.Cell;

@SuppressWarnings("serial")
public class GameMove extends GameEvent
{

    private Cell cell = null;
    private int x = -1;
    private int y = -1;

    public GameMove(int playerId)
    {
        super(playerId);
    }

    public GameMove setCell(Cell cell)
    {
        this.cell = cell;

        return this;
    }

    public GameMove setPos(int x, int y)
    {
        this.x = x;
        this.y = y;

        return this;

    }

}
