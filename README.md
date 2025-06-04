# Divide-Conquer
This program computes the number of swaps (inversions) required to sort an array using a modified merge sort. It returns the count as a BigInteger to handle large values.

# Logic
1. Recursive Merge Sort (mergeSort)

Input: int[] numbers, with current low and high bounds.

Returns: BigInteger – the cumulative number of inversions (swaps) required to sort the subarray.

Logic:

Base case: if low >= high, return 0 (no swaps in a 0/1-length array).

Recursively sort left and right halves: mergeSort(numbers, low, mid) and mergeSort(numbers, mid+1, high).
Merge and count cross-subarray inversions using merge().

2. Merge with Swap Counting (merge)

Inputs: Original array and bounds low, mid, high.

Subarrays:
Two temporary arrays arr1 and arr2 with one extra slot for Integer.MAX_VALUE as a sentinel.

Merge Logic:
Two pointers i, j iterate through arr1 and arr2.

If arr1[i] <= arr2[j]: copy arr1[i] to numbers[k] (no inversion).

Else: copy arr2[j] to numbers[k], and add sizeLeft - i to inversion count (because all remaining elements in arr1 are greater).
