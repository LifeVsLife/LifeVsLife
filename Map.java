//auhor: Thomas Plank
//date: 08.05.17
//version: 0.0.3
/**
 * speichern der Cells
 *
 */

public class Map
{
    private int x;
    private int y;
    private Cell[][] cell;

    public Map(int x, int y)
    {
        this.x = x;
        this.y = y;
        Cell cell[][] = new Cell[x][y];
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Cell getCell(int x, int y)
    {
        if (checkBounds(x,y))
        {
            System.out.println("[ERROR] Map: X oder Y ist zu groß/klein");
            return null;
        }
        else
        {
            return cell[x][y];
        }
    }

    public boolean checkBounds(int xC, int yC)
    {
        return (xC < x) && (xC >= 0) && (yC < y) && (yC >= 0);
    }

}
