
/***
 * 
 * Max Subarray solution using brute force alogrithm 
 * complexity O(n*n)
 * 
 */ 
public class BruteForce4MaxSubarray{
	
	public static void main(String[]args){
		int [] array = new int[]{13,-3,-25,20 ,-3 ,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
			long maxSum = 0;
			int startIndex = 0; 
			int endIndex = 0; 
			for(int i =0 ;i< array.length ;i++){ // from keeping tracking start index
				int sumEndingHere = 0;
				for(int j =i; j< array.length ; j++){
					sumEndingHere +=array[j];
						if(sumEndingHere > maxSum){ // if found max sum 
								maxSum = sumEndingHere;
								startIndex = i; // update start index
								endIndex = j; // end here for last index
								}
						}
				
				}
			System.out.println(startIndex + "------" + endIndex +"------"+ maxSum);
		
		}
	
	}
