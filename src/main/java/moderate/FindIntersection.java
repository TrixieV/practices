package moderate;

public class FindIntersection {
    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(4, 4);
        Point p3 = new Point(-1, 1);
        Point p4 = new Point(-2, 2);

        Point p = intersection(p1,p2,p3,p4);
        System.out.println(p);
    }

    private static double[] lineEquation(Point p1, Point p2) {
        // tim a,b tu 2 phuong trinh y1 = ax1 + b, y2 = ax2 + b
        // phuong trinh duong thang la y = ax + b
        if (p1.getX() == p2.getX()) {
            return new double[]{0, 1, p1.getX()*(-1)};
        }

        if (p1.getY() == p2.getY()) {
            return new double[]{1, 0, p1.getY()};
        }

        if (p1.getX() == p2.getX() && p1.getY() == p2.getY()) {
            System.out.println("No unique line that go through 2 same points: " + p1 + " and " + p2);
            return null;
        }

        double a = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
        double b = p1.getY() - p1.getX()*a;
        return new double[]{1, a, b};

    }

    private static Point intersection(Point p1, Point p2, Point p3, Point p4) {
        // phuong trinh duong thang ay = bx + c
        double[] equation1 = lineEquation(p1, p2);
        double[] equation2 = lineEquation(p3, p4);
        if (equation2 == null || equation1 == null) {
            System.out.println("No line go through those 4 points");
            return null;
        }

        double a1 = equation1[0], b1 = equation1[1], c1 = equation1[2];
        double a2 = equation2[0], b2 = equation2[1], c2 = equation2[2];

        if (a1 == a2 && b1 == b2) {
            if (c1 != c2) {
                System.out.println("2 lines are paralleled");
                return null;
            } else {
                System.out.println("2 lines are the same");
                return null;
            }
        }

        double x = (c2 - c1) / (b1 - b2);
        double y = b1 * x + c1;
        return new Point(x, y);
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
