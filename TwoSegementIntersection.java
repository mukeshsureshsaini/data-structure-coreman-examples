package com.alpha.computational.geometry;

public class TwoSegementIntersection {

	public static boolean twoSegementIntersect(Point x1, Point y1, Point x2, Point y2) {

		int d1 = direction(x1, y1, x2);
		int d2 = direction(x1, y1, y2);

		int d3 = direction(x2, y2, x1);
		int d4 = direction(x2, y2, y1);

		if (isOppositeDirection(d1, d2) && isOppositeDirection(d3, d4))
			return true;
		if ((d1 == 0 && onSegment(x1, y1, x2)) || 
			(d2 == 0 && onSegment(x1, y1, y2)) || 
			(d3 == 0 && onSegment(x2, y2, x1)) || 
			(d4 == 0 && onSegment(x2, y2, y1)))
			return true;

		return false;

	}

	public static void main(String[] args) {

	}

	public static int direction(Point X, Point Y, Point Z) {
		int dx1 = Z.getX() - X.getX();
		int dy1 = Z.getY() - X.getY();

		int dx2 = Y.getX() - X.getX();
		int dy2 = Y.getY() - X.getY();

		return (dx1 * dy2) - (dx2 * dy1);

	}

	public static boolean isOppositeDirection(int d1, int d2) {
		if (isSameDirection(d1, d2) || d1 == 0 || d2 == 0)
			return false;
		return true;

	}

	public static boolean isSameDirection(int d1, int d2) {

		return (d1 > 0 && d2 > 0) || (d1 < 0 && d2 < 0);
	}

	// if point z is on segment via cross product
	public static boolean onSegment(Point X, Point Y, Point Z) {
		int x1 = X.getX();
		int y1 = X.getY();

		int x2 = Y.getX();
		int y2 = Y.getY();

		return inBetween(x1, x2, Z.getX()) && inBetween(y1, y2, Z.getY());
	}

	// check if z is in between x and y
	public static boolean inBetween(int x, int y, int z) {
		return Integer.min(x, y) >= z && Integer.max(x, y) <= z;
	}

}
