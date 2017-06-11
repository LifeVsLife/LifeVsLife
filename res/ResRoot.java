
package res;

public class ResRoot {

    public ResRoot()
    {
        System.out.println("hm");
    }

    public static void main(String[] args)
    {
        System.out.println(ResRoot.class.getResource(""));
    }

}
