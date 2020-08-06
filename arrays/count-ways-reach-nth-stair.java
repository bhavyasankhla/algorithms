// https://www.geeksforgeeks.org/count-ways-reach-nth-stair/

/**
There are n stairs, a person standing at the bottom wants to reach the top. 
The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.

Approach: We can easily find the recursive nature in the above problem. 
The person can reach nth stair from either (n-1)th stair or from (n-2)th stair. 
Hence, for each stair n, we try to find out the number of ways to reach n-1th stair and n-2th stair 
and add them to give the answer for the nth stair. Therefore the expression for such an approach comes out to be :

ways(n) = ways(n-1) + ways(n-2)

Generalization of the Problem
How to count the number of ways if the person can climb up to m stairs for a given value m. 
For example, if m is 4, the person can climb 1 stair or 2 stairs or 3 stairs or 4 stairs at a time.

**/ 


public class CountWaysToReachNthStair {

    public static void main(String[] args) {

        int[] m = {1, 3, 5};

        int n = 5;

        System.out.println(ways(n+1, m));


    }

    public static int ways(int n, int[] m) {

        if(n<=1)
            return n;

        int res = 0;

        for( int i  = 0; i < m.length && m[i] <= n; i++) {

            res += ways(n-m[i], m);

        }
        
        // n-m[i] should be >= 0, hence m[i] <= n, otherwise number of ways will become negative.  

        return res;
    }

}
