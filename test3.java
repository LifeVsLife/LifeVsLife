public class test3<T>
{
    public T[] array;
    public test<T> test;

    /**
     * Constructor for objects of class test
     */
    public test3(T x)
    {
        array = (T[]) new Object[1];
        array[0] = x;
        test = new test<T>();
        
    }
    
    public test3()
    {
        array = (T[]) new Object[1];
        
    }
    
    public T get(int index) {
        return array[index];
    }
    
}
