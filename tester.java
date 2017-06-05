
/**
 * Write a description of class tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class tester
{
    // instance variables - replace the example below with your own
    private int x;
    Ver[] v1;
    Ver[] v2;

    /**
     * Constructor for objects of class tester
     */
    public tester()
    {
        v1 = (Ver[]) java.lang.reflect.Array.newInstance((new Ver()).getClass(), 2);
        v2 = (Ver[]) new Object[3];
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
