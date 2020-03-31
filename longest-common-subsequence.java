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
