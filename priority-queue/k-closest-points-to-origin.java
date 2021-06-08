/**

https://www.youtube.com/watch?v=1rEUgAG7f_c&ab_channel=KevinNaughtonJr.KevinNaughtonJr.


K Closest Points to Origin
Medium

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 

Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 104
-104 < xi, yi < 104


**/


class Solution {
        
        class Point {
                int x;
                int y;
                public Point(int x, int y) {
                        this.x = x;
                        this.y = y;
                }
                public int getX() {
                        return this.x;
                }
                public int getY() {
                        return this.y;
                }
        }
        
    
        public int[][] kClosest(int[][] points, int k) {
                
                return firstMethod(points,k);
                // return secondMethod(points,k);
            
        }
        
        public int[][] secondMethod(int[][] points, int k) {
                PriorityQueue<int []> maxHeap = new PriorityQueue<>( (a, b) -> 
                        (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])
                );
                for(int[] row : points) {
                        maxHeap.add(row);
                        if(maxHeap.size() > k) {
                                maxHeap.remove();
                        }
                }
                
                int[][] res = new int[k][2]; int j = 0;
                while(k-- > 0) {
                        res[j] = maxHeap.remove();                        
                        j++;
                }
                return res;
        }
        
        public int[][] firstMethod(int[][] points, int k) {
                
        
                int rows = points.length;
            
            Map<Point, Integer> map = new HashMap<>();  
            // Stores point and distance from the origin. 
            // then sort the map according to the values. 
            
            for(int i = 0; i<rows; i++) {
                    map.put(new Point(points[i][0], points[i][1]), points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            }
            
            List<Map.Entry<Point, Integer>> list = new LinkedList<>(map.entrySet());
            // sort the map acc to the values. 
            
            Collections.sort(list, new Comparator<Map.Entry<Point, Integer>>() {
                    public int compare(Map.Entry<Point, Integer> a, Map.Entry<Point, Integer> b) {
                            return a.getValue().compareTo(b.getValue());
                    }                    
            });
                    
                    
            int j = 0;
                        
            int[][] res = new int[k][2];
                                
            for( Map.Entry<Point, Integer> item : list) {
                    if(j==k) {
                            break;
                    }
                    Point p = item.getKey();
                    res[j][0] = p.getX();
                    res[j][1] = p.getY();
                    j++;
            }
            
            return res;
        }
}
