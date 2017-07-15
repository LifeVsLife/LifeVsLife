
package logic.game;

public class PlayerMove
{
    private int playerId;
    private int x;
    private int y;
    private Cell cell;

    public PlayerMove(int playerId, int x, int y)
    {
        this.playerId = playerId;
        this.x = x;
        this.y = y;

    }

    public int getPlayerId()
    {
        return playerId;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Cell getCell()
    {
        return cell;
    }

}
