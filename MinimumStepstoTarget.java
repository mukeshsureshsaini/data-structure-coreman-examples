import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumStepstoTarget {

	public static int minSteps(int src , int target) {
		
		Queue<Entry> queue = new ArrayDeque<>();
		queue.offer(new Entry(src, 1));
		while (!queue.isEmpty()) {
			Entry e = queue.poll();
			if(e.value == target) return e.minSteps;
			else {
				queue.add(new Entry(e.value*2, e.minSteps+1));
				queue.add(new Entry(e.value-1, e.minSteps+1));
			}
			
		}
		return Integer.MIN_VALUE;
	}
	
	
	public static class Entry{
		
		int value;
		int minSteps;
		
		public Entry(int value,int minStep) {
			this.value = value;
			this.minSteps = minStep;
			
		}
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(minSteps(6, 8));
	}
	
	
}
