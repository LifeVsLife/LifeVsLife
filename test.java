public class test<T>
{
    public T[] array;
    public test3<T> test;

    /**
     * Constructor for objects of class test
     */
    public test(T x)
    {
        array = (T[]) new Object[1];
        array[0] = x;
        test = new test3<T>();
        
    }
    
    public test()
    {
        array = (T[]) new Object[1];
        test = new test3();
        
    }
    
    public T get(int index) {
        return array[index];
    }
    
}
