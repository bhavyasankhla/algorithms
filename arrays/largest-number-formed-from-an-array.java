/**
// https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0
Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.The result is going to be very large, hence return the result in the form of a string.

Input:
The first line of input consists number of the test cases. The description of T test cases is as follows:
The first line of each test case contains the size of the array, and the second line has the elements of the array.

Output:
In each separate line print the largest number formed by arranging the elements of the array in the form of a string.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 102
0 ≤ A[i] ≤ 103

Example:
Input:
2
5
3 30 34 5 9
4
54 546 548 60

Output:
9534330
6054854654
**/

import java.util.*;
import java.util.Scanner;

public class LargestNuminArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.next()); // Number of test cases

        while(t-->0) {

            int n = Integer.parseInt(scanner.next());
            int i = 0;

            ArrayList<String> numbers = new ArrayList<>();

            for(i=0; i<n;i++) {
                numbers.add(String.valueOf(scanner.next()));
            }

            Collections.sort(numbers, (a, b) -> -Integer.compare(Integer.parseInt(a+b), Integer.parseInt(b+a)));

            // This lamba is equivalent to

//            Collections.sort(numbers, new Comparator<String>() {
//
//                @Override
//                public int compare(String a, String b) {
//                    return -Integer.compare(Integer.parseInt(a+b), Integer.parseInt(b+a));
//                }
//            });


            for(i=0; i<n;i++) {
                System.out.print(numbers.get(i));
            }

            System.out.println();
        }
    }
}
