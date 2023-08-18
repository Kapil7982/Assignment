package assignemnt;

public class RemovingElementSumOfOddAndEvenEqual {
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 6, 4};
        int[] arr2 = {1, 1, 1};

        int result1 = countEqualSumIndices(arr1);
        int result2 = countEqualSumIndices(arr2);

        System.out.println("Output for arr1: " + result1); 
        System.out.println("Output for arr2: " + result2); 
    }

    static int countEqualSumIndices(int[] arr) {
        int n = arr.length;
        int[] prefixSumEven = new int[n];
        int[] prefixSumOdd = new int[n];

        prefixSumEven[0] = arr[0];
        prefixSumOdd[0] = 0;

        for (int i = 1; i < n; i++) {
            prefixSumEven[i] = prefixSumEven[i - 1];
            prefixSumOdd[i] = prefixSumOdd[i - 1];

            if (i % 2 == 0) {
                prefixSumEven[i] += arr[i];
            } else {
                prefixSumOdd[i] += arr[i];
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int evenSum = (i > 0 ? prefixSumEven[i - 1] : 0) + (prefixSumOdd[n - 1] - prefixSumOdd[i]);
            int oddSum = (i > 0 ? prefixSumOdd[i - 1] : 0) + (prefixSumEven[n - 1] - prefixSumEven[i]);

            if (evenSum == oddSum) {
                count++;
            }
        }

        return count;
    }
}
