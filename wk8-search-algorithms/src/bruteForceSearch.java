// Java program for Naive Pattern Searching

public class bruteForceSearch{ //COMPLEXITY OF O(N^2)
	  
	    public static void search(String txt, String pat) 
	    {
	    	int n = txt.length();
	    	int m = pat.length();
	    	int checker = 0;
	       	for(int i = 0; i<=n-m; i++){
	       		int j;
				for(j =0; j<m; j++){
					if(txt.charAt(i+j) != pat.charAt(j)){
						break;
					}
				}
				if(j == m){
					System.out.println("Pattern found at " + i);
					checker = 1;
					break;
				}
		   	}
	       	if(checker == 0) {
				System.out.println("Pattern not found");
			}
	    } 
	  
	    public static void main(String[] args) 
	    { 
	        //alter to take text file in..
	        String txt = "ABABDABACDABABCABAB"; 
		    String pat = "ABABCABAB"; 
	        search(txt, pat); 
	    } 

}
