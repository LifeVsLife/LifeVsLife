/**
 * List Implementation by Tim Guggenmos (C) 2017
 * v.3
 */

import java.util.Iterator;

public class TList <T> implements Iterable <T> {

    protected TElement<T> first;

    public boolean blockSameObj = true;
    public boolean blockNull = true;

    public TList()
    {
        first = new TEnd<T>();
    }

    public TList(T obj)
    {
        first = new TEnd<T>();
        add(obj);
    }

    public TList(T[] obj)
    {
        first = new TEnd<T>();
        add(obj);
    }

    //

    public void _showList()
    {
        System.out.println("Print List (length = " + length() + "):");
        first._showList(0);
    }

    public int length() // == count
    {
        return first.length();
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

    // add obj[] in as first - so that: obj[0] == list[0]
    public void add(T[] obj)
    {
        for (int i = obj.length - 1; i >= 0; i--) {
            add(obj[i]);
        }
    }

    // add obj in as last
    public void addLast(T obj)
    {
        insert(obj, length() - 1);
    }

    //add obj[] in as last - so that obj[0] == list[length()]
    public void addLast(T[] obj)
    {
        for (int i = 0; i < obj.length; i++)
        {
            insert(obj[i], length());
        }
    }

    // add obj at index
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

    // add obj[] at index - so that: obj[0] == list[id]
    public void insert(T[] obj, int id)
    {
        for (int i = 0; i < obj.length; i++)
        {
            insert(obj[i], id + i);
        }
    }

    // return obj at index
    public T get(int id)
    {
        if (id >= 0) {
            return first.get(id, 0);
        } else {
            //System.out.println("[List] TList.get(id): id is outside of listrange");
            return null;
        }
    }

    @Deprecated
    public T[] getArray(T[] array) // feed this method with: new T[tlist.length()]
    {
        return first.getArray(array, 0);
    }

    // return index of obj
    public int getId(T obj)
    {
        return first.getId(obj, 0);
    }

    public boolean contains(T obj)
    {
        return getId(obj) >= 0;
    }

    // remove obj at index
    public void remove(int id)
    {
        if (id >= 0) {
            first = first.remove(id, 0);
        } else {
            //System.out.println("[List] TList.remove(id): id is outside of listrange");
        }
    }

    // remove obj
    public void remove(T obj)
    {
        remove(getId(obj));
    }

    // remove and return obj at index
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

    @Deprecated
    public T[] takeArray(T[] array) // feed this method with: new T[tlist.length()]
    {
        array = getArray(array);
        empty();
        return array;
    }

    // remove all from list
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
     * = length() - just because of implements Iterable<T>
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

}
