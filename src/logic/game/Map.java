//auhor: Thomas Plank
//date: 08.05.17
//version: 0.0.3

package logic.game;

/**
 * speichern der Cells
 *
 */

public class Map
{
    private int x;
    private int y;
    private Cell[][] cells;

    public Map(int x, int y)
    {
        this.x = x;
        this.y = y;
        Cell cells[][] = new Cell[x][y];
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setCell(int x, int y, Cell cell)
    {
        cells[x][y] = cell;
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
            return cells[x][y];
        }
    }

    public boolean checkBounds(int xC, int yC)
    {
        return (xC < x) && (xC >= 0) && (yC < y) && (yC >= 0);
    }

}
