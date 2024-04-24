import java.util.Scanner;

public class SumIntegers {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num1, num2;

    System.out.println(Fill in these two numbers:);
    num1 = input.next();
    num2 = input.nextInt();

    int sum = num1 + num2;
    System.out.println(The sum is: + sum);
  }
}