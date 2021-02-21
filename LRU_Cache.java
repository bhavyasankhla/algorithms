/**

https://leetcode.com/problems/lru-cache/

https://www.youtube.com/watch?v=NDpwj0VWz1U&t=345s&ab_channel=NickWhite

146. LRU Cache
Medium

7824

320

Add to List

Share
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
Follow up:
Could you do get and put in O(1) time complexity?

**/

class LRUCache {
        
        int capacity;
        Map<Integer, Node> map;
        
        class Node {
                
                int key;
                int val;
                
                Node prev, next;
                
                public Node(int value) {
                        this.val = value;
                        prev = null;
                        next = null;
                }
        }
        
        Node head = new Node(0);
        Node tail = new Node(0);

    
        public LRUCache(int cache_capacity) {            
                this.capacity = cache_capacity;
                map = new HashMap<>();
                head.next = tail;
                tail.prev = head;
        }
    
    
        public int get(int key) {
                int res = -1;
                Node node = map.get(key);
                if(node != null) {
                        res = node.val;
                        remove(node);
                        add(node);
                }
                return res;
        }
    
    
        public void put(int key, int value) {
                
                Node node = map.get(key);
                
                if(node != null) {
                        node.val = value;
                        remove(node);
                        add(node);                        
                } else {
                        if(capacity == map.size()) {
                                map.remove(tail.prev.key);
                                remove(tail.prev);                                
                        }
                        Node newNode = new Node(value);  
                        newNode.key = key;
                        map.put(key, newNode);
                        add(newNode);
                }
               
        }
        
        
        public void add(Node node) {
                Node head_next = head.next;
                head.next = node;
                node.prev = head;
                node.next = head_next;
                head_next.prev = node;        
        }

        public void remove(Node node) {                
                Node prevNode = node.prev;
                Node nextNode = node.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
        }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
