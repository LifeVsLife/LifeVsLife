// author: Simone Stöckl2
// date: 08.05.2017
// ver 0.0.1


public class ZPlayerController
{
    ZPlayerList playerList; // Spieler + Zuschauer
    int playersCount; // Anzahl der aktiven Spieler
    int playersId[]; // Speichert die Id jedes aktiven Spielers
    
    /**
     * Konstruktor
     */
    public ZPlayerController(int playersCount){
        this.playersCount = playersCount;
        playersId = new int[playersCount];
    }
}
