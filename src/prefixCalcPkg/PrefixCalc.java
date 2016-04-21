package prefixCalcPkg;

public class PrefixCalc
{
	public static void main ( String[] args )
	{
		Calculator myCalculator = new PrefixCalculatorImpl();

		if ( args.length > 0 )
		{
			Number result = myCalculator.calculate(args[0]);

			System.out.println ("\nResult: " + result.doubleValue());
		}
	}
} 