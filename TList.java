/**
*   List Implementation by Tim Guggenmos (C) 2017
*/

public class TList <T> {

    protected TElement<T> first;

    public boolean blockSameObj = true;
    public boolean blockNull = true;

    public TList() {
        first = new TEnd<T>();
    }

    public TList(T obj) {
        first = new TEnd<T>();
        add(obj);
    }

    public TList(T[] obj) {
        first = new TEnd<T>();
        add(obj);
    }

    public void _showList() {
        System.out.println("Print List (length = " + length() + "):");
        first._showList(0);
    }

    // count
    public int length() {
        return first.length();
    }

    // add obj in as first
    public void add(T obj) {
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
    public void add(T[] obj) {
        for (int i = obj.length - 1; i >= 0; i--) {
            add(obj[i]);
        }
    }

    // add obj in as last
    public void addLast(T obj) {
        insert(obj, length() - 1);
    }

    //add obj[] in as last - so that obj[0] == list[length()]
    public void addLast(T[] obj) {
        for (int i = 0; i < obj.length; i++) {
            insert(obj[i], length());
        }
    }

    // add obj at index
    public void insert(T obj, int id) {
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
    public void insert(T[] obj, int id) {
        for (int i = 0; i < obj.length; i++) {
            insert(obj[i], id + i);
        }
    }

    // return obj at index
    public T get(int id) {
        if (id >= 0) {
            return first.get(id, 0);
        } else {
            //System.out.println("[List] TList.get(id): id is outside of listrange");
            return null;
        }
    }

    // return index of obj
    public int getId(T obj) {
        return first.getId(obj, 0);
    }

    // remove obj at index
    public void remove(int id) {
        if (id >= 0) {
            first = first.remove(id, 0);
        } else {
            //System.out.println("[List] TList.remove(id): id is outside of listrange");
        }
    }

    // remove obj
    public void remove(T obj) {
        remove(getId(obj));
    }

    // remove and return obj at index
    public T take(int id) {
        if (id >= 0) {
            T obj = get(id);
            remove(id);
            return obj;
        } else {
            //System.out.println("[List] TList.take(id): id is outside of listrange");
            return null;
        }
    }

    // remove all from list
    public void empty() {
        first = new TEnd<T>();
    }
}
