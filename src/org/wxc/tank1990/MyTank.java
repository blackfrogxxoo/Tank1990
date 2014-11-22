package org.wxc.tank1990;

public class MyTank {
	private int orientation;// 坦克的方向
	private int x;
	private int y;
	private int status;

	public MyTank() {
		setOrientation(Orientation.LEFT);
	}

	public void setOrientation(int ori) {
		this.orientation = ori;
	}

	public int getOrientation() {
		return this.orientation;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}
