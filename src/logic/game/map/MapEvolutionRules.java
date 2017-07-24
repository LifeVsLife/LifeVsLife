//author: Moritz Höcker, Jonas Reichert, tiim
//date: 08.05.2017
//ver: 0.0.1

package logic.game.map;

public class MapEvolutionRules
{
    // 1.  weniger als 2 nachbarn          => Tod
    // 2.  tote Zelle mit genau 3 nachbarn => Leben
    // 3.  mehr als 3 nachbarn             => Tod
    // 4.  2 oder 3 nachbarn               => keine Veränderung  (UNNÖTIG)
    //
    // 5. 3 gleichfarbige nachbarn         => Farbänderung
    //


    public MapEvolutionRules()
    {
    }
}
