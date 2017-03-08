/**
 * Created by aniquedavla on 3/7/17.
 */
public class Util {

    public static boolean binarySearchRecursive(int[] number, int numberToFind, int leftI, int rightI){
        //protects int overflow by rouding up for large leftI and rightI
        int midI = (rightI + leftI) / 2;
        if(numberToFind == number[midI]){
            return true;
        } else if(numberToFind < number[midI]){
            binarySearchRecursive(number,numberToFind,leftI,midI-1);
        }else if(numberToFind > number[midI]){
            binarySearchRecursive(number,numberToFind,midI+1,rightI);
        }
        return false;
    }

    public static boolean binarySearchIterative(int[] array, int value){
        int low = 0;
        int high =  array.length - 1;
        while(low < high){
            //(high - low)/2 breaks for consecutive high and low, index will compare with 0
            int mid = (high + low)/2;
            if(value == array[mid]){
                return true;
            } else if(value < mid){
                high = mid -1;
            } else if(value > mid){
                low = mid +1;
            }
        }
        return false;
    }
}
