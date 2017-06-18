
package tlist;

public class TNode <T> extends TElement <T> {

    protected TElement<T> next;
    protected T obj;

    /**
     * Konstruktor
     */
    public TNode(T obj, TElement<T> next)
    {
        this.obj = obj;
        this.next = next;
    }

    /**
     * rekursive Methode, die die Id und das zugehörige Objekt (-> Spieler) ausgibt
     */
    public void _showList(int thisId) {
        System.out.println("["+thisId+"] = " + obj);
        next._showList(thisId + 1);
    }

    /**
     * Methode, die ein neues Element als Nachfolger setzt
     */
    //private void setNext(TElement next) {
    //    this.next = next;
    //}

    /**
     * Methode, die den Nachfolger gibt
     */
    // private TElement getNext() {
    //     return next;
    // }

    /**
     * Methode, die ein neues Objekt setzt
     */
    // private void setObj(T obj) {
    //     this.obj = obj;
    // }

    /**
     * Methode, die die Id eines Objekts gibt
     */
    public T getObj() {
        return obj;
    }

    /**
     * Methode, die die Anzahl an Elementen gibt (-> count)
     */
    public int length() {
        return next.length() + 1;
    }

    /**
     * Methode, die den Wahrheitswert "false" zurückgibt, da das Ende der Liste hier noch nicht erreicht ist
     */
    public boolean end() {
        return false;
    }

    /**
     * Methode, die einen neuen Knoten in die Liste einfügt, wenn die gegebene Id mit der des Elements übereinstimmt, und die neuen Nachfolgereferenzen festlegt
     */
    public TElement<T> insert(T obj, int id, int thisId) {
        if (id == thisId) {
            return new TNode<T>(obj, this);
        } else {
            next = next.insert(obj, id, thisId + 1);
            return this;
        }
    }

    /**
     * Methode, die das zu einer Id gehörige Objekt ausgibt
     */
    public T get(int id, int thisId) {
        if (id == thisId) {
            return this.obj;
        } else {
            return next.get(id, thisId + 1);
        }
    }

    /**
     * Methode, die die Objekte in einem Feld mit der zugehörigen Id als Index speichert
     */
    public T[] getArray(T[] array, int thisId)
    {
        array[thisId] = obj;
        return next.getArray(array, thisId + 1);
    }

    /**
     * Methode, die die zu einem Objekt gehörige Id gibt
     */
    public int getId(T obj, int thisId) {
        if (obj == this.obj) {
            return thisId;
        } else {
            return next.getId(obj, thisId + 1);
        }
    }

    /**
     * Methode, die das zu einer Id gehörige Objekt entfernt
     */
    public TElement<T> remove(int id, int thisId) {
        if (id == thisId) {
            return this.next;
        } else {
            next = next.remove(id, thisId + 1);
            return this;
        }
    }

}
