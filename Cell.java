
public abstract class Cell
{
    int posX, posY;
    
    public Cell(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    abstract public boolean isAlive();
    
}
