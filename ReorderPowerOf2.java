import java.util.Arrays;

public class ReorderPowerOf2 {

	 public static boolean reorderedPowerOf2(int n) {
	        
	        char [] charInN = String.valueOf(n).toCharArray();
	        Arrays.sort(charInN);
	        
	        int i = 1;
	        int powOf2 = 1;
	        while(i <= 31){
	            char [] curr = String.valueOf(powOf2).toCharArray();
	            Arrays.sort(curr);
	            if(Arrays.equals(charInN,curr))
	                return true;
	            i+=1;
	            powOf2 = powOf2 << 1;
	        }
	        return false;
	    }
	 
	 public static void main(String[] args) {
		
		 System.out.println(reorderedPowerOf2(46));
	}
	
}
