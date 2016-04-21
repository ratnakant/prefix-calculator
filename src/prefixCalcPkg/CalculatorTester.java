package prefixCalcPkg;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTester {
	
	private static final String TEST_EXPRESSION_ONE = "(* (+ 2 3) (- 10 6))";

	@Test
	public void testExpressionOne(){
		Calculator calc = new PrefixCalculatorImpl();	
		Number result = calc.calculate(TEST_EXPRESSION_ONE);
		double expectedResult = ((2+3)*(10-6));
		assertEquals(expectedResult, result.doubleValue(),0);
	}
}
