
public class TNode <T> extends TElement <T> {

    protected TElement<T> next;
    protected T obj;

    public TNode(T obj, TElement<T> next)
    {
        this.obj = obj;
        this.next = next;
    }

    public void _showList(int thisId) {
        System.out.println("["+thisId+"] = " + obj);
        next._showList(thisId + 1);
    }

    //private void setNext(TElement next) {
    //    this.next = next;
    //}

    // private TElement getNext() {
    //     return next;
    // }

    // private void setObj(T obj) {
    //     this.obj = obj;
    // }

    // public T getObj() {
    //     return obj;
    // }

    public int length() {
        return next.length() + 1;
    }

    //public boolean end() {
    //    return false;
    //}

    public TElement<T> insert(T obj, int id, int thisId) {
        if (id == thisId) {
            return new TNode<T>(obj, this);
        } else {
            next = next.insert(obj, id, thisId + 1);
            return this;
        }
    }

    public T get(int id, int thisId) {
        if (id == thisId) {
            return this.obj;
        } else {
            return next.get(id, thisId + 1);
        }
    }

    public int getId(T obj, int thisId) {
        if (obj == this.obj) {
            return thisId;
        } else {
            return next.getId(obj, thisId + 1);
        }
    }

    public TElement<T> remove(int id, int thisId) {
        if (id == thisId) {
            return this.next;
        } else {
            next = next.remove(id, thisId + 1);
            return this;
        }
    }

}
