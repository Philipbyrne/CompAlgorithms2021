import java.util.Random;

/**
 	* Implementation of various sorting algorithms
 	*
 	*
 	*/
public class Sorts_starter_code {

	public static void main(String args[]) {

		System.out.println("running Sorting main");
		int type = 2;

		int[] nums10 = new int[10];
		int[] nums1000 = new int[1000];
		int[] nums10000 = new int[10000];
		int[] nums100000 = new int[100000];

		populateArray(nums10);
		populateArray(nums1000);
		populateArray(nums10000);
		populateArray(nums100000);

		Stopwatch time = new Stopwatch();

		switch (type) {
			case 0:
				selectionSort(nums10);
				StdOut.println("elapsed time = " + time.elapsedTime());
				break;
			case 1:
				insertionSort(nums10);
				StdOut.println("elapsed time = " + time.elapsedTime());
				break;
			case 2:
				bogoSort(nums1000);
				StdOut.println("elapsed time = " + time.elapsedTime());
				break;
			default:
				System.err.printf("\nBad sort ID '%d'", type);
				System.exit(-2);
		}


	}


	// ***************************** Insertion Sort *****************************
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

	// ***************************** Selection Sort ****************************
	public static void selectionSort(int[] arr) {
		System.out.println("Selection Sort");
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[min_idx])
					min_idx = j;
			}
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
		printArray(arr);
	}

	// ***************************** Silly Sorts *****************************
	public static void bogoSort(int[] arr) {
		System.out.println("Bogo Sort");
		while (isSorted(arr) == false) {
			shuffle(arr);
		}
		printArray(arr);
	}

	//******shuffle helper for bogoSort
	// Knuth Shuffle
	private static void shuffle(int[] nums) {
		Random rand = new Random();
		int n, tmp;
		for (int i = nums.length - 1; i > 0; i--) {
			n = rand.nextInt(i + 1);
			tmp = nums[i];
			nums[i] = nums[n];
			nums[n] = tmp;
		}
	}

	//**helper function to check if your array is sorted or not
	public static boolean isSorted(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return false;
			}
		}
		return true;
	}

	//********print helper class*****
	// Prints the input array
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
}
