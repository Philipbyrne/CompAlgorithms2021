import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

public class RussianPeasantsAlgorithm {

    public static int multiplyInts(int n1, int n2){
        int res = 0;//1
        if(n2>n1){
            int temp = n2;
            n2 = n1;
            n1 = temp;
        }
        while(n2 != 0){
            if(n2 % 2 == 1){
                res += n1;
            }
            n1 = n1*2;
            n2 = n2/2;
        }
        return res;
    }

    public static float multiplyFloats(float n1, float n2){
        float res = 0;
        if(n2>n1){
            float temp = n2;
            n2 = n1;
            n1 = temp;
        }
        while(n2 != 0){
            if(n2 % 2 == 1){
                res += n1;
            }
            n1 = n1*2;
            n2 = n2/2;
        }
        return res;
    }

    public static BigInteger multiplyBigInts(BigInteger n1, BigInteger n2){
        BigInteger res = BigInteger.valueOf(0);
        if(n2.compareTo(n1) == 1){
            BigInteger temp = n2;
            n2 = n1;
            n1 = temp;
        }
        while(n2.equals(BigInteger.valueOf(0)) == false){
            if(n2.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(1))){
                res = res.add(n1);
            }
            n1 = n1.multiply(BigInteger.valueOf(2));
            n2 = n2.divide(BigInteger.valueOf(2));
        }
        return res;
    }



    public static void main(String[] args){
        //Starts the stopwatch
        Stopwatch timer = new Stopwatch();

        //Multiplies ints and prints them out
        /*for(int i=0; i<100000000; i++){
            //generates two random ints to multiply
            int a = ThreadLocalRandom.current().nextInt(1, 100);
            int b = ThreadLocalRandom.current().nextInt(1, 100);
            multiplyInts(a,b);
        }*/

        /*for(int i=0; i<100000000; i++){
            //generates two random floats to multiply
            float a = ThreadLocalRandom.current().nextInt(1, 1000);
            float b = ThreadLocalRandom.current().nextInt(1, 1000);
            multiplyFloats(a,b);
        }*/

        //Multiplies bigints and prints them out
        for(int i=0; i<100000000; i++){
            //generates two random bigints to multiply
            BigInteger bigA = BigInteger.valueOf(ThreadLocalRandom.current().nextInt(1, 100));
            BigInteger bigB = BigInteger.valueOf(ThreadLocalRandom.current().nextInt(1, 100));
            multiplyBigInts(bigA,bigB);
        }

        //Prints out elapsed time
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}
