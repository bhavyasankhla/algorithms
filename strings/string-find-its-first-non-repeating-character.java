// https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/

/**
Can this be done by traversing the string only once?
The above approach takes O(n) time, but in practice, it can be improved. The first part of the algorithm runs through the string to 
construct the count array (in O(n) time). This is reasonable. But the second part about running through the string again just to find 
the first non-repeater is not a good practice.

In real situations, the string is expected to be much larger than your alphabet. Take DNA sequences, for example, they could be millions
of letters long with an alphabet of just 4 letters. What happens if the non-repeater is at the end of the string? Then we would have to scan
for a long time (again).

Method 2: HashMap and single string traversal.

Approach: Make a count array instead of hash_map of maximum number of characters(256). We can augment the count array by storing not 
just counts but also the index of the first time you encountered the character e.g. (3, 26) for ‘a’ meaning that ‘a’ got counted 3 times and 
the first time it was seen is at position 26. So when it comes to finding the first non-repeater, we just have to scan the count array, instead of the string. 
Thanks to Ben for suggesting this approach.

Algorithm :

Make a count_array which will have two fields namely frequency, first occurence of a character.
The size of count_array is ‘256’.
Traverse the given string using a pointer.
Increase the count of current character and update the occurence.
Now here’s a catch, the array will contain valid first occurence of the character which has frequency has unity otherwise the first occurence keeps updating.
Now traverse the count_array and find the character which has least value of first occurence and frequency value as unity.
Return the character

**/

import java.util.HashMap;
import java.util.Map;

class CountIndex {
    int index,count;
    public CountIndex(int index) {
        this.index = index;
        this.count = 1;
    }
    public void incCount() {
        this.count++;
    }
}

public class stringFirstNonRepeatingChar {

    public static void main(String[] args) {

        String s = "geeksforgeeks";

        HashMap<Character, CountIndex> map = new HashMap<>();

        for (int i = 0; i< s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.get(s.charAt(i)).incCount();
            } else {
                map.put(s.charAt(i), new CountIndex(i));
            }
        }

        int res = Integer.MAX_VALUE;
        Character c = null;

        for(Map.Entry<Character, CountIndex> entry : map.entrySet()) {
            if(entry.getValue().count == 1 && entry.getValue().index < res) {
                res = entry.getValue().index;
                c = entry.getKey();
            }
        }

        System.out.println(c);

    }
}
