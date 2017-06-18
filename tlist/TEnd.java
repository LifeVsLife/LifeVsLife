
package tlist;

public class TEnd <T> extends TElement <T>
{
    /**
     * Methode, die als Elementanzahl 0 zurückgibt
     */
    public int length()
    {
        return 0;
    }

    /**
     * bricht den Methodenaufruf ab
     */
    public void _showList(int thisId)
    {
        return; // oder leerer Methodenrumpf
    }

    /**
     * Methode, die den Wahrheitswert "true" zurückgibt, da beim Aufruf der Methode das Ende der Liste erreicht ist
     */
    public boolean end() {
        return true;
    }

    /**
     * Methode, die einen neuen Knoten am Ende der Liste einfügt, wenn es noch kein Element mit der gesuchten Id gibt. Dieser Knoten wird als Nachfolger des zuvorigen letzten Knotens gesetzt
     */
    public TElement<T> insert(T obj, int id, int thisId)
    {
        if (id != thisId) {
            //System.out.println("[LIST] TEnd.insert("+id+", "+thisId+"): just added at the end");
        }
        return new TNode<T>(obj, this);
    }

    /**
     * Methode, die null gibt, wenn es zu der gesuchten Id kein Objekt gibt
     */
    public T get(int id, int thisId)
    {
        //System.out.println("[LIST] TEnd.getId("+id+", "+thisId+"): id is not in the List");
        return null;
    }

    /**
     * Methode, die das Feld von Objekten und zugehöriger Id gibt
     */
    public T[] getArray(T[] array, int thisId)
    {
        return array;
    }

    /**
     * Methode, die -1 gibt, wenn es das gesuchte Objekt nicht gibt
     */
    public int getId(T obj, int thisId)
    {
        //System.out.println("[LIST] TEnd.getId(obj): obj is not in the list");
        return -1;
    }

    /**
     * Methode, die das aktuelle Element als Nachfolger zurückgibt, wenn die gesuchte Id nicht in der Liste enthalten ist
     */
    public TElement<T> remove(int id, int thisId)
    {
        //System.out.println("[LIST] TEnd.remove("+id+", "+thisId+"): id is not in the list");
        return this;
    }

}
