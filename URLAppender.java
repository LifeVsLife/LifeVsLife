
import java.net.URL;

public class URLAppender {

    public static URL append(String url0, String url1)
    {
        try {
            if (url0.charAt(url0.length() - 1) == '/') {
                return new URL(url0 + url1);
            }
            return new URL(url0 + "/" + url1);
        } catch (Exception e) {
            return null;
        }
    }

    public static URL append(URL url0, String url1)
    {
        return append(url0.toString(), url1);
    }

    public static URL append(URL url0, URL url1)
    {
        return append(url0.toString(), url1.toString());
    }

}
