public class MergeSortEnhanced {
    private static final int CUTOFF = 100;

    public static void merge(int[] arr, int lo, int mid, int hi)
    {
        /*if(hi <= lo + CUTOFF){
            insertionSort(arr);
            return;
        }*/
        int n1 = mid - lo + 1;
        int n2 = hi - mid;
        int[] l = new int[n1];
        int[] r = new int[n2];
        if (n1 >= 0) System.arraycopy(arr, lo, l, 0, n1);
        for (int j = 0; j < n2; ++j)
            r[j] = arr[mid + 1 + j];
        int i = 0, j = 0;
        int k = lo;
        while (i < n1 && j < n2) {
            if (l[i] <= r[j]) {
                arr[k] = l[i];
                i++;
            }
            else {
                arr[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = l[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = r[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] arr, int l, int r)
    {
        if (l < r) {
            int m = l + (r-l)/2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
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
    }

    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
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

    public static void main(String args[]) {

        System.out.println("running Sorting main");

        int[] nums10 = new int[10];
        int[] nums1000 = new int[1000];
        int[] nums10000 = new int[10000];
        int[] nums100000 = new int[100000];
        int[] nums1000000 = new int[1000000];

        populateArray(nums10);
        populateArray(nums1000);
        populateArray(nums10000);
        populateArray(nums100000);
        populateArray(nums1000000);
        Stopwatch time = new Stopwatch();
        MergeSortEnhanced arr = new MergeSortEnhanced();
        arr.sort(nums1000000, 0, nums1000000.length - 1);
        printArray(nums1000000);
        StdOut.println("elapsed time = " + time.elapsedTime());
    }
}
