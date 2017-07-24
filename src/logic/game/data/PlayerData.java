
package logic.game.data;

// author: Simone Stöckl
// date: 08.05.2017
// ver 0.0.1

import java.io.Serializable;

import java.awt.Color; //Farben nach RGB für Spielerfarben

public class PlayerData implements Serializable
{
    private static final long serialVersionUID = 216849127351L;

    private String name; //Name des Spielers
    private Color color; //Spielerfarbe

    /**
     * Konstruktor der Klasse PlayerData
     */
    public PlayerData(String name){
        this.name = name;
    }

    /**
     * Methode, die den Namen ändert
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Methode, die den Namen zurückgibt
     */
    public String getName(){
        return name;
    }

    /**
     * Methode, die die Farbe ändert
     */
    public void setColor(Color color){
        this.color = color;
    }

    /**
     * Methode, die die Farbe zurückgibt
     */
    public Color getColor(){
        return color;
    }
}
