/**

https://leetcode.com/problems/top-k-frequent-elements/

https://www.geeksforgeeks.org/heap-data-structure/

https://www.geeksforgeeks.org/priority-queue-class-in-java-2/


347. Top K Frequent Elements
Medium

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.legth <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
**/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
            
            if(k==nums.length) {
                    return nums;
            }
        
            int[] res = new int[k];
            
            Map<Integer, Integer> map = new HashMap();
            
            for(int i = 0; i< nums.length; i++) {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            
            Queue<Integer> heap = new PriorityQueue<>( (a,b) ->
                    map.get(a) - map.get(b)
            );
            
            for(Integer key : map.keySet()) {
                    heap.add(key);
                    if(heap.size() > k) {
                            heap.poll();
                    }
            }
            
            for(int j = 0; j<k; j++) {
                    res[j] = heap.poll();
            }
            
            return res;
    }
}

// Following is an approach without using heap or PQ 

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
            
            if(k==nums.length) {
                    return nums;
            }
        
            int[] res = new int[k];
            
            Map<Integer, Integer> map = new HashMap();
            
            for(int i = 0; i< nums.length; i++) {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            
            
            List<Map.Entry<Integer, Integer>> list = new LinkedList(map.entrySet());
            
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                            return b.getValue().compareTo(a.getValue());
                    }
            });
   
            
            int j = 0;
            
       
            for (Map.Entry<Integer, Integer> item : list) {
                    
                    if(j==k) {
                            break;
                    }
                    
                    res[j] = item.getKey();
                    j++;
                    
            }
            
            return res;
    }
}
