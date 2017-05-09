public class Ver2
{
    private static final Ver2 VER = new Ver2();
    public static String verName = "0.0.1";
    
    private Ver2() {
        System.out.println("Version " + verName);
    }
    
    public static Ver2 getVer() {
        return VER;
    }
}
