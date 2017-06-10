
import java.net.URL;
import java.net.MalformedURLException;

public class URLAppender {

    public static URL append(String url0, String url1) throws MalformedURLException
    {
        if (url0.charAt(url0.length() - 1) == '/') {
            return new URL(url0 + url1);
        }
        return new URL(url0 + "/" + url1);
    }

    public static URL append(URL url0, String url1) throws MalformedURLException
    {
        if (url0 != null) {
            return append(url0.toString(), url1);
        } else {
            return new URL(url1);
        }
    }

    public static URL append(URL url0, URL url1) throws MalformedURLException
    {
        if (url0 != null) {
            if (url1 != null) {
                return append(url0.toString(), url1.toString());
            } else {
                return url0;
            }
        } else {
            return url1;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(Resources.resPath);
    }

}
