import java.util.*;
import java.math.BigInteger;

public class A2_Q2 {
    public static BigInteger num_swaps(int[] numbers) {
       return mergeSort(numbers, 0, numbers.length-1); // call on original array, already setting high index

    }

    public static BigInteger mergeSort(int[] numbers, int low, int high){
        BigInteger count = new BigInteger("0"); // num_swaps

        //System.out.println("Array to be merge sort length:" + arrLength);

        if (low>=high) { // base case, empty array
         //   System.out.println("Base case:" + count);
            return count;
        }

        int mid = (low+high)/2; // to separate arrays

        count = count.add(mergeSort(numbers, low, mid)); // left sub array recursive call. increments number of swaps to total

        count = count.add(mergeSort(numbers, mid+1, high)); // right sub array recursive call. invrements number of swaps to ttoal

        count = count.add(merge(numbers, low, mid, high)); // merge both after sorting them individually, and then count number of swaps between both halves

        return count;
    }

    public static BigInteger merge(int[] numbers, int low, int mid, int high) {
        BigInteger count = new BigInteger("0");

        int sizeLeft = mid - low + 1; // left subarray size.
        int sizeRight = high - mid; // right subarray size

        int[] arr1 = new int[sizeLeft + 1]; // + 1 for sentinel value

        int[] arr2 = new int[sizeRight + 1]; // + 1 for sentinel value

        // populate left and right subarrays from original array
        for (int i = 0; i <= sizeLeft; i++) {
            if(i==sizeLeft){
                arr1[i] = Integer.MAX_VALUE;
            }
            else {
                arr1[i] = numbers[i + low];
            }
        }
        for (int j = 0; j <= sizeRight; j++) {
            if(j==sizeRight){
                arr2[j] = Integer.MAX_VALUE;
            }
            else{
                arr2[j] = numbers[mid + 1 + j];
            }
        }

      // pointers, initialized outside the for loop to control which go forward
        int i = 0;
        int j = 0;


        for (int k = low; k <= high; k++) {
            if (arr1[i] <= arr2[j]) { // left subarray element less than or equal to right subarray element -> no swap needed
                numbers[k] = arr1[i]; // replace nums array value
                i++;
            }
            else { // case 2, swap needed because right element is less than left element
                numbers[k] = arr2[j]; 
                j++;
                count = count.add(BigInteger.valueOf(sizeLeft - i)); // since the left subarray is sorted, the number of swaps is the rest of the elements in the left subarray
            }
        }
   
        return count;
    }

}
