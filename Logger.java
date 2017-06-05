// author: Tim Guggenmos
// date: 09.05.2017
// ver: 0.0.1

//used like this:
// Logger.error(this.getClass(), "methodName", "das ist die Problem-Beschreibung");
// Logger.info(this.getClass(), "methodName", "das ist eine Information, nichts weltveränderndes");
// Logger.warning(this.getClass(), "methodName", "das ist eine Warnung, nichts was einen Crash verursacht aber naja");
public class Logger //
{
    public static String[] types = {"DEBUG", "INFO", "WARNING", "ERROR", "n/a"};
    public static boolean[] diabledTypes = {false, false, true, false, false};
    public static String[] customDisabledTypes = {};
    public static boolean allowCustomTypes = true;

    public static void info(Class classN, String methodName, String desc) {
        log(classN, methodName, desc, "INFO");
    }

    public static void warning(Class classN, String methodName, String desc) {
        log(classN, methodName, desc, "WARNING");
    }

    public static void error(Class classN, String methodName, String desc) {
        log(classN, methodName, desc, "ERROR");
    }

    public static void debug(Class classN, String methodName, String desc) {
        log(classN, methodName, desc, "DEBUG");
    }

    public static void custom(Class classN, String methodName, String desc, String type) {
        log(classN, methodName, desc, type);
    }

    public static void custom(String className, String methodName, String desc, String type) {
        log(className, methodName, desc, type);
    }

    public static void log(String desc) // log is of type "n/a"
    {
        System.out.println("[n/a] " + desc + ";");
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
        //check if it is one of the default types which is disabled/enabled
        for (int i = 0; i < types.length; i++) {
            if (types[i] == type) {
                if (!diabledTypes[i]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        //check if it is a custom diabled type
        for (int i = 0; i < customDisabledTypes.length; i++) {
            if (customDisabledTypes[i] == type) {
                return false;
            }
        }
        //if it is not a default enabled type then it is a custom type, are they enabled?
        return allowCustomTypes;
    }
}
