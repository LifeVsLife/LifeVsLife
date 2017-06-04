
import java.io.Serializable;

public abstract class DataPackage implements Serializable
{
    private static final long serialVersionUID = 51924176124L;

    int playerId = -2; //-1 ^= server

    public DataPackage()
    {
        //playerId = Client.player.id;
    }

}
