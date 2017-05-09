// author: Tim Guggenmos (hi)
// date: 09.05.2017
// ver 0.0.1

//used like this:
// Logger.error(this.getClass(), "methodName", "das ist die Problem-Beschreibung");
// Logger.info(this.getClass(), "methodName", "das ist eine Information, nichts weltveränderndes");
// Logger.warning(this.getClass(), "methodName", "das ist eine Warnung, nichts was einen Crash verursacht aber naja");
public class Logger
{
    public static String[] types = {"INFO", "WARNING", "ERROR", "n/a"};
    public static boolean[] typeDeactivated = {false, false, false, false};

    public static boolean allowCustomTypes = true;

    public static void info(Class classN, String methodName, String desc) {
        int importance = 0;
        log(classN, methodName, desc, importance);
    }

    public static void warning(Class classN, String methodName, String desc) {
        int importance = 1;
        log(classN, methodName, desc, importance);
    }

    public static void error(Class classN, String methodName, String desc) {
        int importance = 2;
        log(classN, methodName, desc, importance);
    }

    public static void custom(Class classN, String methodName, String desc, String type) {
        log(classN, methodName, desc, type);
    }
    
    public static void custom(String className, String methodName, String desc, String type) {
        log(className, methodName, desc, type);
    }

    private static void log(Class className, String methodName, String desc, int importance) {
        String type;
        if (importance == 0) {
            type = "INFO";
        } else if (importance == 1) {
            type = "WARNING";
        } else if (importance == 2) {
            type = "ERROR";
        } else {
            type = "n/a";
        }

        log(className.getName(), methodName, desc, type);
    }

    private static void log(Class classN, String methodName, String desc, String type) {
        log(classN.getName(), methodName, desc, type);
    }

    private static void log(String className, String methodName, String desc, String type) {
        if (isTypeEnabled(type)) {
            String methodString = "";
            if (methodName != null) {
                if (methodName != "") {
                    methodString = "." + methodName;
                }
            }
            
            System.out.println("[" + type + "] " + className + methodString + ": " + desc + ";");
        }
    }

    public static boolean isTypeEnabled(String type) {
        for (int i = 0; i < types.length; i++) {
            if (types[i] == type) {
                if (!typeDeactivated[i]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return allowCustomTypes;
    }
}
