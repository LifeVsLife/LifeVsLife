/**
 * gibt alles zum Thema Zeit an
 */
public class Lifetime
{
    int birthRound;
    long birthGameSecond;
    public Lifetime(int birthRound)
    {
        for(int i = 0;i < Integer.MAX_VALUE; i++)
        {
          birthRound = i;
        }
        birthGameSecond = System.nanoTime();
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
