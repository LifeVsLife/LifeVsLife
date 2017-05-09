
public class PlayerCell extends Cell
{
    public int playerID;
    
    public PlayerCell(int posX, int posY, int playerID)
    {
        super(posX, posY);
        this.playerID = playerID;
    }
    
    public boolean isAlive() {
        return false;
    }
    
}
