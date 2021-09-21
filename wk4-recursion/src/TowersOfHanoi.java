public class TowersOfHanoi {

    static void towerOfHanoi(int disk, char source, char dest, char auxiliary)
    {
        if (disk == 1)
        {
            System.out.println("Move disk 1 from "+
                    source+" to "+dest);
            return;
        }
        towerOfHanoi(disk - 1, source, auxiliary, dest);
        System.out.println("Move disk "+ disk + " from " + source +" to " + dest );
        towerOfHanoi(disk - 1, auxiliary, dest, source);
    }

    public static void  main(String[] args)
    {
        int n = 4;
        towerOfHanoi(n, 'A', 'C', 'B');
    }
}

