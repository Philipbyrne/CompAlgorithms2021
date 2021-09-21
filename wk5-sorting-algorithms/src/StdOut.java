import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public final class StdOut {
    private static final String CHARSET_NAME = "UTF-8";
    private static final Locale LOCALE;
    private static PrintWriter out;

    private StdOut() {
    }

    public static void println() {
        out.println();
    }

    public static void println(Object var0) {
        out.println(var0);
    }

    public static void println(boolean var0) {
        out.println(var0);
    }

    public static void println(char var0) {
        out.println(var0);
    }

    public static void println(double var0) {
        out.println(var0);
    }

    public static void println(float var0) {
        out.println(var0);
    }

    public static void println(int var0) {
        out.println(var0);
    }

    public static void println(long var0) {
        out.println(var0);
    }

    public static void println(short var0) {
        out.println(var0);
    }

    public static void println(byte var0) {
        out.println(var0);
    }

    public static void print() {
        out.flush();
    }

    public static void print(Object var0) {
        out.print(var0);
        out.flush();
    }

    public static void print(boolean var0) {
        out.print(var0);
        out.flush();
    }

    public static void print(char var0) {
        out.print(var0);
        out.flush();
    }

    public static void print(double var0) {
        out.print(var0);
        out.flush();
    }

    public static void print(float var0) {
        out.print(var0);
        out.flush();
    }

    public static void print(int var0) {
        out.print(var0);
        out.flush();
    }

    public static void print(long var0) {
        out.print(var0);
        out.flush();
    }

    public static void print(short var0) {
        out.print(var0);
        out.flush();
    }

    public static void print(byte var0) {
        out.print(var0);
        out.flush();
    }

    public static void printf(String var0, Object... var1) {
        out.printf(LOCALE, var0, var1);
        out.flush();
    }

    public static void printf(Locale var0, String var1, Object... var2) {
        out.printf(var0, var1, var2);
        out.flush();
    }

    public static void main(String[] var0) {
        println("Test");
        println((int)17);
        println(true);
        printf("%.6f\n", 0.14285714285714285D);
    }

    static {
        LOCALE = Locale.US;

        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
        } catch (UnsupportedEncodingException var1) {
            System.out.println(var1);
        }

    }
}
