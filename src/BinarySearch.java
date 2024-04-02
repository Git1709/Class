public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the target is found at the middle, return its index
            if (arr[mid] == target) {
                return mid;
            }
            // If the target is greater than the middle element,
            // search only in the right half
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            // If the target is less than the middle element,
            // search only in the left half
            else {
                right = mid - 1;
            }
        }
        // If the target is not found in the array, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 1;
        int result = binarySearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
