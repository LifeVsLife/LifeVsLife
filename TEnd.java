
public class TEnd <T> extends TElement <T>
{

    public int length()
    {
        return 0;
    }

    public void _showList(int thisId)
    {
        return;
    }

    public boolean end() {
        return true;
    }

    public TElement<T> insert(T obj, int id, int thisId)
    {
        if (id != thisId) {
            //System.out.println("[LIST] TEnd.insert("+id+", "+thisId+"): just added at the end");
        }
        return new TNode<T>(obj, this);
    }



    public T get(int id, int thisId)
    {
        //System.out.println("[LIST] TEnd.getId("+id+", "+thisId+"): id is not in the List");
        return null;
    }

    public T[] getArray(T[] array, int thisId)
    {
        return array;
    }

    public int getId(T obj, int thisId)
    {
        //System.out.println("[LIST] TEnd.getId(obj): obj is not in the list");
        return -1;
    }

    public TElement<T> remove(int id, int thisId)
    {
        //System.out.println("[LIST] TEnd.remove("+id+", "+thisId+"): id is not in the list");
        return this;
    }

}
