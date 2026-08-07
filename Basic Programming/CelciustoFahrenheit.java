import java.util.Scanner;
public class CelciustoFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the temp in Celcius :");
        float Celcius = sc.nextFloat();
        float Fahrenheit=(Celcius *9/5)+32;
        System.out.println("The temp in Fahrenheit is :"+ Fahrenheit);
        sc.close();
    
}
}