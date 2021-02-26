/**

https://leetcode.com/problems/group-anagrams/

https://www.youtube.com/watch?v=ptgykfAEax8&ab_channel=KevinNaughtonJr.

49. Group Anagrams
Medium

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.

**/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
            List<List<String>> list= new ArrayList<>();
            
            if(strs == null || strs.length == 0) {
                    return list;
            }
            
            Map<String, List<String>> map = new HashMap();
                           
            for(String s : strs) {
                    
                    char[] ch = s.toCharArray();
                    
                    Arrays.sort(ch);
                    
                    String sortedString = new String(ch);
                    
                    if(!map.containsKey(sortedString)) {
                            map.put(sortedString, new ArrayList<>());
                    }
                    
                    map.get(sortedString).add(s);                                      
                    
            }
            
            list.addAll(map.values());
            
            return list;
    }
}
