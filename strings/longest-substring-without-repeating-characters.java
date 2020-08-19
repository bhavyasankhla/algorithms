// sliding window technique 
// https://www.youtube.com/watch?v=3IETreEybaA

class Solution {
    public int lengthOfLongestSubstring(String s) {
            
            if(s==null || s.length() == 0) {
                    return 0;
            }
            
            int i = 0, j = 0, max=0;
            HashSet<Character> set = new HashSet<>();
            
            while(j < s.length()) {
                    if(set.contains(s.charAt(j))) {
                            set.remove(s.charAt(i));
                            i++;
                    } else {
                            set.add(s.charAt(j));
                            j++;
                            max = Math.max(max, set.size());
                    }
            }
                         
            return max;
    }
}
