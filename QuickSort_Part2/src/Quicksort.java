import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by aniquedavla on 10/22/16.
 */
public class Quicksort {
    private int[] array;

    /**
     * quickSort1 is the simplest version of the quicksort algorithm by choosing last element as pivot.
     * @param array1
     * @param lowIndex
     * @param highIndex
     * @return
     */
    public int[] quickSort1(int[] array1, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int divide = partition(array1, lowIndex, highIndex);
            //sort before element and after
            quickSort1(array1, lowIndex, divide-1);
            quickSort1(array1, divide+1, highIndex);
        }
        return array1;
    }

    public int[] quickSort2_mOfM(int[] array1, int i, int i1) {

    }

    /**
     * Swaps index x, and y in array[]
     * @param array the array of ints
     * @param x is the index to swap
     * @param y is the index to swap with
     */
    public static void swap(int array[], int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public int partition(int array1[], int lowIndex, int highIndex){
        int pivot = array1[highIndex];
        int i = (lowIndex - 1); // index of smaller element
        for (int j=lowIndex; j <= highIndex-1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (array1[j] <= pivot) {
                i++;
                swap(array1,i,j);
            }
        }
        swap(array1,i+1,highIndex);

        return i+1;
    }

    public static int partitionMed(int[] inarr, int left, int right) {
        int x = inarr[left];
        int y = inarr[right - 1];
        int length = right - left;
        int mid;
        if (length % 2 == 0) {
            mid = inarr[left + (length/2 - 1)];
        }
        else
            mid = inarr[left + (length/2)];

        int pivot = median(x, y, mid);
        int pivInd = java.util.Arrays.asList(inarr).indexOf(pivot);

        inarr[pivInd] = inarr[left];
        inarr[left] = pivot;

        int i = left + 1;

        for(int j = left + 1; j < right; j++) {
            if (inarr[j] < pivot) {
                swap(inarr, i, j);
                i++;
            }
        }
        swap(inarr, left, i - 1);
        return i - 1;
    }

    public static int median(int x, int y, int z) {
        if ((x - y) * (z - x) >= 0) {
            return x;
        }
        else if ((y - x) * (z - y) >= 0) {
            return y;
        }
        else
            return z;
    }



    public void reset() {

    }

    public int select(int[] array1, int left, int right, int n) {

    }

    public int[] populate(int index) {
        int[] populatedArray = new int[index];
        Random randomNumber = new Random();
        for(int i=0; i < index; i++){
            populatedArray[i] = randomNumber.nextInt(index + 1);
        }
        return populatedArray;
    }

    public long getPartCount() {
        return partCount;
    }

    static void print(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}
