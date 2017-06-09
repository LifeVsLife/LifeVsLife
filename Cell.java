
// author:   Marco Kist
// date:     08.05.17
// version:  0.0.3

public class Cell
{
    private int playerId;
    //private Lifetime lifetime;
    //     private int cellColor;

    public Cell(int playerId)
    {
        this.playerId = playerId;
        //playerColor = cellColor;
    }

    public void setPlayerId()
    {
        this.playerId = playerId;
    }

    public int getPlayerId()
    {
        return playerId;
    }

    // solange der PlayerID-Wert größer als -1 ist ist die Zelle am Leben
    public boolean isAlive()
    {
        return idIsAlive(playerId);
    }

    private static boolean idIsAlive(int id) {
        return id > -1;
    }



}
