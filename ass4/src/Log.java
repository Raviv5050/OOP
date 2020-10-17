// ID: 208387951

import java.util.Map;

/**
 * @author Raviv
 * The class receive two internal expressions and represents a log operation action
 * The Log class inherited from BinaryExpression.
 */

public class Log extends BinaryExpression {

    private static final double ZIRO = 0.0;
    private static final double ONE = 1.0;
    private static final double POW_TWO = 2;
    private static final double BASE_TWO = 2;
    private static final String E = "e";

    /**
     * constructor with configurable firstExpression,secondExpression .
     *
     * @param firstExpression  the first expression.
     * @param secondExpression the second expression.
     */
    public Log(Expression firstExpression, Expression secondExpression) {
        super(firstExpression, secondExpression);
    }

    /**
     * evaluate -- Evaluate the expression using the variable values provided in the assignment,
     * and return the result. in this case we Performs the log operation.
     *
     * @param assignment the map with the variables.
     * @return log -the log operation
     * @throws Exception the exception
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        if (getFirstExpression().evaluate(assignment) == ONE) {
            throw new Exception("Exception - illegal log calculating (can't calculate log in base 1) ");
        } else if (getFirstExpression().evaluate(assignment) <= ZIRO
                || getSecondExpression().evaluate(assignment) <= ZIRO) {
            throw new Exception("Exception - illegal log calculating ");
        }
        //calculating by using: log(a, b)= log b / log a.
        double log = Math.log(getSecondExpression().evaluate(assignment))
                / Math.log(getFirstExpression().evaluate(assignment));
        return log;
    }

    /**
     * evaluate -- A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Evaluate the expression using the variable values provided in the assignment,
     * and return the result.  in this case we Performs the log operation.
     *
     * @return log -the log operation
     *@throws Exception the exception
     */
    public double evaluate() throws Exception {
        if (getFirstExpression().evaluate() == ONE) {
            throw new Exception("Exception - illegal log calculating (can't calculate log in base 1) ");
        } else if (getFirstExpression().evaluate() <= ZIRO || getSecondExpression().evaluate() <= ZIRO) {
            throw new Exception("Exception - illegal log calculating ");
        }
        //calculating by using: log(a, b)= log b / log a
        double log = Math.log(getSecondExpression().evaluate())
                / Math.log(getFirstExpression().evaluate());
        return log;
    }

    /**
     * currentSign -- Returns the sign of the current action.
     *
     * @return log sign
     */
    @Override
    public String currentSign() {
        return "log";
    }

    /**
     * toString -- Returns a string representation of the expression.
     *
     * @return the string representation.
     */
    @Override
    public String toString() {
        //for the specific log case
        String string = currentSign() + "(" + getFirstExpression().toString() + ", "
                + getSecondExpression().toString() + ")";
        return string;
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
        Expression fullExpression = new Log(newFirstExpression, newSecondExpression);
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
        //calculating the expression: f'(x)
        Expression secondDifferentiateExpression = getSecondExpression().differentiate(var);
        //calculating the ln of the first expression:  ln base
        Expression lnBaseExpression = new Log(new Var(E), getFirstExpression());
        //calculating the multiplication of the expression:  ln base * f(x)
        Expression firstMultDifferentiate = new Mult(lnBaseExpression, getSecondExpression());
        //calculating the division of the expression:  f'(x) / (ln base * f(x))
        Expression fullDifferentiateExpression = new Div(secondDifferentiateExpression, firstMultDifferentiate);
        return fullDifferentiateExpression;
    }

    /**
     * simplify -- Returned a simplified version of the current expression.
     *
     * @return simplified version of the expression
     */
    @Override
    public Expression simplify() {
        //we want to support the simplification: log(x, x) = 1
        if (getFirstExpression().simplify().toString().equals(getSecondExpression().simplify().toString())) {
            Expression simplifyExpression = new Num(ONE);
            return simplifyExpression;
        }
        //else we want to return the current expression with simplification on each expression.
        Expression firstSimplifyExpression = getFirstExpression().simplify();
        Expression secondSimplifyExpression = getSecondExpression().simplify();
        try {
            Expression simplifyExpression = new Log(firstSimplifyExpression, secondSimplifyExpression);
            double tryNewLog = simplifyExpression.evaluate();
            return new Num(tryNewLog);
        } catch (Exception exception) {
            return new Log(firstSimplifyExpression, secondSimplifyExpression);
        }
    }
}
