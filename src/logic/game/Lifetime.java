
package logic.game;

/**
 * gibt alles zum Thema Zeit an
 */
public class Lifetime
{
    int birthRound;
    //Speichert die Runde, in der die Zelle erstellt ("geboren") wurde.
    long birthGameSecond;
    //Speichert die Spielsekunde, in der die Zelle erstellt wurde.
   
    public Lifetime(int birthRound)
    {
       this.birthRound = birthRound;
        birthGameSecond = Time.time();
    }

    public int getRoundAge()
    {
        return birthRound;
    }

    public float getBirthGameSecond()
    {
        return birthGameSecond / 10^9;
    }

    /**
     * gibt die Lebensdauer einer Cell an
     */
    public float getLifeTime()
    {
        long end = System.nanoTime();
        return (end - birthGameSecond)/10^9;
    }


}
