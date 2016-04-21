package prefixCalcPkg;

import java.util.Scanner;


public class PrefixCalculatorImpl implements Calculator {

	@Override
	public Number calculate(String expression) {

		ExpressionTree calc;

		double result=0;

		if ( expression.length() > 0 )
		{
			System.out.println ("Processing string " + expression);

			String inStr = expression;

			if (!inStr.isEmpty()){
				inStr = inStr.replaceAll("[\\p{Ps}\\p{Pe}]", "");
			}

			calc = new ExpressionTree(new Scanner(inStr));

			System.out.println ("\nInput as prefix expression:");
			calc.showPreFix();
			//System.out.println ("\nValue: " + calc.evaluate());
			result=calc.evaluate();
		}
		return result;
	}
}
