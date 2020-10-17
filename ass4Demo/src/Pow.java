// ID: 208387951

import java.util.Map;

/**
 * @author Raviv
 * The class receive two internal expressions and represents a pow operation action
 * The Pow class inherited from BinaryExpression.
 */

public class Pow extends BinaryExpression {
    private static final double ONE = 1.0;
    private static final String E = "e";

    /**
     * constructor with configurable firstExpression,secondExpression .
     *
     * @param firstExpression  the first expression.
     * @param secondExpression the second expression.
     */
    public Pow(Expression firstExpression, Expression secondExpression) {
        super(firstExpression, secondExpression);
    }

    /**
     * evaluate -- Evaluate the expression using the variable values provided in the assignment,
     * and return the result. in this case we Performs the pow operation.
     *
     * @param assignment the map
     * @return pow -the pow operation
     * @throws Exception the exception
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        //if the base is a negative number and the exponent is a fraction we want to throws exception
        if ((getSecondExpression().evaluate(assignment) > 0 && getSecondExpression().evaluate(assignment) < 1)
                && getFirstExpression().evaluate(assignment) < 0) {
            throw new Exception("Exception - illegal calculating sqrt to negative number");
        }
        double pow = Math.pow(getFirstExpression().evaluate(assignment), getSecondExpression().evaluate(assignment));
        return pow;
    }

    /**
     * evaluate -- A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Evaluate the expression using the variable values provided in the assignment,
     * and return the result.  in this case we Performs the subtraction operation.
     *
     * @return pow -the pow operation
     * @throws Exception the exception
     */
    public double evaluate() throws Exception {
        //if the base is a negative number and the exponent is a fraction we want to throws exception
        if ((getSecondExpression().evaluate() > 0 && getSecondExpression().evaluate() < 1)
                && getFirstExpression().evaluate() < 0) {
            throw new Exception("Exception - illegal calculating sqrt to negative number");
        }
        double pow = Math.pow(getFirstExpression().evaluate(), getSecondExpression().evaluate());
        return pow;
    }

    /**
     * currentSign -- Returns the sign of the current action.
     *
     * @return pow sign
     */
    @Override
    public String currentSign() {
        return "^";
    }

    /**
     * assign -- Returns a new expression in which all occurrences of the variable var are replaced with the
     * provided expression (Does not modify the current expression).
     *
     * @param var        the var we want to replace with the provided expression
     * @param expression the provided expression
     * @return expression the new expression after
     */
    @Override
    public Expression assign(String var, Expression expression) {
        Expression newFirstExpression = getFirstExpression().assign(var, expression);
        Expression newSecondExpression = getSecondExpression().assign(var, expression);
        //merging the two expressions
        Expression fullExpression = new Pow(newFirstExpression, newSecondExpression);
        return fullExpression;
    }

    /**
     * differentiate -- returns the expression tree resulting from differentiating the current
     * expression relative to variable `var`.
     *
     * @param var the var we want to differentiate  expression relative to it
     * @return expression tree resulting from differentiating the expression
     */
    @Override
    public Expression differentiate(String var) {
        Expression firstDifferentiateExpression = getFirstExpression().differentiate(var);
        Expression secondDifferentiateExpression = getSecondExpression().differentiate(var);
        //calculating the pow of the first expression by the second expression:  f(x)^g(x)
        Expression secondExpressionPow = new Pow(getFirstExpression(), getSecondExpression());
        //calculating the division of the second expression by the first expression:  g(x) / f(x)
        Expression divisionExpression = new Div(getSecondExpression(), getFirstExpression());
        //calculating the multiplication: f'(x) * (g(x) / f(x))
        Expression multiplicationExpression1 = new Mult(firstDifferentiateExpression, divisionExpression);
        //calculating the ln of the first expression:  ln (f(x))
        Expression lnFirstExpression = new Log(new Var(E), getFirstExpression());
        //calculating the multiplication: g'(x) * (ln (f(x))))
        Expression multiplicationExpression2 = new Mult(secondDifferentiateExpression, lnFirstExpression);
        //calculating the sum of MultiplicationExpression1 and MultiplicationExpression2:
        // (f'(x) * (g(x) / f(x))) + (g'(x) * (ln (f(x)))))
        Expression sumMultiplicationsExpression = new Plus(multiplicationExpression1, multiplicationExpression2);
        //merging the multiplication of the two expressions to one differentiate:
        //  (f(x)^g(x)) * ((f'(x) * (g(x) / f(x))) + (g'(x) * (ln (f(x))))))
        Expression fullDifferentiateExpression = new Mult(secondExpressionPow, sumMultiplicationsExpression);
        return fullDifferentiateExpression;
    }

    /**
     * simplify -- Returned a simplified version of the current expression.
     *
     * @return simplified version of the expression
     */
    @Override
    public Expression simplify() {
        //we want to support the simplification: X^1 = X
        if (getSecondExpression().simplify().toString().equals("1.0")) {
            Expression simplifyExpression = getFirstExpression().simplify();
            try {
                double tryNewDiv = simplifyExpression.evaluate();
                return new Num(tryNewDiv);
            } catch (Exception exception) {
                return simplifyExpression;
            }
        }
        //we want to support the simplification: 1^x = 1
        if (getFirstExpression().simplify().toString().equals("1.0")) {
            Expression simplifyExpression = new Num(ONE);
            return simplifyExpression;
        }
        //we want to support the simplification: X^1 = X
        if (getSecondExpression().simplify().toString().equals("0.0")) {
            Expression simplifyExpression = new Num(ONE);
            return simplifyExpression;
        }
        //we want to return the current expression with simplification on each expression.
        Expression firstSimplifyExpression = getFirstExpression().simplify();
        Expression secondSimplifyExpression = getSecondExpression().simplify();
        try {
            Expression simplifyExpression = new Pow(firstSimplifyExpression, secondSimplifyExpression);
            double tryNewPow = simplifyExpression.evaluate();
            return new Num(tryNewPow);
        } catch (Exception exception) {
            return new Pow(firstSimplifyExpression, secondSimplifyExpression);
        }
    }
}
