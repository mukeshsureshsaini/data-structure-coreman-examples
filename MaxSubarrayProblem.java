/***
 * 
 * Maximum Array Subarray Problem
 * An classic example of Divide and conquer
 * Maximum Array subproblem make sense when there are some negative elements in given array
 * 
 */
public class MaxSubarrayProblem{
	
	public static class MaxArrayDataContainer{
		
		private int leftIndex;
		private int rightIndex;
		private long maximumSum;
		
		public MaxArrayDataContainer(int leftIndex , int rightIndex ,long maximumSum){
				this.leftIndex = leftIndex;
				this.rightIndex = rightIndex;
				this.maximumSum = maximumSum;
			}
			
			public int getLeftIndex(){
					return this.leftIndex;
				}
			public int getRightIndex(){
					return this.rightIndex;
				}
			public long getMaximumSum(){
					return this.maximumSum;
				}
		}
		
	public static MaxArrayDataContainer getMaxSubarray(int [] array ,int leftIndex , int rightIndex){
		
			if(leftIndex == rightIndex){
				return new MaxArrayDataContainer(leftIndex,rightIndex,array[leftIndex]);
				}else{
					
					int midIndex = (int)Math.floor((leftIndex+rightIndex)/2.0);
					MaxArrayDataContainer leftContainer = getMaxSubarray(array ,leftIndex,midIndex);
					MaxArrayDataContainer rightContainer = getMaxSubarray(array,midIndex+1,rightIndex);
					MaxArrayDataContainer crossingContainer = getMaxSubarrayCrossing(array,leftIndex,midIndex,rightIndex);
					
					long leftContainerMaxSum = leftContainer.getMaximumSum();
					long rightContainerMaxSum = rightContainer.getMaximumSum();
					long crossingContainerMaxSum = crossingContainer.getMaximumSum();
					
					if(leftContainerMaxSum > rightContainerMaxSum && leftContainerMaxSum > crossingContainerMaxSum)
						return leftContainer;
					else if(rightContainerMaxSum > leftContainerMaxSum && rightContainerMaxSum > crossingContainerMaxSum)
							return rightContainer;
						
					else return crossingContainer;
						
		}
	}

		public static MaxArrayDataContainer getMaxSubarrayCrossing(int []array , int leftIndex , int midIndex, int rightIndex){
			
			long tempLeftSum = 0;
			long leftSum = 0;
			int tempLeftIndex = -999;
			long tempRightSum =0;
			long rightSum =0;
			int tempRightIndex = -999;
			for(int i = midIndex ; i >= leftIndex ; i--)
			{
					tempLeftSum += array[i];
					if(tempLeftSum > leftSum){
							leftSum = tempLeftSum;
							tempLeftIndex = i;
						}
			}
			
			for(int j = midIndex+1 ; j<= rightIndex ;j++){
					tempRightSum += array[j];
					if(tempRightSum > rightSum){
							rightSum = tempRightSum;
							tempRightIndex = j;
						}
				}
			
			return new MaxArrayDataContainer(tempLeftIndex , tempRightIndex , leftSum+rightSum);
			
			}
	
	
	public static void main(String [] args){
		int [] array = new int[]{13,-3,-25,20 ,-3 ,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		MaxArrayDataContainer data = getMaxSubarray(array ,0,array.length-1);
		
		System.out.println(data.getLeftIndex() + "----"+ data.getRightIndex()+"---"+ data.getMaximumSum());
		}
	
	
	
	}
