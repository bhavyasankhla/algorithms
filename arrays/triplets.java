Find a triplet such that sum of two equals to third element
Given an array of integers you have to find three numbers such that sum of two elements equals the third element.

Examples:

Input : {5, 32, 1, 7, 10, 50, 19, 21, 2}
Output : 21, 2, 19

Input : {5, 32, 1, 7, 10, 50, 19, 21, 0}
Output : no such triplet exist

Sort the given array first.
Start fixing the greatest element of three from back and traverse the array to find other two numbers which sum upto the 
third element.
Take two pointers j(from front) and k(initially i-1) to find the smallest of the two number and from i-1 to find the
largest of the two remaining numbers
If the addition of both the numbers is still less than A[i], then we need to increase the value of the summation of
two numbers, thereby increase the j pointer, so as to increase the value of A[j] + A[k].
If the addition of both the numbers is more than A[i], then we need to decrease the value of the summation of two numbers, 
thereby decrease the k pointer so as to decrease the overall value of A[j] + A[k].

public class GFG { 
  
    // utility function for finding 
    // triplet in array 
    static void findTriplet(int arr[], int n) 
    { 
        // sort the array 
        Arrays.sort(arr); 
  
        // for every element in arr 
        // check if a pair exist(in array) whose 
        // sum is equal to arr element 
        for (int i = n - 1; i >= 0; i--) { 
            int j = 0; 
            int k = i - 1; 
            while (j < k) { 
                if (arr[i] == arr[j] + arr[k]) { 
  
                    // pair found 
                    System.out.println("numbers are " + arr[i] + " "
                                       + arr[j] + " " + arr[k]); 
  
                    return; 
                } 
                else if (arr[i] > arr[j] + arr[k]) 
                    j += 1; 
                else
                    k -= 1; 
            } 
        } 
  
        // no such triplet is found in array 
        System.out.println("No such triplet exists"); 
    } 
  
    // driver program 
    public static void main(String args[]) 
    { 
        int arr[] = { 5, 32, 1, 7, 10, 50, 19, 21, 2 }; 
        int n = arr.length; 
        findTriplet(arr, n); 
    } 
}
