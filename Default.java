import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;




public class Default {
	
	  public static int cookies(int k, List<Integer> A) {
	        if(A.isEmpty()) return -1;
	        if(A.size() == 1 && A.get(0) < k) return -1;
	        
	        Queue<Integer> pq = new PriorityQueue<Integer>();
	        for(Integer e : A){
	            pq.offer(e);
	        }
	        int noOfRemoves =0;
	    while(pq.size()> 1 &&  pq.peek() < k){
	        Integer x = pq.poll();
	        Integer y = pq.poll();
	        int r = x+2*y;
	        pq.offer(r);
	      //  System.out.println(pq);
	        noOfRemoves+=1;    
	    }
	    if(pq.peek() >=k) return noOfRemoves;
	    else return -1;

	}
    public static void main(String[] args) throws IOException {
    	ArrayList<Integer> l = new ArrayList<Integer>();
    	l.ensureCapacity(100000);
    	int x = -1;
    	while (++x < 100000) {
			
			l.add(1);
		}
    
    	System.out.println();
      
    	System.out.println(cookies(105823341, l));
    }
}
