// author: Simone Stöckl
// date: 08.05.2017
// ver 0.0.1
public class PlayerController
{
    PlayerList playerList; // Spieler + Zuschauer
    int playersCount; // Anzahl der aktiven Spieler
    int playersId[]; // Speichert die Id jedes aktiven Spielers
    
    /**
     * Konstruktor
     */
    public PlayerController(int playersCount){
        this.playersCount = playersCount;
        playersId = new int[playersCount];
    }
}
