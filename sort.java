// Since the data is too large, the program will return stack overflow error
// To be able to run this program, command "java -Xss4m sort" in the terminal 
// This modigies the max size of the memory to 4MB instead of 1MB like usual

import java.util.*;
import java.io.*;

public class sort{
    private static int comparisons = 0;
    private static int movements = 0;

    public static int getComparisons() {
        return comparisons;
    }

    public static int getMovements() {
        return movements;
    }

    public static void reset() {
        comparisons = 0;
        movements = 0;
    }

    public static void arrayCopy(int[] arr, int[] arrCopy) {
        for (int i = 0; i < arr.length; i++) {
            arrCopy[i] = arr[i];
        }
    }

    public static void main (String[] args){
        try{
            File file = new File("integers.txt");
            Scanner input = new Scanner(file);
            int[] RandomOrder = new int[50000];
            int[] InOrder = new int[50000];
            int[] ReverseOrder = new int[50000];
            while(input.hasNext()){
                for(int i = 0; i < RandomOrder.length; i++){
                    RandomOrder[i] = input.nextInt();
                    InOrder[i] = RandomOrder[i];
                    ReverseOrder[i] = RandomOrder[i];
                }
            }
            input.close();
            inOrderSort(InOrder);
            reverseOrderSort(ReverseOrder);

            int[] example = {2,5,1,3,4};

            /*-------------------------------------------------------- RANDOM ORDER LIST SORTING --------------------------------------------------------------*/

            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("Random Order list:");

            int[] arrCopy = new int[RandomOrder.length];
            // Create String and int variables to store the results
            String compareResult;
            int compareMin = 0;
            String timeResult;
            int timeMin;
            String moveResult;
            int moveMin;

            // Implementing Insertion Sort
            System.out.println("\tInsertion Sort:");
            arrayCopy(RandomOrder, arrCopy);
            // Start the timer
            long start = System.currentTimeMillis();
            insertionSort(arrCopy);
            long end = System.currentTimeMillis();
            // Stop the timer
            // Calculate the duration
            long duration = end - start;
            // Print the duration, comparisons, and movements
            System.out.println("\t\tTime taken for Insertion Sort: " + duration + " milliseconds");
            int insertionSortComparisons = getComparisons();
            int insertionSortMovements = getMovements();
            System.out.println("\t\tNumber of comparisons for Insertion Sort: " + insertionSortComparisons);
            System.out.println("\t\tNumber of movements for Insertion Sort: " + insertionSortMovements);
            // Reset the comparisons and movements
            reset();
            // Store the results for comparison
            compareMin = insertionSortComparisons;
            timeMin = (int) duration;
            moveMin = insertionSortMovements;
            timeResult = "Insertion Sort";
            moveResult = "Insertion Sort";
            compareResult = "Insertion Sort";

            // Implementing Selection Sort
            System.out.println("\tSelection Sort:");
            arrayCopy(RandomOrder, arrCopy);
            start = System.currentTimeMillis();
            selectionSort(arrCopy);
            end = System.currentTimeMillis();
            duration = end - start;
            System.out.println("\t\tTime taken for Selection Sort: " + duration + " milliseconds");
            int selectionSortComparisons = getComparisons();
            int selectionSortMovements = getMovements();
            System.out.println("\t\tNumber of comparisons for Selection Sort: " + selectionSortComparisons);
            System.out.println("\t\tNumber of movements for Selection Sort: " + selectionSortMovements);
            reset();
            if (selectionSortComparisons < compareMin) {
                compareMin = selectionSortComparisons;
                compareResult = "Selection Sort";
            }
            if (duration < timeMin) {
                timeMin = (int) duration;
                timeResult = "Selection Sort";
            }
            if (selectionSortMovements < moveMin) {
                moveMin = selectionSortMovements;
                moveResult = "Selection Sort";
            }

            // Implementing Quick Sort
            System.out.println("\tQuick Sort:");
            arrayCopy(RandomOrder, arrCopy);
            start = System.currentTimeMillis();
            quicksort(arrCopy, 0, arrCopy.length - 1);
             end = System.currentTimeMillis();
             duration = end - start;
            System.out.println("\t\tTime taken for Quick Sort: " + duration + " milliseconds");
            int quickSortComparisons = getComparisons();
            int quickSortMovements = getMovements();
            System.out.println("\t\tNumber of comparisons for Quick Sort: " + quickSortComparisons);
            System.out.println("\t\tNumber of movements for Quick Sort: " + quickSortMovements);
            reset();
            if (quickSortComparisons < compareMin) {
                compareMin = quickSortComparisons;
                compareResult = "Quick Sort";
            }
            if (duration < timeMin) {
                timeMin = (int) duration;
                timeResult = "Quick Sort";
            }
            if (quickSortMovements < moveMin) {
                moveMin = quickSortMovements;
                moveResult = "Quick Sort";
            }

            // Implementing Merge Sort
            System.out.println("\tMerge Sort:");
            arrayCopy(RandomOrder, arrCopy);
            start = System.currentTimeMillis();
            mergeSort(arrCopy, 0, arrCopy.length - 1);
            end = System.currentTimeMillis();
            duration = end - start;
            System.out.println("\t\tTime taken for Merge Sort: " + duration + " milliseconds");
            int mergeSortComparisons = getComparisons();
            int mergeSortMovements = getMovements();
            System.out.println("\t\tNumber of comparisons for Merge Sort: " + mergeSortComparisons);
            System.out.println("\t\tNumber of movements for Merge Sort: " + mergeSortMovements);
            reset();
            if (mergeSortComparisons < compareMin) {
                compareMin = mergeSortComparisons;
                compareResult = "Merge Sort";
            }
            if (duration < timeMin) {
                timeMin = (int) duration;
                timeResult = "Merge Sort";
            }
            if (mergeSortMovements < moveMin) {
                moveMin = mergeSortMovements;
                moveResult = "Merge Sort";
            }

            // Conclusions
            System.out.println("Conclusions:");
            System.out.println("\tThe sorting algorithm with the least amount of time taken is " + timeResult + " with " + timeMin + " milliseconds.");
            System.out.println("\tThe sorting algorithm with the least amount of comparisons is " + compareResult + " with " + compareMin + " comparisons.");
            System.out.println("\tThe sorting algorithm with the least amount of movements is " + moveResult + " with " + moveMin + " movements.");

            /*-------------------------------------------------------- IN ORDER LIST SORTING --------------------------------------------------------------*/
            
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("In Order list:");

            // Implementing Insertion Sort
            System.out.println("\tInsertion Sort:");
            arrayCopy(InOrder, arrCopy);
            start = System.currentTimeMillis();
            insertionSort(arrCopy);
            end = System.currentTimeMillis();
            duration = end - start;
            System.out.println("\t\tTime taken for Insertion Sort: " + duration + " milliseconds");
            insertionSortComparisons = getComparisons();
            insertionSortMovements = getMovements();
            System.out.println("\t\tNumber of comparisons for Insertion Sort: " + insertionSortComparisons);
            System.out.println("\t\tNumber of movements for Insertion Sort: " + insertionSortMovements);
            reset();
            compareMin = insertionSortComparisons;
            timeMin = (int) duration;
            moveMin = insertionSortMovements;
            timeResult = "Insertion Sort";
            moveResult = "Insertion Sort";
            compareResult = "Insertion Sort";

            // Implementing Selection Sort
            System.out.println("\tSelection Sort:");
            arrayCopy(InOrder, arrCopy);
            start = System.currentTimeMillis();
            selectionSort(arrCopy);
            end = System.currentTimeMillis();
            duration = end - start;
            System.out.println("\t\tTime taken for Selection Sort: " + duration + " milliseconds");
            selectionSortComparisons = getComparisons();
            selectionSortMovements = getMovements();
            System.out.println("\t\tNumber of comparisons for Selection Sort: " + selectionSortComparisons);
            System.out.println("\t\tNumber of movements for Selection Sort: " + selectionSortMovements);
            reset();
            if (selectionSortComparisons < compareMin) {
                compareMin = selectionSortComparisons;
                compareResult = "Selection Sort";
            }
            if (duration < timeMin) {
                timeMin = (int) duration;
                timeResult = "Selection Sort";
            }
            if (selectionSortMovements < moveMin) {
                moveMin = selectionSortMovements;
                moveResult = "Selection Sort";
            }

            //Implementing Quick Sort
            System.out.println("\tQuick Sort:");
            arrayCopy(InOrder, arrCopy);
            start = System.currentTimeMillis();
            quicksort(arrCopy, 0, arrCopy.length - 1);
            end = System.currentTimeMillis();
            duration = end - start;
            System.out.println("\t\tTime taken for Quick Sort: " + duration + " milliseconds");
            quickSortComparisons = getComparisons();
            quickSortMovements = getMovements();
            System.out.println("\t\tNumber of comparisons for Quick Sort: " + quickSortComparisons);
            System.out.println("\t\tNumber of movements for Quick Sort: " + quickSortMovements);
            reset();
            if (quickSortComparisons < compareMin) {
                compareMin = quickSortComparisons;
                compareResult = "Quick Sort";
            }
            if (duration < timeMin) {
                timeMin = (int) duration;
                timeResult = "Quick Sort";
            }
            if (quickSortMovements < moveMin) {
                moveMin = quickSortMovements;
                moveResult = "Quick Sort";
            }

            // Implementing Merge Sort
            System.out.println("\tMerge Sort:");
            arrayCopy(InOrder, arrCopy);
            start = System.currentTimeMillis();
            mergeSort(arrCopy, 0, arrCopy.length - 1);
            end = System.currentTimeMillis();
            duration = end - start;
            System.out.println("\t\tTime taken for Merge Sort: " + duration + " milliseconds");
            mergeSortComparisons = getComparisons();
            mergeSortMovements = getMovements();
            System.out.println("\t\tNumber of comparisons for Merge Sort: " + mergeSortComparisons);
            System.out.println("\t\tNumber of movements for Merge Sort: " + mergeSortMovements);
            reset();
            if (mergeSortComparisons < compareMin) {
                compareMin = mergeSortComparisons;
                compareResult = "Merge Sort";
            }
            if (duration < timeMin) {
                timeMin = (int) duration;
                timeResult = "Merge Sort";
            }
            if (mergeSortMovements < moveMin) {
                moveMin = mergeSortMovements;
                moveResult = "Merge Sort";
            }

            // Conclusions
            System.out.println("Conclusions:");
            System.out.println("\tThe sorting algorithm with the least amount of time taken is " + timeResult + " with " + timeMin + " milliseconds.");
            System.out.println("\tThe sorting algorithm with the least amount of comparisons is " + compareResult + " with " + compareMin + " comparisons.");
            System.out.println("\tThe sorting algorithm with the least amount of movements is " + moveResult + " with " + moveMin + " movements.");

            /*-------------------------------------------------------- REVERSE ORDER LIST SORTING --------------------------------------------------------------*/
            
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("Reverse Order list:");

            // Implementing Insertion Sort
            System.out.println("\tInsertion Sort:");
            arrayCopy(ReverseOrder, arrCopy);
            start = System.currentTimeMillis();
            insertionSort(arrCopy);
            end = System.currentTimeMillis();
            duration = end - start;
            System.out.println("\t\tTime taken for Insertion Sort: " + duration + " milliseconds");
            insertionSortComparisons = getComparisons();
            insertionSortMovements = getMovements();
            System.out.println("\t\tNumber of comparisons for Insertion Sort: " + insertionSortComparisons);
            System.out.println("\t\tNumber of movements for Insertion Sort: " + insertionSortMovements);
            reset();
            compareMin = insertionSortComparisons;
            timeMin = (int) duration;
            moveMin = insertionSortMovements;
            timeResult = "Insertion Sort";
            moveResult = "Insertion Sort";
            compareResult = "Insertion Sort";

            // Implementing Selection Sort
            System.out.println("\tSelection Sort:");
            arrayCopy(ReverseOrder, arrCopy);
            start = System.currentTimeMillis();
            selectionSort(arrCopy);
            end = System.currentTimeMillis();
            duration = end - start;
            System.out.println("\t\tTime taken for Selection Sort: " + duration + " milliseconds");
            selectionSortComparisons = getComparisons();
            selectionSortMovements = getMovements();
            System.out.println("\t\tNumber of comparisons for Selection Sort: " + selectionSortComparisons);
            System.out.println("\t\tNumber of movements for Selection Sort: " + selectionSortMovements);
            reset();
            if (selectionSortComparisons < compareMin) {
                compareMin = selectionSortComparisons;
                compareResult = "Selection Sort";
            }
            if (duration < timeMin) {
                timeMin = (int) duration;
                timeResult = "Selection Sort";
            }
            if (selectionSortMovements < moveMin) {
                moveMin = selectionSortMovements;
                moveResult = "Selection Sort";
            }

            //Implementing Quick Sort
            System.out.println("\tQuick Sort:");
            arrayCopy(ReverseOrder, arrCopy);
            start = System.currentTimeMillis();
            quicksort(arrCopy, 0, arrCopy.length - 1);
            end = System.currentTimeMillis();
            duration = end - start;
            System.out.println("\t\tTime taken for Quick Sort: " + duration + " milliseconds");
            quickSortComparisons = getComparisons();
            quickSortMovements = getMovements();
            System.out.println("\t\tNumber of comparisons for Quick Sort: " + quickSortComparisons);
            System.out.println("\t\tNumber of movements for Quick Sort: " + quickSortMovements);
            reset();
            if (quickSortComparisons < compareMin) {
                compareMin = quickSortComparisons;
                compareResult = "Quick Sort";
            }
            if (duration < timeMin) {
                timeMin = (int) duration;
                timeResult = "Quick Sort";
            }
            if (quickSortMovements < moveMin) {
                moveMin = quickSortMovements;
                moveResult = "Quick Sort";
            }

            // Implementing Merge Sort
            System.out.println("\tMerge Sort:");
            arrayCopy(ReverseOrder, arrCopy);
            start = System.currentTimeMillis();
            mergeSort(arrCopy, 0, arrCopy.length - 1);
            end = System.currentTimeMillis();
            duration = end - start;
            System.out.println("\t\tTime taken for Merge Sort: " + duration + " milliseconds");
            mergeSortComparisons = getComparisons();
            mergeSortMovements = getMovements();
            System.out.println("\t\tNumber of comparisons for Merge Sort: " + mergeSortComparisons);
            System.out.println("\t\tNumber of movements for Merge Sort: " + mergeSortMovements);
            reset();
            if (mergeSortComparisons < compareMin) {
                compareMin = mergeSortComparisons;
                compareResult = "Merge Sort";
            }
            if (duration < timeMin) {
                timeMin = (int) duration;
                timeResult = "Merge Sort";
            }
            if (mergeSortMovements < moveMin) {
                moveMin = mergeSortMovements;
                moveResult = "Merge Sort";
            }

            // Conclusions
            System.out.println("Conclusions:");
            System.out.println("\tThe sorting algorithm with the least amount of time taken is " + timeResult + " with " + timeMin + " milliseconds.");
            System.out.println("\tThe sorting algorithm with the least amount of comparisons is " + compareResult + " with " + compareMin + " comparisons.");
            System.out.println("\tThe sorting algorithm with the least amount of movements is " + moveResult + " with " + moveMin + " movements.");


        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    /*-------------------------------------------------------- SORT THE ARRAY FOR TESTING --------------------------------------------------------------*/

    public static void inOrderSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public static void reverseOrderSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] < key){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /*-------------------------------------------------------- SORTING ALGORITHMS --------------------------------------------------------------*/

    //Insertion sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j = j - 1;
                movements++;
            }
            arr[j + 1] = key;
            movements++;
        }
    }

    //Selection sort
    public static void selectionSort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            int compareMinIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < arr[compareMinIndex]) {
                    compareMinIndex = j;
                }
            }
            int temp = arr[compareMinIndex];
            arr[compareMinIndex] = arr[i];
            arr[i] = temp;
            movements++;
        }
    }

    //Quick sort
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                movements++;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        movements++;
        return i + 1;
    }

    // Merge sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
                comparisons++;
                movements++;
            } else {
                arr[k] = R[j];
                j++;
                comparisons++;
                movements++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            movements++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            movements++;
        }
    }
}