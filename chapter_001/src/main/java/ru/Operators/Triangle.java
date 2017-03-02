package ru.operators;

/**
* Triangle.
* @author nik1202
* @since 08.02.2017
* @version 0.1
*/
public class Triangle {

	/**
	* Point a.
	*/
	private Point a;

	/**
	* Point b.
	*/
	private Point b;

	/**
	* Point b.
	*/
	private Point c;

	/**
	* @param a - point a.
	* @param b - point b.
	* @param c - point c.
	*/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	* @return area of triangle.
	*/
	public double area() {
		//calculate the triangle area
		double distanceAB = a.distanceTo(b);
		double distanceBC = b.distanceTo(c);
		double distanceAC = a.distanceTo(c);
		double result = 0;
		if (((distanceAB + distanceBC) <= distanceAC)
		 || ((distanceAC + distanceBC) <= distanceAB)
		 || ((distanceAB + distanceAC) <= distanceBC)) {
				result = -1;
		} else {
			double p = (distanceAB + distanceBC + distanceAC) / 2;
			result = Math.sqrt(p * (p - distanceAB) * (p - distanceBC) * (p - distanceAC));
		}
		return result;
	}
}