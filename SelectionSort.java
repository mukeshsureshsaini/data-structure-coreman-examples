/* What is selection sort ?
 *  
 * Selection sort is a sorting technique in which it select the smallest element from the array and insert it 1st position in first pass
 * since in first pass first element is sorted 
 * We again follow the same process i.e. find the smallest element but now we left the first element because it is already sorted ,
 * so we start from second element and in second pass second element is also sorted .
 * We follow the same  procedure until the second last element because when we reach the second last element,
 * we only need one comparison if applicable, hence last element will automatically sorted when we sorted the array till last element. 
 * 
 * */




public class SelectionSort{
	
	public static void main(String[]args){
		int array[] = new int[]{31,41,59,26,41,58};
		System.out.println("Array after sorting : ");
		sortBySelection(array);
		for(int item : array){
			System.out.print(item +"\t");
			}
		System.out.println("");	
		}
	
	public static void sortBySelection(int []arrayToBeSorted){
		
		int length = arrayToBeSorted.length;
		for(int index= 0;index < length-1;index++){
				int smallest = arrayToBeSorted[index] ; // first element is trivially smallest
				int smallestElementIndex = index;
				
				for(int j= index+1; j<length;j++){				// find the smallest in the array
					if(smallest> arrayToBeSorted[j]){
						smallest = arrayToBeSorted[j];
						smallestElementIndex = j;
						}
				}
				
				// swapping the smallest element with the array[index]
				
					int temp = arrayToBeSorted[index];
					arrayToBeSorted[index] = smallest;
					arrayToBeSorted[smallestElementIndex] = temp;
			
			}
		
		}
	}
