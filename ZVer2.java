


public class ZVer2
{
    private static final ZVer2 VER = new ZVer2();
    public static String verName = "0.0.1";
    
    private ZVer2() {
        System.out.println("Version " + verName);
    }
    
    public static ZVer2 getVer() {
        return VER;
    }
}
