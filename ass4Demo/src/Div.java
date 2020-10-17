// ID: 208387951

import java.util.Map;

/**
 * @author Raviv
 * The class receive two internal expressions and represents a division operation action
 * The Div class inherited from BinaryExpression.
 */

public class Div extends BinaryExpression {

    private static final double ZERO = 0.0;
    private static final double SQRT_TWO = 2;
    private static final double ONE = 1;

    /**
     * constructor with configurable firstExpression,secondExpression .
     *
     * @param firstExpression  the first expression.
     * @param secondExpression the second expression.
     */
    public Div(Expression firstExpression, Expression secondExpression) {
        super(firstExpression, secondExpression);
    }

    /**
     * evaluate -- Evaluate the expression using the variable values provided in the assignment,
     * and return the result. in this case we Performs the division operation
     *
     *  @param assignment the map with the vatiables.
     * @return division -the division operation
     * @throws Exception return the exception
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        if (getSecondExpression().evaluate(assignment) == ZERO) {
            throw new Exception("Exception - it's illegal dividing in zero");
        }
        double division = getFirstExpression().evaluate(assignment) / getSecondExpression().evaluate(assignment);
        return division;
    }

    /**
     * evaluate -- A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Evaluate the expression using the variable values provided in the assignment,
     * and return the result.  in this case we Performs the division operation.
     *
     * @return division -the division operation
     * @throws Exception return the exception
     */
    @Override
    public double evaluate() throws Exception {
        if (getSecondExpression().evaluate() == ZERO) {
            throw new Exception("Exception - it's illegal dividing in zero");
        }
        double division = getFirstExpression().evaluate() / getSecondExpression().evaluate();
        return division;
    }

    /**
     * currentSign -- Returns the sign of the current action.
     *
     * @return division sign
     */
    @Override
    public String currentSign() {
        return " / ";
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
        Expression fullExpression = new Div(newFirstExpression, newSecondExpression);
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
        //calculating each side of the multiplication.
        Expression firstMultDifferentiate = new Mult(firstDifferentiateExpression, getSecondExpression());
        Expression secondMultDifferentiate = new Mult(getFirstExpression(), secondDifferentiateExpression);
        //difference the two expressions
        Expression differenceDifferentiateExpression = new Minus(firstMultDifferentiate, secondMultDifferentiate);
        //calculating the the pow of the second expression
        Expression secondExpressionPow = new Pow(getSecondExpression(), new Num(SQRT_TWO));
        //merging the two expressions to one differentiate
        Expression fullDifferentiateExpression = new Div(differenceDifferentiateExpression, secondExpressionPow);
        return fullDifferentiateExpression;
    }

    /**
     * simplify -- Returned a simplified version of the current expression.
     *
     * @return simplified version of the expression
     */
    @Override
    public Expression simplify() {
        //we want to support the simplification: X / 1 = X
        if (getSecondExpression().simplify().toString().equals("1.0")) {
            Expression simplifyExpression = getFirstExpression().simplify();
            try {
                double tryNewDiv = simplifyExpression.evaluate();
                return new Num(tryNewDiv);
            } catch (Exception exception) {
                return simplifyExpression;
            }
        }
        //we want to support the simplification: 0 / X = 0
        if (getFirstExpression().simplify().toString().equals("0.0")) {
            Expression simplifyExpression = new Num(ZERO);
            return simplifyExpression;
        //if the expression isn't equal to 0, we want to support the simplification: x / x = 1
        } else if ((getFirstExpression().simplify().toString().equals(getSecondExpression().simplify().toString()))
                && (!getFirstExpression().toString().equals("0.0"))) {
            Expression simplifyExpression = new Num(ONE);
            return simplifyExpression;
        //if the expression isn't equal to 0, we want to support the simplification: -x / x = -1
        } else if (((new Neg(getFirstExpression().simplify())).toString()
                .equals(getSecondExpression().simplify().toString()))
                && (!getFirstExpression().toString().equals("0.0"))) {
            Expression simplifyExpression = new Num(-ONE);
            return simplifyExpression;
        //if the expression isn't equal to 0, we want to support the simplification: x / -x = -1
        } else if (((new Neg(getSecondExpression().simplify())).toString()
                .equals(getFirstExpression().simplify().toString()))
                && (!getFirstExpression().toString().equals("0.0"))) {
            Expression simplifyExpression = new Num(-ONE);
            return simplifyExpression;
        }
        //else we want to return the current expression with simplification on each expression.
        Expression firstSimplifyExpression = getFirstExpression().simplify();
        Expression secondSimplifyExpression = getSecondExpression().simplify();
        try {
            Expression simplifyExpression = new Div(firstSimplifyExpression, secondSimplifyExpression);
            double tryNewDiv = simplifyExpression.evaluate();
            return new Num(tryNewDiv);
        } catch (Exception exception) {
            return new Div(firstSimplifyExpression, secondSimplifyExpression);
        }
    }
}
