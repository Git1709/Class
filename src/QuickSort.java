
public class QuickSort {
    // Function to partition the array and return the pivot index
    int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // Choose the pivot element
        int i = low - 1; // Index of the smaller element

        // Traverse the array and swap elements if they are less than the pivot
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the pivot index
    }

    // Function to perform quicksort
    void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // Find pivot element such that
            // elements smaller than pivot are on the left and
            // elements greater than pivot are on the right
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after the pivot
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to print the array
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the QuickSort algorithm
    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
for(int x:arr){
    System.out.print(x+" ");
}

        QuickSort ob = new QuickSort();
        ob.quickSort(arr, 0, n - 1);

        System.out.println("\nSorted array:");
        ob.printArray(arr);
    }
}
