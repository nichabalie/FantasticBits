
class Point {
	protected double x;
	protected double y;
	
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public double distance2(Point point) {
		return (this.x-point.x)*(this.x-point.x) + (this.y-point.y)*(this.y-point.y);
	}
	
	public double distance(Point point) {
		return Math.sqrt(distance2(point));
	}
	
	/*
	 * Return true if current entity is between the two other in axis X
	 */
	public boolean isBetweenInX(Point point1, Point point2) {
		if(point1.getX()<this.getX() && point2.getX() > this.getX()) {
			return true;
		}
		if(point1.getX()>this.getX() && point2.getX() < this.getX()) {
			return true;
		}
		return false;
	}
	
	public void print() {
		System.err.println("POSITION " + x +" " + y);
	}

	public boolean isInsideGame() {
		if(this.x < 16000 && this.x > 0) {
			if(this.y < 7500 && this.y > 0) {
				return true;
			}
		}
		return false;
	}
	
	
	Point closest(Point a, Point b) {
	    double da = b.y - a.y;
	    double db = a.x - b.x;
	    double c1 = da*a.x + db*a.y;
	    double c2 = -db*this.x + da*this.y;
	    double det = da*da + db*db;
	    double cx = 0;
	    double cy = 0;

	    if (det != 0) {
	        cx = (da*c1 - db*c2) / det;
	        cy = (da*c2 + db*c1) / det;
	    } else {
	        // The point is already on the line
	        cx = this.x;
	        cy = this.y;
	    }

	    return new Point(cx, cy);
	}
	
}
