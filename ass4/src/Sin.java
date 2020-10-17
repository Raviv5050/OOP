// ID: 208387951

import java.util.Map;

/**
 * @author Raviv
 * The class receive an internal expressions and represents a sinus operation action
 * The Sin class inherited from UnaryExpression.
 */

public class Sin extends UnaryExpression {

    private static final double ZERO = 0.0;

    /**
     * constructor with configurable expression.
     *
     * @param expression the current expression.
     */
    public Sin(Expression expression) {
        super(expression);
    }

    /**
     * evaluate -- Evaluate the expression using the variable values provided in the assignment,
     * and return the result. in this case we Performs the sinus operation.
     *
     * @param assignment the map
     * @return sinus -the sinus operation
     * @throws Exception the exception
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double sinus = Math.sin(Math.toRadians(getExpression().evaluate(assignment)));
        return sinus;
    }

    /**
     * evaluate -- A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Evaluate the expression using the variable values provided in the assignment,
     * and return the result.  in this case we Performs the sinus operation.
     *
     * @return sinus -the sinus operation
     * @throws Exception the exception
     */
    @Override
    public double evaluate() throws Exception {
        double sinus = Math.sin(Math.toRadians(getExpression().evaluate()));
        return sinus;
    }

    /**
     * currentSign -- Returns the sign of the current action.
     *
     * @return sinus sign
     */
    @Override
    public String currentSign() {
        return "sin";
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
        Expression newExpression = getExpression().assign(var, expression);
        Expression fullExpression = new Sin(newExpression);
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
        Expression cosExpression = new Cos(getExpression());
        Expression differentiateExpression = getExpression().differentiate(var);
        //merging the two expressions to one differentiate by calculating the multiplication.
        Expression fullDifferentiateExpression = new Mult(differentiateExpression, cosExpression);
        return fullDifferentiateExpression;
    }

    /**
     * simplify -- Returned a simplified version of the current expression.
     *
     * @return simplified version of the expression
     */
    @Override
    public Expression simplify() {
        //we want to return the current expression with simplification on the expression.
        Expression simplifyExpression = getExpression().simplify();
        try {
            Expression sinSimplifyExpression = new Sin(simplifyExpression);
            double tryNewSin = sinSimplifyExpression.evaluate();
            return new Num(tryNewSin);
        } catch (Exception exception) {
            return new Sin(simplifyExpression);
        }
    }
}
