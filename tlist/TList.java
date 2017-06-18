
package tlist;

//author: Simone Stöckl, Tim Guggenmos
//date: 18.06.2017
//ver: 0.5.0

import java.util.Iterator;

// Importierung des Iterators (kann alle Elemente nacheinander auslesen)
public class TList <T> implements Iterable <T> {

    protected TElement<T> first;

    public boolean blockSameObj = true;
    public boolean blockNull = true;

    // drei verschiedene Konstruktoren:
    /**
     * Konstruktor, bei dem die Anfangsreferenz auf ein Objekt der Klasse TEnd gelegt wird
     */
    public TList()
    {
        first = new TEnd<T>();
    }

    /**
     * Konstruktor, bei dem die Anfangsreferenz auf ein Objekt der Klasse TEnd gelegt wird und zugleich ein Objekt eingefügt wird
     */
    public TList(T obj)
    {
        first = new TEnd<T>();
        add(obj);
    }

    /**
     * Konstruktor, bei dem die Anfangsreferenz auf ein Objekt der Klasse TEnd gelegt wird und zugleich ein Feld mit Typ Objekt hinzugefügt wird
     */
    public TList(T[] obj)
    {
        first = new TEnd<T>();
        add(obj);
    }

    /**
     * Methode, die das erste TElement aufruft die Liste auszugeben. Ihm wird 0 als aktuelle Id (=Id des ersten TElements gegeben
     */
    public void _showList()
    {
        System.out.println("Print List (length = " + length() + "):");
        first._showList(0);
    }

    /**
     * Methode, die die Elemente zählt
     */
    public int length() // == count
    {
        return first.length();
    }


    /**
     * Methode, die einen Knoten (mit einem bestimmten Objekt) am Anfang der Liste einfügt
     * -> add obj in as first
     */
    public boolean isEmpty()
    {
        return length() == 0;
    }

    // add obj in as first
    public void add(T obj)
    {
        if (!(obj == null && blockNull)) {
            if (!blockSameObj || getId(obj) < 0) {
                first = new TNode<T>(obj, first);
            } else {
                System.out.println("[List] TList.add(obj): obj already in the list - no douplet added");
            }
        } else {
            //System.out.println("[List] TList.add(obj): obj == null - not added");
        }
    }

    /**
     * Methode, die ein Objekt in dem Feld einfügt
     * -> add obj[] in as first - so that: obj[0] == list[0]
     */
    public void add(T[] obj)
    {
        for (int i = obj.length - 1; i >= 0; i--) { //for-Schleife zählt i von der Feldlänge von obj bis 0
            add(obj[i]);
        }
    }

    /**
     * Methode, die die Methode insert aufruft und so einen Knoten am Ende der Liste einfügt
     * -> add obj in as last
     */
    public void addLast(T obj)
    {
        insert(obj, length());
    }

    /**
     * Methode, die die Methode insert aufruft und so das Objekt am Anfang des Feldes einfügt, was in der Liste am Ende steht
     * -> add obj[] in as last - so that obj[0] == list[length()]
     */
    public void addLast(T[] obj)
    {
        for (int i = 0; i < obj.length; i++)
        {
            insert(obj[i], length());
        }
    }

    /**
     * Methode, die ein Objekt mit einem bestimmter Id einfügt
     * -> add obj at index
     */
    public void insert(T obj, int id)
    {
        if (!(obj == null && blockNull)) {
            if (id >= 0) {
                first = first.insert(obj, id, 0);
            } else {
                //System.out.println("[List] TList.insert(obj, id): id is outside of listrange");
            }
        } else {
            //System.out.println("[List] TList.insert(obj, id): obj == null - not inserted");
        }
    }

    /**
     * Methode, die ein Objekt in das Feld mit dessen Id als Index einfügt
     * -> add obj[] at index - so that: obj[0] == list[id]
     */
    public void insert(T[] obj, int id)
    {
        for (int i = 0; i < obj.length; i++)
        {
            insert(obj[i], id + i);
        }
    }

    /**
     * Methode, die das zu einer Id gehörige Objekt gibt
     * -> return obj at index
     */
    public T get(int id)
    {
        if (id >= 0) {
            return first.get(id, 0);
        } else {
            //System.out.println("[List] TList.get(id): id is outside of listrange");
            return null;
        }
    }

    @Deprecated //folgender Code ist veraltert:
    public T[] getArray(T[] array) // feed this method with: new T[tlist.length()]
    {
        return first.getArray(array, 0);
    }

    /**
     * Methode, die die Id eines Objekts gibt
     * -> return index of obj
     */
    public int getId(T obj)
    {
        return first.getId(obj, 0);
    }

    /**
     * Methode, die den Wahrheitswert gibt, ob die Id eines Objektes >= 0 ist (also existiert) oder nicht
     */
    public boolean contains(T obj)
    {
        return getId(obj) >= 0;
    }

    /**
     * Methode, die das zu einer Id gehörige Objekt entfernt
     * -> remove obj at index
     */
    public void remove(int id)
    {
        if (id >= 0) {
            first = first.remove(id, 0);
        } else {
            //System.out.println("[List] TList.remove(id): id is outside of listrange");
        }
    }

    /**
     * Methode, die die Methode void remove(int id) aufruft und so ein bestimmtes Objekt entfernt
     */
    public void remove(T obj)
    {
        remove(getId(obj));
    }

    /**
     * Methode, die ein zu einer Id gehöriges Objekt entfernt und dieses ausgibt
     * -> remove obj
     */
    public T take(int id)
    {
        if (id >= 0) {
            T obj = get(id);
            remove(id);
            return obj;
        } else {
            //System.out.println("[List] TList.take(id): id is outside of listrange");
            return null;
        }
    }

    @Deprecated //folgender Code ist veraltert:
    public T[] takeArray(T[] array) // feed this method with: new T[tlist.length()]
    {
        array = getArray(array);
        empty();
        return array;
    }

    /**
     * Methode, die alle Objekte der Liste entfernt
     * -> remove all from list
     */
    public void empty()
    {
        first = new TEnd<T>();
    }


    // implements Iterable<T> for foreach capabilities

    // for (T obj : list) {
    //     //body of the loop
    // }
    // is the same as:
    // for (Iterator<T> iter = list.iterator(); iter.hasNext(); ) {
    //     T obj = iter.next();
    //     //body of the loop
    // }

    /**
     * Methode, die die Länge gibt
     * size() = length() - just needed because of implements Iterable<T>
     */
    public int size()
    {
        return length();
    }


    //already defined
    //public T get(int i) { /*... */ }

    /**
     * Returns a TListIterator<T>
     */
    public Iterator<T> iterator() {
        return new TListIterator();
    }

    /**
     * TListIterator has methods hasNext(), next() (and remove()) for foreach capabilities
     */
    class TListIterator implements Iterator<T> {

        private int index = 0;

        public boolean hasNext() {
            return index < size();
        }

        public T next() {
            return get(index++);
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported yet");

        }
    }

    public static void main(String[] args)
    {
        TList<String> list = new TList<String>("First");
        list.addLast("Last");
        list._showList();
    }

}
