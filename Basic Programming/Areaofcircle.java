import java.util.Scanner;
public class Areaofcircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of circle :");
        double circle = sc.nextDouble();
        double Area = 3.14*(circle*circle);
        System.out.println("The area of circle is :"+Area);
        sc.close();
    }
}
