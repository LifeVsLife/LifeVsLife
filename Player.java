//author: Simone Stöckl
//date: 08.05.2017
//ver 0.0.1

import java.io.Serializable;

/**
 *
 */
public class Player implements Serializable
{
    private static final long serialVersionUID = 1284521045273L;

    public int id; //zur eindeutigen Identifizierbarkeit
    public PlayerData playerData;

    /**
     * zwei Konstruktoren der Klasse Player
     */
    public Player(int id, String name)
    {
        this.id = id;
        this.playerData =  new  PlayerData(name);
    }

    /**
     *
     */
    public Player(int id, PlayerData playerData)
    {
        this.id = id;
        this.playerData = playerData;
    }

    /**
     * Methode, die die Id des Spielers gibt.
     */
    public int getId()
    {
        return id;
    }

    /**
     * TEST.
     */
    public void test()
    {
        System.out.println(this.getClass().getName());
    }
}
