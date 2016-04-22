
import java.util.Scanner;

public class PrefixCalculatorImpl implements Calculator {

	/**
	 * Calculate the result of input expression by building corresponding binary
	 * expression tree.
	 * 
	 * @param input
	 *            the input expression
	 * @return result of the expression evaluation
	 */
	public Number calculate(String expression) {
		ExpressionTree calc;
		double result = 0;

		if (expression.length() > 0) {
			String inStr = expression;

			// Remove parenthesis from the input string
			if (!inStr.isEmpty()) {
				inStr = inStr.replaceAll("[\\p{Ps}\\p{Pe}]", "");
			}

			calc = new ExpressionTree(new Scanner(inStr));

			result = calc.evaluate();
		}
		return result;
	}
}