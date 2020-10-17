// ID: 208387951

import java.util.Map;

/**
 * @author Raviv
 * The class receive an internal expressions and represents a negation operation action
 * The Neg class inherited from UnaryExpression.
 */

public class Neg extends UnaryExpression {

    /**
     * constructor with configurable expression.
     *
     * @param expression the current expression.
     */
    public Neg(Expression expression) {
        super(expression);
    }

    /**
     * evaluate -- Evaluate the expression using the variable values provided in the assignment,
     * and return the result. in this case we Performs the negation operation.
     *
     * @param assignment the map
     * @return negation -the negation operation
     * @throws Exception returning exception if can't do the function of calculating
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double negation = -(getExpression().evaluate(assignment));
        return negation;
    }

    /**
     * evaluate -- A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Evaluate the expression using the variable values provided in the assignment,
     * and return the result.  in this case we Performs the negation operation.
     *
     * @return negation -the negation operation
     * @throws Exception returning exception if can't do the function of calculating
     */
    @Override
    public double evaluate() throws Exception {
        double negation = -(getExpression().evaluate());
        return negation;
    }

    /**
     * currentSign -- Returns the sign of the current action.
     *
     * @return negation sign
     */
    @Override
    public String currentSign() {
        return "-";
    }

    /**
     * toString -- Returns a string representation of the expression.
     *
     * @return the string representation.
     */
    @Override
    public String toString() {
        //for the specific log case
        String string = "(" + currentSign() + getExpression().toString() + ")";
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
        Expression newExpression = getExpression().assign(var, expression);
        Expression fullExpression = new Neg(newExpression);
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
        Expression firstDifferentiateExpression = getExpression().differentiate(var);
        //calculating the negative of the differentiate of the expression
        Expression fullDifferentiateExpression = new Neg(firstDifferentiateExpression);
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
            Expression negSimplifyExpression = new Neg(simplifyExpression);
            double tryNewNeg = negSimplifyExpression.evaluate();
            return new Num(tryNewNeg);
        } catch (Exception exception) {
            return new Neg(simplifyExpression);
        }
    }
}
