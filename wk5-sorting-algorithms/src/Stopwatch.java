public class Stopwatch {
    private final long start = System.currentTimeMillis();

    public Stopwatch() {
    }

    public double elapsedTime() {
        long var1 = System.currentTimeMillis();
        return (double)(var1 - this.start) / 1000.0D;
    }

    public static void main(String[] var0) {
        int var1 = Integer.parseInt(var0[0]);
        Stopwatch var2 = new Stopwatch();
        double var3 = 0.0D;

        for(int var5 = 1; var5 <= var1; ++var5) {
            var3 += Math.sqrt((double)var5);
        }

        double var13 = var2.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", new Object[]{var3, var13});
        Stopwatch var7 = new Stopwatch();
        double var8 = 0.0D;

        for(int var10 = 1; var10 <= var1; ++var10) {
            var8 += Math.pow((double)var10, 0.5D);
        }

        double var12 = var7.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", new Object[]{var8, var12});
    }
}