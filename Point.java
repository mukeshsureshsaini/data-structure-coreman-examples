package com.alpha.computational.geometry;

public class Point {
	private int x;
	private int y;
	private boolean isLeft;

	public Point(int x, int y, boolean isleft) {
		this.x = x;
		this.y = y;
		this.isLeft = isleft;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

}
