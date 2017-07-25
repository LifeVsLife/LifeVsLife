//author: Moritz Höcker, Jonas Reichert
//date: 08.05.2017
//ver: 0.0.1

package logic.game.map;

public class MapEvolutionRules
{

    MapController con;
    Map map;
    int feld2D [][];
    int x,y, maxPlayer;
    public MapEvolutionRules(MapController n)
    {
        con = n;
        map = con.getMap();
        x=map.getX();
        y=map.getY();
        feld2D = new int [x][y] ;
        maxPlayer=4; //Änderung
    }

    public void evolucian()//Hauptmethode
    {
        for(int i = 0; i<x;i++)
        {
            for(int k = 0; k<y;k++)
            {
                if(map.getCell(i,k) == null) //tote Zelle
                {
                    feld2D[i][k] = -1;
                    int speicher [] = con.getPlayerAliveCellsAround(i,k);
                    for (int l = 0; l > 4; l++)
                    {
                        if(speicher [l] == 3)
                        {
                         if( vergleichen(i,k)== false)
                         {
                            feld2D[i][k] = l;
                         }
                        }
                    }
                }
                else //lebende Zelle
                {
                    if(playercells(i,k)<2 ^ playercells(i,k)>3)
                    {
                        feld2D[i][k] = -1;
                        if(playercells(i,k)<2)
                        {
                            for(int m = 0; m < 4; m++)
                            {
                                if(cellsId(i,k,m) > playercells(i,k)+1)
                                {
                                   if(vergleichen(i,k)==false)
                                   {
                                      feld2D [i][k] = m;
                                   }
                                }
                            }
                        }
                    }
                    else
                    {
                        ueberpruefen(i,k);//falls sie nicht tot ist und nicht stirbt...überpruefen
                    }
                }
            }
        }
        Swap();
    }

    public int playercells(int x, int y)
    {
        return con.getPlayerAliveCellsAround(x,y)[map.getCell(x,y).getPlayerId()];
    }

    public int cellsId(int x, int y, int id)
    {
        return con.getPlayerAliveCellsAround(x,y)[id];
    }

    public boolean vergleichen(int x, int y)
    {
        boolean j = false;
        for(int i = 0; i<4; i++)
        {
            for(int z = 0; z<4;z++)
            {
            if( i == z)
            {}
            else
            {
                if(cellsId(x,y,i) == cellsId(x,y,z))
                {
                  if(cellsId(x,y,i)==3 ^ cellsId(x,y,i) ==4)
                  {
                    j = true;
                  }
                }
            }
        }
        }
        return j;
    }

    public void ueberpruefen(int x, int y)//schaut ob Gegner mehr Zellen hat als selbst
    {
        for(int k=0; k<4; k++)
        {
            boolean j = false;
            if(cellsId(x,y,k)>playercells(x,y)+1)
            {
                for(int z = 0; z<4;z++)
                {
                    if(cellsId(x,y,k)==cellsId(x,y,z))
                    {
                        j = true;
                    }
                }
                if(j != true)//bei false Änderumg der Zelle
                {
                    feld2D[x][y] = k;
                }
            }
        }
    }
     public void Swap ()//Updatet original F
    {
        for( int i = 0; i < x; i++)
        {
            for( int c = 0; c < y; c++)
            {
                map.setCell(i,c,new Cell(feld2D[i][c]));
            }
        }
    }
}
