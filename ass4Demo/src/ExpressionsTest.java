// ID: 208387951

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Raviv
 * The class receive including a main method that Creates an expression, print this expression, Prints the value
 * of the expression , print the differentiated expression according to x, print the value of the differentiated
 * and print the simplified differentiated expression.
 */
public class ExpressionsTest {
    /**
     * main with configurable firstExpression- args.
     *
     * @param args  the args of the main
     */
    public static void main(String[] args) {
        Map<String, Double> assignment = new TreeMap<String, Double>();
        double valueOfExpression, valueOfDifferentiateExpression;
        //Create the expression (2x) + (sin(4y)) + (e^x).
        Expression expression = new Plus(new Plus(new Mult(new Num(2), new Var("x")), new Sin(new Mult(new Num(4),
                new Var("y")))), new Pow(new Var("e"), new Var("x")));
        //Print the expression
        System.out.println(expression.toString());
        //added the expressions: x,y,e with the values (x=2,y=0.25,e=2.71).
        assignment.put("x", (double) 2);
        assignment.put("y", 0.25);
        assignment.put("e", 2.71);
        //Print the value of the expression with (x=2,y=0.25,e=2.71).
        try {
            valueOfExpression = expression.evaluate(assignment);
            System.out.println(valueOfExpression);
        } catch (Exception exception) {
            System.out.println("exception- can't calculate the evaluate of the expression");
        }
        //Print the differentiated expression according to x.
        Expression differentiateExpression = expression.differentiate("x");
        System.out.println(differentiateExpression.toString());
        //Print the value of the differentiated expression according to x with the assignment above.
        try {
            valueOfDifferentiateExpression = differentiateExpression.evaluate(assignment);
            System.out.println(valueOfDifferentiateExpression);
        } catch (Exception exception) {
            System.out.println("exception- can't calculate the differentiated evaluate of the expression");
        }
        //Print the simplified differentiated expression.
        Expression simplifiedExpression = differentiateExpression.simplify();
        System.out.println(simplifiedExpression.toString());

    }
}
