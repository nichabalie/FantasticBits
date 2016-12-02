
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
		System.err.println(" POSITION " + x +" " + y);
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
	
	/*public Point intersection(Point point2, Point point3, Point point4) {
		double d = (x-point2.x)*(point3.y-point4.y) - (y-point2.y)*(point3.x-point4.x);
		if (d == 0) return null;
		
		double xi = ((point3.x-point4.x)*(x*point2.y-y*point2.x)-(x-point2.x)*(point3.x*point4.y-point3.y*point4.x))/d;
		double yi = ((point3.y-point4.y)*(x*point2.y-y*point2.x)-(y-point2.y)*(point3.x*point4.y-point3.y*point4.x))/d;
		
		return new Point(xi,yi);
	}*/
	
	public Point intersection(Point point2, Point point3, Point point4)
	{
	    Point result = null;

	    double
	        s1_x = point2.x - x,
	        s1_y = point2.y - y,

	        s2_x = point4.x - point3.x,
	        s2_y = point4.y - point3.y,

	        s = (-s1_y * (x - point3.x) + s1_x * (y - point3.y)) / (-s2_x * s1_y + s1_x * s2_y),
	        t = ( s2_x * (y - point3.y) - s2_y * (x - point3.x)) / (-s2_x * s1_y + s1_x * s2_y);

	    if (s >= 0 && s <= 1 && t >= 0 && t <= 1)
	    {
	        // Collision detected
	        result = new Point(x + (t * s1_x),y + (t * s1_y));
	    }   // end if

	    return result;
	}
	
	/*
 float x12 = x1 - x2;
float x34 = x3 - x4;
float y12 = y1 - y2;
float y34 = y3 - y4;

float c = x12 * y34 - y12 * x34;

if (fabs(c) < 0.01)
{
  // No intersection
  return false;
}
else
{
  // Intersection
  float a = x1 * y2 - y1 * x2;
  float b = x3 * y4 - y3 * x4;

  float x = (a * x34 - b * x12) / c;
  float y = (a * y34 - b * y12) / c;

  return true;
}
	 */
	
}
