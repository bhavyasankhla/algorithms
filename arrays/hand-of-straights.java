/**
Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.

 

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
Example 2:

Input: hand = [1,2,3,4,5], W = 4
Output: false
Explanation: Alice's hand can't be rearranged into groups of 4.
 

Constraints:

1 <= hand.length <= 10000
0 <= hand[i] <= 10^9
1 <= W <= hand.length
Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

**/

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
            
            if(hand.length % W != 0) {
                    return false;                   
            }
            
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            
            for(int h : hand) {
                    if(!tm.containsKey(h)) {
                            tm.put(h, 1);
                    } else {
                            tm.replace(h, tm.get(h)+1);
                    }                    
            }
            
            
            while(tm.size() > 0) {
            int card = tm.firstKey();
            
            for (int current = card; current < card + W;current++) {
                    if(!tm.containsKey(current)) {
                            return false;
                    } else {
                            if(tm.get(current) == 1) {
                                tm.remove(current);
                            } else {
                                tm.replace(current, tm.get(current)-1);
                            }
                    }
            }
            }
            
            return true;
        
    }
}
