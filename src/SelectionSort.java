class SelectionSort
{   //Rachit 22csu306

    void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
        {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
            {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        SelectionSort obj = new SelectionSort();
        int arr[] = { 8, -3, 5, 18, 2, -9 };

        System.out.println("Original Array : ");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }

        obj.sort(arr);
        System.out.println("\n\nSorted array");
        obj.printArray(arr);
    }
}