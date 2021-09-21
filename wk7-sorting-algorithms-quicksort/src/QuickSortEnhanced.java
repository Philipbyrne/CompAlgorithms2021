public class QuickSortEnhanced {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int start, int end){
        int median = medianOf3(start, start + (end-start)/2 , end);
        int pivot = arr[median];//Pivot set to median
        int pi = (start - 1);

        for(int j = start; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                pi++;
                swap(arr, pi, j);
            }
        }
        /*if(end <= start + 10){ for dealing with smaller data
            insertionSort(arr);
            return (pi + 1);
        }*/
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

    public static void quickSortEnhanced(int[] arr, int start, int end){
        shuffle(arr); //Shuffle before sorting
        quickSort(arr, start, end);
    }

    public static void insertionSort(int[] arr) {
        System.out.println("Insertion Sort");
        int len = arr.length;
        for (int i = 1; i < len; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        printArray(arr);
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

    public static void shuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * (i + 1));
            int swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

    public static int medianOf3(int a, int b, int c){
        if ((b < a && a < c) || (c < a && a < b)){
            return a;
        }else if ((a < b && b < c) || (c < b && b < a)){
            return b;
        }else {
            return c;
        }
    }

    public static void main(String args[]) {

        System.out.println("running Sorting main");

        int[] nums1000 = new int[1000];
        int[] nums10000 = new int[100000];
        populateArray(nums1000);
        populateArray(nums10000);

        Stopwatch time = new Stopwatch();

        quickSortEnhanced(nums10000, 0, nums10000.length-1);

        printArray(nums10000);
        StdOut.println("elapsed time = " + time.elapsedTime());
    }
}
