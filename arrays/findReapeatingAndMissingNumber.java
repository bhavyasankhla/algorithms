// Find the repeating and the missing | Added 3 new methods
// Given an unsorted array of size n. Array elements are in the range from 1 to n. One number from set {1, 2, …n} is missing 
// and one number occurs twice in the array. Find these two numbers.
// Examples:

 
// Input: arr[] = {3, 1, 3}
// Output: Missing = 2, Repeating = 3
// Explanation: In the array, 
// 2 is missing and 3 occurs twice 

// Input: arr[] = {4, 3, 6, 2, 1, 1}
// Output: Missing = 5, Repeating = 1

// Below are various methods to solve the problems:



// Method 1 (Use Sorting)
// Approach:

// Sort the input array.
// Traverse the array and check for missing and repeating.
// Time Complexity: O(nLogn)

// Thanks to LoneShadow for suggesting this method.

// Method 2 (Use count array)
// Approach:

// Create a temp array temp[] of size n with all initial values as 0.
// Traverse the input array arr[], and do following for each arr[i]
// if(temp[arr[i]] == 0) temp[arr[i]] = 1;
// if(temp[arr[i]] == 1) output “arr[i]” //repeating
// Traverse temp[] and output the array element having value as 0 (This is the missing element)
// Time Complexity: O(n)
// Auxiliary Space: O(n)

// Method 3 (Use elements as Index and mark the visited places)
// Approach:
// Traverse the array. While traversing, use the absolute value of every element as an index 
// and make the value at this index as negative to mark it visited.
// If something is already marked negative then this is the repeating element. 
// To find missing, traverse the array again and look for a positive value.


class GFG { 
  
    static void printTwoElements(int arr[], int size) 
    { 
        int i; 
        System.out.print("The repeating element is "); 
  
        for (i = 0; i < size; i++) { 
            int abs_val = Math.abs(arr[i]); 
            if (arr[abs_val - 1] > 0) 
                arr[abs_val - 1] = -arr[abs_val - 1]; 
            else
                System.out.println(abs_val); 
        } 
  
        System.out.print("And the missing element is "); 
        for (i = 0; i < size; i++) { 
            if (arr[i] > 0) 
                System.out.println(i + 1); 
        } 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        int arr[] = { 7, 3, 4, 5, 5, 6, 2 }; 
        int n = arr.length; 
        printTwoElements(arr, n); 
    } 
} 
