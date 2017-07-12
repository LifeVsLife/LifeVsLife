//auhor: Thomas Plank
//date: 10.07.17
//version: 0.0.3

package logic.game;

import lnet.box.InBox;

import java.io.ObjectInputStream;
//import java.io.IOException;

public class GameOfLife
{
    private Map map; // nur fürs lesen
    private MapController controller;

    public static int playerCount = 0;

    //private ObjectInputStream in;
    private InBox in;

    private int activePlayer = -1;


    public GameOfLife()
    {
        init(new Map(10,10));
    }

    public GameOfLife(Map map)
    {
        init(map);
    }

    private void init(Map map)
    {
        this.map = map;
        controller = new MapController(map);
    }

    public boolean doSinglePlayerMove()
    {
        PlayerMove move = null;
        try {
            move = in.<PlayerMove>read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (move != null) {
            if (moveIsAllowed(move)) {
                playerMove(move);
                return true;
            }
        }
        return false;
    }

    public boolean moveIsAllowed(PlayerMove move){
        return isActivePlayer(move.getPlayerId());
    }

    public boolean isActivePlayer(int id){
        return activePlayer == id;
    }

    private void playerMove(PlayerMove move) // player 0 macht kords 0,0 zu lebendig
    {
        controller.setCell(move.getX(), move.getY(), move.getCell());
    }

}
