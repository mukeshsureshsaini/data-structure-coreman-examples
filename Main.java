package com.alpha.computational.geometry;

public class Main {

	public static void main(String[] args) {
		
		
		Point p1 = new Point(1, 1 ,true);
	    Point q1 = new Point(10, 1,false);
	    Point p2 = new Point(1, 2,true);
	    Point q2 = new Point(10, 2,false);
	 
	  System.out.println(TwoSegementIntersection.twoSegementIntersect(p1, q1, p2, q2));
	 
	    p1 = new Point(10, 1,true); q1 = new Point(0, 10,false);
	    p2 = new Point(0, 0,true); q2 = new Point(10, 10,false);
	    
	    System.out.println(TwoSegementIntersection.twoSegementIntersect(p1, q1, p2, q2));
	    
	 
	    p1 = new Point(-5, -5,true); q1 = new Point(0, 0,false);
	    p2 = new Point(1, 1,true); q2 = new Point(10, 10,false);
	    
	    System.out.println(TwoSegementIntersection.twoSegementIntersect(p1, q1, p2, q2));
	   
	}
}
