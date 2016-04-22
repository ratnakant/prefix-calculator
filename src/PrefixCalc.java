import java.util.Scanner;

public class PrefixCalc {

	public static void main(String[] args) {
		System.out.print("Enter Prefix Expression: ");
		Scanner sc = new Scanner(System.in);
		String inString = sc.nextLine();
		Calculator myCalculator = new PrefixCalculatorImpl();

		Number result = myCalculator.calculate(inString);

		System.out.println("\nResult: " + result.doubleValue());

		sc.close();
	}
}