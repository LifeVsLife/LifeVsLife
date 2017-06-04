/**
 * List for object with method "int key()" to find the object in an list with one key
 */
 
public class TListKey <T, K> extends TList <T> {

    @SuppressWarnings("unchecked")
    public int getIdWithKey(K key)
    {
        int l = length();
        for (int i = 0; i < l; i++) {
            if (((TListObject<K>) get(i)).key() == key) {
                return i;
            }
        }
        return -1;
    }

    public T getWithKey(K key)
    {
        int l = length();
        for (int i = 0; i < l; i++) {
            T obj = get(i);
            if (((TListObject) obj).key() == key) {
                return obj;
            }
        }
        return null;
    }

}
