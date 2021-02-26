// Longest Common Subsequence. using DP

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		String s1 = "abcd";
		String s2 = "axxxkkklllbmmmnnnc";
		
		
		System.out.println(lcs(s1, s2, s1.length(), s2.length()));
		
	}
	
	static int lcs ( String a, String b, int m, int n) {
	    if(m==0 || n==0) {
	        return 0;
	    }
	    
	    if(a.charAt(m-1) == b.charAt(n-1) ) {
	        return 1 + lcs(a,b,m-1,n-1);
	    } else {
	        return Math.max(lcs(a,b,m-1,n), lcs(a,b,m,n-1));
	    }
	} 
}

// Now using Memoization also 

class Solution {
    
        public int longestCommonSubsequence(String text1, String text2) {
            
            int m = text1.length();
            int n = text2.length();
                
            int[][] store = new int[m][n];
            
            for(int i =0; i< m; i++) {
                    Arrays.fill(store[i], -1);                    
            }            
                
            return lcs(text1, text2, text1.length()-1, text2.length()-1, store);
        
        }
        
        
        public int lcs(String a, String b, int m, int n, int[][] store) {

                if(m<0 || n<0) {
                        return 0;
                }

                if(store[m][n] != -1) {
                        return store[m][n];
                }

                if(a.charAt(m) == b.charAt(n)) {
                        store[m][n] = 1 + lcs(a,b,m-1,n-1, store);
                } else {
                        store[m][n] =  Math.max(lcs(a,b,m-1,n, store), lcs(a,b,m,n-1, store));
                }

                return store[m][n];

        }
}
