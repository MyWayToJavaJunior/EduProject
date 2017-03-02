package ru.operators;

/**
* Point.
* @author nik1202
* @since 08.02.2017
* @version 0.1
*/

public class Point {

	/**
	* Point.
	* Coordinat x.
	*/
	private double x;

	/**
	* Point.
	* Coordinat y.
	*/
	private double y;

	/**
	* Point.
	* @param x - coordinate x of point.
	* @param y - coordinate y of point.
	*/
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	* Getter for x.
	* @return x.
	*/
	public double getX() {
		return this.x;
	}

	/**
	* Getter for y.
	* @return y.
	*/
	public double getY() {
		return this.y;
	}

	/**
	* Point.
	* @param point - point.
	* @return distance between two points.
	*/
	public double distanceTo(Point point) {
		//calculate distance between two points
		return Math.sqrt(((this.x - point.getX()) * (this.x - point.getX())) + ((this.y - point.getY()) * (this.y - point.getY())));
	}
}