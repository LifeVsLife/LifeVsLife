//auhor: Thomas Plank
//date: 08.05.17
//version: 0.0.3

package logic.game.map;

/**
 * Verwaltet die Map bzw. fügt Map mehr Funktionalität hinzu
 */
public class MapController
{
    /**
     * Die Regeln nach denen die Map eine Evolution ausführt
     */
    //private MapEvolutionRules rules;

    /**
     * Die Map
     */
    private Map map;
    //Cell[] cells = new Cell[8];

    /**
     * MapController Erstellung mit der Map
     */
    public MapController(Map map)
    {
        this.map = map;
    }

    public void setCell(int x, int y, Cell cell)
    {
        map.setCell(x, y, cell);
    }

    /**
     * Gibt ein Feld mit den umliegenden Cells (Cell[])
     */
    public Cell[] getSurroundingCells(int x, int y)
    {
        Cell[] cells = new Cell[8];
        int count = 0;
        for (int xc = 0; xc < 3; xc++)
        {
            for (int yc = 0; yc < 3; yc++)
            {
                int xb = x + xc - 1;
                int yb = y + yc - 1;

                cells[count] = map.getCell(xb, yb);

                count++;
            }
            count++;
        }
        return cells;

    }

    /**
     * Gibt die Anzahl aller lebenden Cells um die gewählte Cell an (int)
     */
    public int getLivingCellsAround(int x, int y)
    {
        Cell[] cells = getSurroundingCells(x, y);
        int alive = 0;

        for (int i = 0; i < cells.length; i++)
        {
            if (cells[i].isAlive())
            {
                alive++;
            }
        }
        return alive;
    }

    public int getDeadCellsAround(int x, int y)
    {
        return 8 - getLivingCellsAround(x, y);
    }

    /**
     * Gibt die lebenden Cells aller Spieler um eine Cell an (int[])
     * Format: array[playerId] = Anzahl dessen lebenden Cells in der Umgebung
     */
    public int[] getPlayerAliveCellsAround(int x, int y)
    {
        int playercount = 4; //fertig machen

        Cell[] cells = getSurroundingCells(x, y);
        int[] surroundingPlayer = new int[playercount];

        for(int i = 0; i < cells.length; i++)
        {
            if (cells[i].isAlive())
            {
                surroundingPlayer[cells[i].getPlayerId()]++;
            }
        }

        return surroundingPlayer;
    }

    public Map getMap()
    {
        return map;
    }

}
