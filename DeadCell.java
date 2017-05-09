
public class DeadCell extends Cell
{
    
    public DeadCell(int posX, int posY) {
        super(posX, posY);
    }
    
    public boolean isAlive() {
        return false;
    }
}
