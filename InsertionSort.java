/*
 * What is insertion sort ?
 * Insertion sort is a sorting techinque that we using while sorting playing card
 * 
 * In insertion sort we select an item and compare it with the item to its left until it is less than or equal to one of item in its left 
 * 
 * 
 * 
 * 
 * */


public class InsertionSort{
	public static void sortByInsertion(int[]arrayToBeSorted){
		int length = arrayToBeSorted.length;
		
		for(int index = 1; index < length ;index++){
			int key = arrayToBeSorted[index];
			int comparisonAtEveryPass = 0;
			int j = index-1;
			while(j>=0 && (arrayToBeSorted[j] > key))
			{
				int temp = arrayToBeSorted[j+1];
				arrayToBeSorted[j+1] = arrayToBeSorted[j];
				arrayToBeSorted[j] = temp;
					j--;
					comparisonAtEveryPass++;
			}
		//	array at every step 
		for(int item : arrayToBeSorted){
			System.out.print(item +"\t");
			}
			System.out.print(comparisonAtEveryPass +"\n");
		
			
				
	}
}	
	public static void main(String[]args){
		int array[] = new int[]{31,41,59,26,41,58};
		sortByInsertion(array);
		System.out.println("Array after sorting : ");
		for(int item : array){
			System.out.print(item +"\t");
			}
		System.out.println("");	
		}
	}
