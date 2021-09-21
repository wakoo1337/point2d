import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input_scan = new Scanner(System.in);
        System.out.println("Программа для работы с треугольниками");
        double x, y, z;
        System.out.print("Введите через пробел координаты 1-ой точки: ");
        x = input_scan.nextDouble();
        y = input_scan.nextDouble();
        z = input_scan.nextDouble();
        Point3D first = new Point3D(x, y, z);
        first.Show();

        System.out.print("Введите через пробел координаты 2-ой точки: ");
        x = input_scan.nextDouble();
        y = input_scan.nextDouble();
        z = input_scan.nextDouble();
        Point3D second = new Point3D(x, y, z);
        second.Show();

        System.out.print("Введите через пробел координаты 3-й  точки: ");
        x = input_scan.nextDouble();
        y = input_scan.nextDouble();
        z = input_scan.nextDouble();
        Point3D third = new Point3D(x, y, z);
        third.Show();

        input_scan.close();

        if (Point3D.equalPair(first, second, third)) {
            System.out.println("Не может быть двух одинаковых точек");
            System.exit(0);
        }

        if (Point3D.oneLine(first, second, third)) {
            System.out.println("Все 3 точки не могут лежать на одной прямой");
            System.exit(0);
        }

        System.out.println("Площадь треугольника составляет " + Point3D.computeArea(first, second, third));
    }
}
