//package DynamicProgramming;

public class LCS {
	
	
	public static int fib(int n){
		if(n==0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		
		return fib(n-1) + fib(n-2);
	}
	
	public static int fibR(int n){
		int[] storage = new int[n+1];
		return fibR(n, storage );
	}
	//memoization
	private static int fibR(int n, int[] storage) {
		if(n==0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		if(storage[n] != 0){
			return storage[n];
		}
		int ans = fibR(n-1,storage) + fibR(n-2,storage);
		storage[n] = ans;
		return ans;
	}

	public static int lcs(String s1, String s2){
		if(s1.length() == 0 || s2.length() == 0){
			return 0;
		}
		
		if(s1.charAt(0) == s2.charAt(0)){
			return  1 + lcs(s1.substring(1),s2.substring(1));	
		}
		else{
			return Math.max(lcs(s1,s2.substring(1)), lcs(s1.substring(1),s2));
		}
			
	}

	public static int lcsR(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		int[][] storage = new int[m+1][n+1];
		return lcsR(s1,s2,storage);	
	}
	
	private static int lcsR(String s1, String s2, int[][] storage) {
		int m = s1.length();
		int n = s2.length();
		if(m == 0 || n == 0){
			return 0;
		}
		if(storage[m][n] != 0){
			return storage[m][n];
		}
		int ans;
		if(s1.charAt(0) == s2.charAt(0)){
			ans = 1+ lcsR(s1.substring(1),s2.substring(1),storage);
		}
		else{
			ans = Math.max(lcsR(s1,s2.substring(1),storage), lcsR(s1.substring(1),s2,storage));
		}
		storage[m][n] = ans;
		return ans;
	}
	
	public static int lcsDP(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		int storage[][] = new int[m+1][n+1];
		
		for(int i = 1; i < m+1; i++){
			for(int j = 1; j < n+1; j++){
				if(s1.charAt(m - i) == s2.charAt(n - j)){
					storage[i][j] = 1 + storage[i - 1][j - 1];
				}
				else{
					storage[i][j] = Math.max(storage[i-1][j], storage[i][j-1]);	
				}
			}
		}
		
		
		return storage[m][n];
	}
	
	
	public static int mcm(int dimensions[],int start, int end){
		if(start >= end){
			return 0;
		}
		
		int minCost = Integer.MAX_VALUE;
		for(int k = start; k < end; k++){
			int cost = mcm(dimensions,start,k) + mcm(dimensions,k+1,end) + 
						dimensions[start-1]*dimensions[k]*dimensions[end];
			//mcm(dimensions,start,k) will have dimension dimension[start-1]*dimension[k]
			//||ly mcm(dimensions,k+1,end) will have dimension dimensions[k]*dimensions[end]
			if(cost < minCost){
				minCost = cost;
			}	
		}
		return minCost;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stubn[
	/*	String s1 = "abcdefabcdefabcdefabcdefabcdefabcdefabcdefabcdefabcdefabcdef";
		String s2 = "acbdeabcdefabcdefabcdefabcdefabcdefabcdefabcdefabcdefabcdef";
		System.out.println(lcsDP(s1,s2));
		System.out.println(lcsR(s1,s2));
		System.out.println(lcs(s1,s2));*/
		int dimensions[] = {10,15,20,25};
		System.out.println(mcm(dimensions,1,dimensions.length-1));
	}

}
