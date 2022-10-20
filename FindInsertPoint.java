
public class FindInsertPoint {

	
	 public static int bs(int [] nums , int lo , int hi , int target){
	        if(lo> hi) return -1;
	        
	        while(lo<=hi){
	            int mid = (lo+hi)/2;
	            if(nums[mid] == target) return mid;
	            else if(nums[mid] > target){
	                hi = mid-1;
	            }else{
	                lo = mid+1;
	            }
	        }
	        return ~(-(lo+1));
	    }
	 
	 
	 
	 public static void main(String[] args) {
		int arr[] = {1,3,4,5};
		System.out.println(bs(arr,0,arr.length-1,2));
	}
}
