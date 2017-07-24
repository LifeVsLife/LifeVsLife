
package math.function;

public abstract class TMath
{

    public static float soft(final float x)
    {
        if (x < 0) {
            return late(0);
        } else if (x > 1) {
            return late(1);
        } else {
            return (float) (-2 * Math.pow(x, 3) + 3 * Math.pow(x, 2));
        }
    }

    public static float late(final float x)
    {
        if (x < 0) {
            return late(0);
        } else if (x > 1) {
            return late(1);
        } else {
            return (float) Math.pow(soft(x), 2);
        }
    }

    public static float slowing(final float x)
    {
        return slowing(x, 2);
    }

    public static float slowing(final float x, final float degree)
    {
        return -(float)Math.pow(-x + 1, degree) + 1;
    }

    public static float function(final float x, Function f)
    {
        if (x < 0) {
            return f.function(0);
        } else if (x > 1) {
            return f.function(1);
        } else {
            return f.function(x);
        }
    }

    private static boolean checkInput(final float x)
    {
        boolean invalid = x < 0 || x > 1;
        if (invalid) {
            System.out.println("[TMath] Please only input values between 0 and 1!");
        }
        return !invalid;
    }

    public static void main(String[] args)
    {
        //System.out.println(TMath.function(0.4f, x -> (float)Math.pow(x,2)));
    }
}

interface Function
{
    float function(final float x);
}
