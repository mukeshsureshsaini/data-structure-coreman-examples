/***
 * CLRS 4.1-5 Excercise
 *  //TODO keeping track of the start and end index in Kadane solution
 */ 
 import java.util.Arrays;
public class KadaneSolution4MaxSubArray{
	
	public static void main(String[]args){
		//int [] array = new int[]{13,-3,-25,20 ,-3 ,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		//int [] array = new int[]{5,2,-4,3,2,-8,7,6,-1,-2,3,-50};
		
		 //int []array = new int[]{5,2,-8, 1, 7};
		 int [] array = new int[]{5, -4, 2, 1};
		 
		int[] maxSubArray = maxSubArrayUsingKadaneSol(array);
		for(int e : maxSubArray){
				System.out.print(e+"\t");
			}
		System.out.println();
	}
	
	public static int[] maxSubArrayUsingKadaneSol(int array[]){
		long maxSoFar =array[0];
		long maxEndingHere =array[0];
		int startIndex = 0;
		int endIndex =0;
		int j=1;
		for(; j< array.length ;j++){
			int val = array[j];
			if(val >= val+maxEndingHere){
					maxEndingHere = val;
					startIndex = j;
				}else {
					maxEndingHere += val;
					};
			if(maxSoFar < maxEndingHere){
					maxSoFar = maxEndingHere;
					endIndex = j;
				}
			}
			
			return Arrays.copyOfRange(array,startIndex,endIndex+1);
	}	
}
