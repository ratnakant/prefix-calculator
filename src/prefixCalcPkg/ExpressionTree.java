package prefixCalcPkg;

import java.util.Scanner; // Specific to Java 1.5.x

public class ExpressionTree
{

	private static class TreeNode
	{
		private final boolean leaf; // ?Is this a leaf? else internal
		private final char op; // For an internal node, the operator
		private double value; // For a leaf, the value
		private TreeNode left, // Left subexpression (internal node)
		right; // Right subexpression
		// Bare-bones constructor
		private TreeNode ( boolean leaf, char op, double value )
		{
			this.leaf = leaf;
			this.op = op;
			this.value = value;
			this.left = null; // Empty to start
			this.right = null;
		}
		// For leaf nodes, show the value; for internal, the operator.
		public String toString()// Overrides Object.toString, must be public.
		{ return leaf ? Double.toString(value) : Character.toString(op); }
	} 

	TreeNode root = null;
	public ExpressionTree ( Scanner input )
	{root = build(input); }
	/**
	 * Based on a white-space delimited prefix expression, build the
	 * corresponding binary expression tree.
	 * @param input The scanner with the expression
	 * @return reference to the corresponding binary expression tree
	 */
	private TreeNode build ( Scanner input )
	{
		boolean leaf;
		String token;
		double value;
		TreeNode node;
		
		leaf = input.hasNextDouble();
		if ( leaf )
		{
			value = input.nextDouble();
			node = new TreeNode ( leaf, '\0', value );
		}
		else
		{
			token = input.next();
			
			node = new TreeNode ( leaf, token.charAt(0), 0.0 );
			node.left = build ( input );
			node.right = build ( input );
			
		}
		return node;
	}
	
	/**
	 * Show the expression tree as a prefix expression.
	 * All the work is done in the private recursive method.
	 */
	public void showPreFix ()
	{
		showPreFix ( root );
		System.out.println();
	}
	// Prefix expression is the result of a pre-order traversal
	private void showPreFix ( TreeNode node )
	{ // NOTE: removing tail recursion
		while ( node != null )
		{
			System.out.print ( node + " " );
			showPreFix ( node.left );
			node = node.right; // Update parameter for right traversal
		}
	}

	
	/**
	 * Evaluate the expression and return its value.
	 * All the work is done in the private recursive method.
	 * @return the value of the expression tree.
	 */
	public double evaluate ()
	{ return root == null ? 0.0 : evaluate ( root ) ; }
	// Evaluate the expression: for internal nodes, this amounts
	// to a post-order traversal, in which the processing is doing
	// the actual arithmetic. For leaf nodes, it is simply the
	// value of the node.
	private double evaluate ( TreeNode node )
	{
		double result; // Value to be returned
		if ( node.leaf ) // Just get the value of the leaf
			result = node.value;
		else
		{
			// We've got work to do, evaluating the expression
			double left, right;
			char operator = node.op;
			// Capture the values of the left and right subexpressions
			left = evaluate ( node.left );
			right = evaluate ( node.right );
			// Do the arithmetic, based on the operator
			switch ( operator )
			{
			case '-': result = left - right; break;
			case '*': result = left * right; break;
			case '/': result = left / right; break;
			// NOTE: allow fall-through from default to case '+'
			default: System.out.println ("Unrecognized operator " +
					operator + " treated as +.");
			case '+': result = left + right; break;
			}
		}
		// Return either the leaf's value or the one we just calculated.
		return result;
	}
} 
