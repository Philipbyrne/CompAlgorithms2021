public class QuickSort {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int pi = (start - 1);

        for(int j = start; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                pi++;
                swap(arr, pi, j);
            }
        }
        swap(arr, pi + 1, end);
        return (pi + 1);
    }

    public static void quickSort(int[] arr, int start, int end){
        if (start < end) {
            int piv = partition(arr, start, end);
            quickSort(arr, start, piv - 1);
            quickSort(arr, piv + 1, end);
        }
    }

    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void populateArray(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            if(i%2 == 0){
                arr[i] = 0;
            }else{
                arr[i] = i;
            }
        }
    }

    public static void shuffle(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [0, i]
            int r = (int) (Math.random() * (i + 1));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

    public static void main(String args[]) {

        System.out.println("running Sorting main");

        int[] nums1000 = new int[1000];
        int[] nums10000 = new int[100000];
        populateArray(nums1000);
        populateArray(nums10000);

        Stopwatch time = new Stopwatch();

        quickSort(nums10000, 0, nums10000.length-1);

        printArray(nums10000);
        StdOut.println("elapsed time = " + time.elapsedTime());
    }
}
