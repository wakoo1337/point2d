public class Point2D {
    private double x, y;
    public Point2D(double new_x, double new_y) {
        x = new_x;
        y = new_y;
    }
    public Point2D() {
        this(0, 0);
    }
    public Point2D(Point2D a, double factor) {
        x = a.getX() * factor;
        y = a.getY() * factor;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double new_x) {
        x = new_x;
    }
    public void setY(double new_y) {
        y = new_y;
    }
    public boolean equals(Point2D second) {
        return (x == second.getX()) && (y == second.getY());
    }
    public double distanceTo(Point2D second) {
        return java.lang.Math.sqrt(java.lang.Math.pow(x - second.getX(), 2.0) + java.lang.Math.pow(y - second.getY(), 2.0));
    }
    public double distanceTo() {
        return distanceTo(new Point2D());
    }
    public static double computeArea(Point2D a, Point2D b, Point2D c) {
        Point2D ab_vec = new Point2D(b.getX() - a.getX(), b.getY() - a.getY());
        Point2D ab_mid = new Point2D(a.getX() + (ab_vec.getX() * 0.5), a.getY() + (ab_vec.getY() * 0.5));
        Point2D c_ab   = new Point2D(c.getX() - ab_mid.getX(), c.getY() - ab_mid.getY());
        return 0.5*ab_vec.distanceTo()*c_ab.distanceTo();
    }
    public static boolean equalPair(Point2D a, Point2D b, Point2D c) {
        return a.equals(b) || b.equals(c) || c.equals(a);
    }
    public double dotProduct(Point2D second) {
        return (x * second.getX()) + (y * second.getY());
    }
    public static boolean oneLine(Point2D a, Point2D b, Point2D c) {
        Point2D ab = new Point2D(b.getX() - a.getX(), b.getY() - a.getY());
        Point2D bc = new Point2D(c.getX() - b.getX(), c.getY() - b.getY());
        Point2D ca = new Point2D(a.getX() - c.getX(), a.getY() - c.getY());

        return (ab.dotProduct(bc) == (bc.distanceTo() * ab.distanceTo())) || (bc.dotProduct(ca) == (bc.distanceTo() * ca.distanceTo())) || (ca.dotProduct(ab) == (ca.distanceTo() * ab.distanceTo())); // С double нельзя так делать
    }
}
