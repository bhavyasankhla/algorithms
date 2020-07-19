// https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/

/**

Given a sorted array of positive integers, rearrange the array alternately i.e first element should be maximum value, second minimum value, third second max, fourth second min and so on.

Examples:

Input: arr[] = {1, 2, 3, 4, 5, 6, 7}
Output: arr[] = {7, 1, 6, 2, 5, 3, 4}

Input: arr[] = {1, 2, 3, 4, 5, 6}
Output: arr[] = {6, 1, 5, 2, 4, 3}

Expected time complexity: O(n).

The idea is to use an auxiliary array. We maintain two pointers one to leftmost or smallest element and other to rightmost or largest element. 
We more both pointers toward each other and alternatively copy elements at these pointers to an auxiliary array. 
Finally, we copy auxiliary array back to the original array.
**/

public class WAP {

    public static void main(String[] args) {

        // Given array is sorted
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        boolean flag = true;
        int max = test.length-1, min = 0;

        int[] res = new int[test.length];

        for(int i = 0; i<test.length; i++) {

            if(flag) {
                res[i] = test[max--];
            } else {
                res[i] = test[min++];
            }
            flag = !flag;
        }

        test = res.clone();

        for (int i: test) {
            System.out.println(i);
        }
    }
}
