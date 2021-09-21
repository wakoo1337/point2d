public class Point3D {
    private double x, y, z;
    public Point3D(double new_x, double new_y, double new_z) {
        x = new_x;
        y = new_y;
        z = new_z;
    }
    public Point3D() {
        this(0, 0, 0);
    }
    public Point3D(Point3D a, Point3D b) {
        x = b.getX() - a.getX();
        y = b.getY() - a.getY();
        z = b.getZ() - a.getZ();
    }
    public Point3D(Point3D a, double factor) {
        x = a.getX() * factor;
        y = a.getY() * factor;
        z = a.getZ() * factor;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    public void setX(double new_x) {
        x = new_x;
    }
    public void setY(double new_y) {
        y = new_y;
    }
    public void setZ(double new_z) {
        z = new_z;
    }
    public boolean equals(Point3D second) {
        return (x == second.getX()) && (y == second.getY()) && (z == second.getZ());
    }
    public double distanceTo(Point3D second) {
        return java.lang.Math.sqrt(java.lang.Math.pow(x - second.getX(), 2.0) + java.lang.Math.pow(y - second.getY(), 2.0) + java.lang.Math.pow(z - second.getZ(), 2.0));
    }
    public double distanceTo() {
        return distanceTo(new Point3D());
    }
    public static double computeArea(Point3D a, Point3D b, Point3D c) {
        Point3D ab_vec  = new Point3D(a, b);
        Point3D ac_vec  = new Point3D(a, c);

        return ab_vec.crossProduct(ac_vec).distanceTo()*0.5;
    }
    public static boolean equalPair(Point3D a, Point3D b, Point3D c) {
        return a.equals(b) || b.equals(c) || c.equals(a);
    }
    public Point3D crossProduct(Point3D second) {
        return new Point3D(y* second.getZ() - z* second.getY(), z* second.getX()-x* second.getZ(), x* second.getY()-y* second.getX());
    }
    public double dotProduct(Point3D second) {
        return x*second.getX() + y* second.getY() + z* second.getZ();
    }
    public static boolean oneLine(Point3D a, Point3D b, Point3D c) {
        Point3D ab = new Point3D(a, b);
        Point3D bc = new Point3D(b, c);
        Point3D ca = new Point3D(c, a);

        return (ab.dotProduct(bc) == (bc.distanceTo() * ab.distanceTo())) || (bc.dotProduct(ca) == (bc.distanceTo() * ca.distanceTo())) || (ca.dotProduct(ab) == (ca.distanceTo() * ab.distanceTo())); // С double нельзя так делать
    }
    public void Show() {
        System.out.println("X = " + x + " Y = " + y + " Z = " + z);
    };
}
