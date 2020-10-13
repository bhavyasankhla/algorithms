/* Problem Name is &&& Optimal Path &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
 ** Instructions to candidate.
 **  1) You are an avid rock collector who lives in southern California. Some rare
 **     and desirable rocks just became available in New York, so you are planning
 **     a cross-country road trip. There are several other rare rocks that you could
 **     pick up along the way.
 **
 **     You have been given a grid filled with numbers, representing the number of
 **     rare rocks available in various cities across the country.  Your objective
 **     is to find the optimal path from So_Cal to New_York that would allow you to
 **     accumulate the most rocks along the way.
 **
 **     Note: You can only travel either north (up) or east (right).
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement optimalPath() correctly.
 **  4) Here is an example:
 **                                                           ^
 **                 {{0,0,0,0,5}, New_York (finish)           N
 **                  {0,1,1,1,0},                         < W   E >
 **   So_Cal (start) {2,0,0,0,0}}                             S
 **                                                           v
 **   The total for this example would be 10 (2+0+1+1+1+0+5).
 */

import java.io.*;
import java.util.*;

class Solution
{
    /*
     **  Find the optimal path.
     */

    public static Integer optimalPath(Integer[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        int sum = 0;

        int res =  driver(grid, rows-1, 0, cols-1, sum);

        System.out.println(res);

        return res;
    }



    public static Integer driver(Integer[][] grid, int row, int col, int c, int sum) {

       if(row == 0 && col == c ) {
            return sum + grid[0][c];
        }

        if(row == 0 ) {
            return (sum + driver(grid, row, col+1, c, sum) );
        }

        if(col == c ) {
            return (sum + driver(grid, row-1, col, c, sum) );
        }

        int nextRight = grid[row][col+1];
        int nextTop  = grid[row-1][col];

        if( nextRight > nextTop ) {
            sum += driver(grid, row, col+1, c, sum);
        } else if( nextRight < nextTop ) {
            sum +=  driver(grid, row-1, col, c, sum);
        } else {
            sum += Math.max( driver(grid, row-1, col, c, sum), driver(grid, row, col+1, c, sum) );
        }

        return sum + grid[row][col];
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {
        boolean result = true;
        // Base test case
        result &= optimalPath(new Integer[][]{
                {0,0,0,0,5},
                {0,1,1,1,0},
                {2,0,0,0,0}}) == 10;
        return result;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args)
    {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}
